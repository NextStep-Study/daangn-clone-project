package com.danggun.chat.domain.chat;

import com.danggun.chat.domain.chat.types.ChatType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@Table(name = "chat")
@Entity
public class Chat {
    // 사용자가 입장, 퇴장 할 때에 대한 메시지와
    // 사용자 끼리 대화하는 TALK 두 가지로 메시지 타입을 나눈다.
    @Enumerated(EnumType.STRING)
    private ChatType type; // 메세지 타입

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    //연관 관계에 있는 Entity 들 모두 가져온다 → Eager 전략
    //연관 관계에 있는 Entity 가져오지 않고, getter 로 접근할 때 가져온다 → Lazy 전략
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="chatroom_id")
    private ChatRoom room; // 방 번호
    private String content; // 내용

    private String sender;
    private LocalDateTime send_time;// 발송시간


    @Builder
    public Chat(ChatType type, Long id, ChatRoom room, String content, String sender, LocalDateTime send_time) {
        this.type = type;
        this.id = id;
        this.room = room;
        this.content = content;
        this.sender = sender;
        this.send_time = send_time;
    }
}
