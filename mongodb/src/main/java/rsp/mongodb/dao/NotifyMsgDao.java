package rsp.mongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import rsp.mongodb.entity.NotifyMsg;

public interface NotifyMsgDao extends MongoRepository<NotifyMsg, String> {
    NotifyMsg findByNotifyNo(String notifyno);

    @Query("{'notifyDate':?0}")
    Page<NotifyMsg> queryBySql(String notifyDate, Pageable pageable);
}
