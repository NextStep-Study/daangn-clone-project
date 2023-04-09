package com.daangn.daangn.repository.chat;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

//@Data
// Getter, Setter, RequiredArgsConstructor, ToString을 한번에 설정해준다.
//@Builder
// 순서를 정해주는 객체 패턴
public class ChatDTO {
    // 사용자가 입장, 퇴장 할 때에 대한 메시지와
    // 사용자 끼리 대화하는 TALK 두 가지로 메시지 타입을 나눈다.
    public enum MessageType{
        ENTER, OUT ,TALK
    }

    private MessageType type; // 메세지 타입
    private String roomId; // 방 번호
    private String sender; // 채팅을 보낸 사람
    private String message; // 메시지
    private String time; // 채팅 발송 시간
}
