package fpt.developer.crawl_data_from_fap;

import fpt.developer.crawl_data_from_fap.utils.Crawl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.ParseException;

@SpringBootApplication
@EnableScheduling
public class CrawlDataFromFapApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrawlDataFromFapApplication.class, args);
    }

}
