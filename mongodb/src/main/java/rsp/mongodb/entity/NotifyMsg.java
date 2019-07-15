package rsp.mongodb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "msg")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyMsg implements Serializable {

    private static final long serialVersionUID = -8985545025018238754L;

    @Id
    String id;

    @Indexed
    String notifyType;

    @Indexed
    String notifyNo;

    String notifyDate;

    @Field("notifyMsg")
    String notifyMsg;

    @CreatedDate
    Date gmtCreate;
}
