package fpt.developer.crawl_data_from_fap.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DriverConfig {
    @Bean
    @Scope("singleton")
    WebDriver webDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    WebDriverWait webDriverWait(){
        return new WebDriverWait(webDriver(), 5);
    }
}
