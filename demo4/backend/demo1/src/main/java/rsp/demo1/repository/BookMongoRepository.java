package rsp.demo1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rsp.demo1.entity.BookImage;

public interface BookMongoRepository extends MongoRepository<BookImage, Long> {
}
