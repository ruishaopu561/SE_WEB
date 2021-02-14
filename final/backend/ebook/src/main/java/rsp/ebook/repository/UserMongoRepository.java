package rsp.ebook.repository;

import rsp.ebook.entity.UserImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserImage, Long> {
}
