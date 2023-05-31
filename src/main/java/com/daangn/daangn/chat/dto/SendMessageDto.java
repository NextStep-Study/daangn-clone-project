package com.daangn.daangn.chat.dto;

import com.daangn.daangn.chat.entity.ChatRoom;
import com.daangn.daangn.chat.entity.ChatType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SendMessageDto {

    @Enumerated(EnumType.STRING)
    private ChatType type; // 메세지 타입

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;


    private String roomId;
    private String message; // 내용
    private String sender;

    private LocalDateTime sentAt; // 발송 시간
}
