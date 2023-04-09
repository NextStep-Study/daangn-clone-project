package com.daangn.daangn.domain.chat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "chatroom")
public class ChatRoom {
    @Id
    @GeneratedValue
    private Long roomId; // 채팅방 아이디
    private int pr_id; // 물품 id
    private int pr_state; // 판매 상태 id
    private String sellerId; // 판매자 아이디
    private String buyerId; // 구매자 아이디
    private String createdDate; // 채팅방 생성 시간
    private String sellerName; // 판매자 닉네임
    private String buyerName; // 구매자 닉네임
    //not in DB
    private String pr_title;
}
