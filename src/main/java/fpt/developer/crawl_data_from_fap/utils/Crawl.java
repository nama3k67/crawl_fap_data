package fpt.developer.crawl_data_from_fap.utils;

import fpt.developer.crawl_data_from_fap.entities.New;
import fpt.developer.crawl_data_from_fap.services.NewService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Crawl {
    @Autowired
    private NewService newService;

    @Scheduled(initialDelay = 10*1000, fixedDelay = 24*60*60*1000)
    public void check() throws ParseException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        String baseUrl = "http://fap.fpt.edu.vn/Default.aspx";
        webDriver.get(baseUrl);
        String parentWindow = webDriver.getWindowHandle();

        Select element = new Select(webDriver.findElement(By.id("ctl00_mainContent_ddlCampus")));
        element.selectByVisibleText("FU-Đà Nẵng");

        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"loginform\"]/center/div/div[2]/div/div/div"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element1)).click();

        Set<String> s1 = webDriver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String nextTab = i1.next();
            if (!parentWindow.equalsIgnoreCase(nextTab)) {
                webDriver.switchTo().window(nextTab);
                System.out.println(nextTab);
                WebDriverWait wait = new WebDriverWait(webDriver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId"))).sendKeys("namtpde140009@fpt.edu.vn");
                webDriver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
            }
        }

        s1 = webDriver.getWindowHandles();
        i1 = s1.iterator();

        while (i1.hasNext()) {
            String nextTab = i1.next();
            if (!parentWindow.equalsIgnoreCase(nextTab)) {
                webDriver.switchTo().window(nextTab);
                System.out.println(nextTab);

                WebDriverWait wait = new WebDriverWait(webDriver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("Nama3k67");
                webDriver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
            }
        }
        webDriver.switchTo().window(parentWindow);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_mainContent_ucCmsNews1_divCMS\"]/b/a"))).click();

        List<WebElement> listUrl = webDriver.findElements(By.xpath("//*[@id=\"ctl00_mainContent_divContent\"]/ul/li/a"));
        Map<String, String> result = new HashMap<>();
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        String title;
        for (WebElement e : listUrl) {
            title = e.getText();
            e.sendKeys(selectLinkOpeninNewTab);
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));

            WebDriverWait wait1 = new WebDriverWait(webDriver, 20);
            String content = wait1.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_divContent\"]")))).getAttribute("innerHTML");

            result.put(title, content);
            webDriver.close();
            webDriver.switchTo().window(tabs.get(0));
            if (listUrl.indexOf(e)==5)
                break;
        }

        List<New> news = new ArrayList<>();
        Set keys = result.keySet();
        String pattern = "dd/MM/yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (Object key : keys){
            String[] s = ((String)key).split("•");
            news.add(new New(simpleDateFormat.parse(s[0]), s[1], result.get(key)));
        }

        newService.saveAll(news);
        webDriver.quit();
    }
}
