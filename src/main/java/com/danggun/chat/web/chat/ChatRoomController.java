package com.danggun.chat.web.chat;

import com.danggun.chat.domain.chat.ChatRoom;
import com.danggun.chat.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }
    // 모든 채팅방 목록 반환
    @ResponseBody
    @GetMapping("/rooms")
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }
    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        System.out.println(name);
        return chatService.createRoom(name);
    }
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}/{sender}" )
    public String roomDetail(Model model, @PathVariable String roomId, @PathVariable String sender) {
        System.out.println(roomId);
        model.addAttribute("roomId", roomId);
        model.addAttribute("sender", sender);

        return "/chat/roomdetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public Optional<ChatRoom> roomInfo(@PathVariable Long roomId) {
        return chatService.findById(roomId);
    }
}
