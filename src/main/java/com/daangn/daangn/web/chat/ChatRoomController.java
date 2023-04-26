package com.daangn.daangn.web.chat;

import com.daangn.daangn.domain.chat.ChatRepository;
import com.daangn.daangn.domain.chat.ChatRoom;
import com.daangn.daangn.domain.chat.ChatRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.daangn.daangn.domain.chat.types.ChatRoomType.CARROT;


@Controller
@Slf4j
public class ChatRoomController {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    // 채팅 리스트 화면
    // / 로 요청이 들어오면 전체 채팅룸 리스트를 담아서 return
    @GetMapping("/")
    public String goChatRoom(Model model){

        model.addAttribute("list", chatRoomRepository.findAll());
//        model.addAttribute("user", "hey");
        log.info("SHOW ALL ChatList {}", "");
        return "roomlist";
    }

    // 채팅방 생성
    // 채팅방 생성 후 다시 / 로 return
    @PostMapping("/chat/createroom")
    public String createRoom(@RequestParam String name, RedirectAttributes rttr) {
        ChatRoom room = ChatRoom.builder()
                .type(CARROT)
                .build();
        chatRoomRepository.save(room);
        log.info("CREATE Chat Room {}", room);
        rttr.addFlashAttribute("roomName", room);
        return "redirect:/";
    }

    // 채팅방 입장 화면
    // 파라미터로 넘어오는 roomId 를 확인후 해당 roomId 를 기준으로
    // 채팅방을 찾아서 클라이언트를 chatroom 으로 보낸다.
    @GetMapping("/chat/room")
    public String roomDetail(Model model, long roomId){

        log.info("roomId {}", roomId);
        model.addAttribute("room", chatRoomRepository.findById(roomId));
        return "chatroom";
    }
}
