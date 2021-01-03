package fpt.developer.crawl_data_from_fap.apis;

import fpt.developer.crawl_data_from_fap.services.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news-api")
public class NewApi {
    @Autowired
    private NewService newService;

    @GetMapping
    public ResponseEntity<?> getAllNews(){
        return ResponseEntity.ok(newService.findAll());
    }
}
