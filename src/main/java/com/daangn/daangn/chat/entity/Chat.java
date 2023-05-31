package com.daangn.daangn.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "chat")
@NoArgsConstructor
@ToString
public class Chat {
    @Enumerated(EnumType.STRING)
    private ChatType type; // 메세지 타입

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom room; // 방 정보

    private String message; // 내용
    private String sender;

    private LocalDateTime sentAt; // 발송 시간

    @Builder
    public Chat(ChatType type, Long id, ChatRoom room, String message, String sender, LocalDateTime sentAt) {
        this.type = type;
        this.id = id;
        this.room = room;
        this.message = message;
        this.sender = sender;
        this.sentAt = sentAt;
    }
}
