package com.daangn.daangn.web.chat;

import com.daangn.daangn.domain.chat.ChatRepository;
import com.daangn.daangn.domain.chat.ChatRoom;
import com.daangn.daangn.domain.chat.ChatRoomRepository;
import com.daangn.daangn.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import static com.daangn.daangn.domain.chat.types.ChatRoomType.CARROT;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatService chatService;

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
        log.debug("roomId : "+ roomId);
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

    // 채팅 리스트 화면
    // / 로 요청이 들어오면 전체 채팅룸 리스트를 담아서 return
//    @GetMapping("/")
//    public String goChatRoom(Model model){
//
//        model.addAttribute("list", chatRoomRepository.findAll());
////        model.addAttribute("user", "hey");
//        log.info("SHOW ALL ChatList {}", "");
//        return "roomlist";
//    }
//
//    // 채팅방 생성
//    // 채팅방 생성 후 다시 / 로 return
//    @PostMapping("/chat/createroom")
//    public String createRoom(@RequestParam String name, RedirectAttributes rttr) {
//        ChatRoom room = ChatRoom.builder()
//                .type(CARROT)
//                .build();
//        chatRoomRepository.save(room);
//        log.info("CREATE Chat Room {}", room);
//        rttr.addFlashAttribute("roomName", room);
//        return "redirect:/";
//    }
//
//    // 채팅방 입장 화면
//    // 파라미터로 넘어오는 roomId 를 확인후 해당 roomId 를 기준으로
//    // 채팅방을 찾아서 클라이언트를 chatroom 으로 보낸다.
//    @GetMapping("/chat/room")
//    public String roomDetail(Model model, long roomId){
//
//        log.info("roomId {}", roomId);
//        model.addAttribute("room", chatRoomRepository.findById(roomId));
//        return "chatroom";
//    }
}
