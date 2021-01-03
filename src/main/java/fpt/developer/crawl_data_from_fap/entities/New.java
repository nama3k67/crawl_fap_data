package fpt.developer.crawl_data_from_fap.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "news")
public class New {
    @Id
    private String id;

    public New(Date date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }
    public New(){}
    private Date date;
    private String title;
    private String content;

}
