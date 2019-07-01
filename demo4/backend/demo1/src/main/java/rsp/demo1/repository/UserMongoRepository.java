package rsp.demo1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rsp.demo1.entity.UserImage;

public interface UserMongoRepository extends MongoRepository<UserImage, Long> {
}
