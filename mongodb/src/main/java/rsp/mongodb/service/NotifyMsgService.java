package rsp.mongodb.service;

import java.util.List;
import rsp.mongodb.entity.NotifyMsg;

public interface NotifyMsgService {

    NotifyMsg saveNotifyMsg(NotifyMsg msg);

    NotifyMsg findNotifyMsgByNo(String notifyNo);

    List<NotifyMsg> findNotifyMsgByDate(String notifyDate);

    NotifyMsg delNotifyMsgById(String id);

}
