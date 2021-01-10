package fpt.developer.crawl_data_from_fap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrawlDataFromFapApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrawlDataFromFapApplication.class, args);
    }

}
