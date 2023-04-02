package com.daangn.chat.danngn.model.dto;

import com.daangn.chat.daanggn.service.ChatService;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
public class ChatRoom {
    private String roomId; // 채팅방 아이디
    private int pr_id; // 물품 id
    private int pr_state; // 판매 상태 id
    private String sellerId; // 판매자 아이디
    private String buyerId; // 구매자 아이디
    private Timestamp createdDate; // 채팅방 생성 시간
    private String sellerName; // 판매자 닉네임
    private String buyerName; // 구매자 닉네임
    //not in DB
    private String pr_title;

    // 사용자가 누군지 확인을 해야한다. --> session을 이용한다.
    private Set<WebSocketSession> sessions = new HashSet<>();


    @Builder
    public ChatRoom(String roomId, int pr_id, int pr_state, String sellerId, String buyerId, Timestamp createdDate, String sellerName, String buyerName, String pr_title, Set<WebSocketSession> sessions) {
        this.roomId = roomId;
        this.pr_id = pr_id;
        this.pr_state = pr_state;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.createdDate = createdDate;
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.pr_title = pr_title;
        this.sessions = sessions;
    }



    public void handleAction(WebSocketSession session, ChatDTO message, ChatService service) {
        // message 에 담긴 타입을 확인한다.
        // 이때 message 에서 getType 으로 가져온 내용이
        // ChatDTO 의 열거형인 MessageType 안에 있는 ENTER 과 동일한 값이라면
        if (message.getType().equals(ChatDTO.MessageType.ENTER)) {
            // sessions 에 넘어온 session 을 담고,
            sessions.add(session);

            // message 에는 입장하였다는 메시지를 띄운다
            message.setMessage(message.getSender() + " 님이 입장하셨습니다");
            sendMessage(message, service);
        } else if (message.getType().equals(ChatDTO.MessageType.ENTER)) {
            // sessions 에 넘어온 session 을 담고,
            sessions.add(session);

            // message 에는 입장하였다는 메시지를 띄운다
            message.setMessage(message.getSender() + " 님이 입장하셨습니다");
            sendMessage(message, service);
        } else if (message.getType().equals(ChatDTO.MessageType.TALK)) {
            message.setMessage(message.getMessage());
            sendMessage(message, service);
        }
    }

    public <T> void sendMessage(T message, ChatService service) {
        // 메시지 보내기
    }
}
