package fpt.developer.crawl_data_from_fap.repository;

import fpt.developer.crawl_data_from_fap.entities.New;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends MongoRepository<New, String> {
}
