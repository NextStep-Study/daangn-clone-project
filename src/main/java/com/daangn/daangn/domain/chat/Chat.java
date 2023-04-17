package com.daangn.daangn.domain.chat;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    @Id
    @GeneratedValue
    private Long id;

    //연관 관계에 있는 Entity 들 모두 가져온다 → Eager 전략
    //연관 관계에 있는 Entity 가져오지 않고, getter 로 접근할 때 가져온다 → Lazy 전략
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="chatroom_id")
    private ChatRoom room; // 방 번호
    private String sender; // 채팅을 보낸 사람
    private String message; // 메시지
    private String time; // 채팅 발송 시간

    // 회원 entity를 받아와서 get으로 값을 가져올거라 예상
}
