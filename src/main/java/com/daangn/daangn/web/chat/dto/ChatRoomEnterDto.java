package com.daangn.daangn.web.chat.dto;


import com.daangn.daangn.domain.chat.types.ChatType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class ChatRoomEnterDto {

    @Enumerated(EnumType.STRING)
    private ChatType type; // 메세지 타입

    private  String content;

    private long roomId;

    @Builder
    public ChatRoomEnterDto(ChatType type, String content, long roomId) {
        this.type = type;
        this.content = content;
        this.roomId = roomId;
    }
}
