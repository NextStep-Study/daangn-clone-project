package com.daangn.daangn.domain.chat;

import com.daangn.daangn.repository.chat.ChatDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Table(name = "chat")
@Entity
public class Chat {
    // 사용자가 입장, 퇴장 할 때에 대한 메시지와
    // 사용자 끼리 대화하는 TALK 두 가지로 메시지 타입을 나눈다.
    public enum MessageType{
        ENTER, OUT ,TALK
    }

    private ChatDTO.MessageType type; // 메세지 타입
    @Id
    @GeneratedValue
    private Long roomId; // 방 번호
    private String sender; // 채팅을 보낸 사람
    private String message; // 메시지
    private String time; // 채팅 발송 시간
}
