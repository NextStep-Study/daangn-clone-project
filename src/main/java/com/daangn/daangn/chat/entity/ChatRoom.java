package com.daangn.daangn.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@Entity
@Table(name = "chatroom")
@NoArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_id")
    private Long id; // 채팅방 아이디

    // 방 이름
    private String roomName;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<Chat> chats = new HashSet<>();

    @Builder
    public ChatRoom(Long id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }
}
