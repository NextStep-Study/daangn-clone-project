package com.daangn.daangn.web;

import com.daangn.daangn.service.chat.ChatService;
import com.daangn.daangn.repository.chat.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 메시지를 주고 받을때는 json 형식을 이용한다.
//@RestController
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/chat")
public class ChatController {

//    private final ChatService service;
//
//    @PostMapping
//    public ChatRoom createRoom(@RequestParam String name){
//        return service.createRoom(name);
//    }
//
//    @GetMapping
//    public List<ChatRoom> findAllRooms(){
//        return service.findAllRoom();
//    }
}
