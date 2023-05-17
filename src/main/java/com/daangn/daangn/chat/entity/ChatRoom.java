package com.daangn.daangn.chat.entity;

import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.product.entity.Product;
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
    @GeneratedValue
    @Column(name = "chatroom_id")
    private Long Id; // 채팅방 아이디

    @OneToOne(fetch = FetchType.LAZY)
    // 방 개설시 방장의 이메일
    @JoinColumn(name = "head_email")
    private Member headMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private ChatRoomType type;

    // 영속성 설정
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<Chat> chat = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private final Set<User> user = new HashSet<>();

    @Builder
    public ChatRoom(Member headMember, Product product, ChatRoomType type) {
        this.headMember = headMember;
        this.product = product;
        this.type = type;
    }

    // 물건의 이름을 가져온다.
    public String getTitle() {
        return product.getTitle();
    }

    public boolean isGroupRoom() {
        return type.equals(ChatRoomType.GROUP);
    }

}
