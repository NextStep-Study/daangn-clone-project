package com.daangn.daangn.domain.chat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.*;
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
    @Column(name = "chatroom_id")
    private Long Id; // 채팅방 아이디
    private int pr_id; // 물품 id
    private int pr_state; // 판매 상태 id
    private String sellerId; // 판매자 아이디
    private String buyerId; // 구매자 아이디
    private String createdDate; // 채팅방 생성 시간
    private String sellerName; // 판매자 닉네임
    private String buyerName; // 구매자 닉네임
    //not in DB
    private String pr_title;

    // 영속성 설정
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<Chat> chat = new HashSet<>();
}
