package rsp.ebook.repository;

import rsp.ebook.entity.BookImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoRepository extends MongoRepository<BookImage, Long> {
}
