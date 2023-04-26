package com.daangn.daangn.domain.chat;


import com.daangn.daangn.domain.Member.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity(name = "chat_room_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="chat_room_id")
    private ChatRoom room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.REMOVE)
    private final Set<Chat> message = new HashSet<>();

    @Builder
    public User(ChatRoom room, Member member) {
        this.room = room;
        this.member = member;
    }

    public String getEmail(){
        return member.getEmail();
    }

    public String getName(){
        return member.getName();
    }
}
