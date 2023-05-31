package com.daangn.daangn.chat.controller;

import com.daangn.daangn.chat.dto.SendMessageDto;
import com.daangn.daangn.chat.entity.ChatType;
import com.daangn.daangn.chat.service.ChatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import static org.mockito.Mockito.*;

class ChatControllerTest {

    @Mock
    private SimpMessageSendingOperations sendingOperations;

    @Mock
    private ChatService chatService;

    private ChatController chatController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        chatController = new ChatController(sendingOperations, chatService);
    }

    @Test
    void enter_shouldSendMessageAndSaveMessage() {
        // Arrange
        SendMessageDto messageInfo = new SendMessageDto();
        messageInfo.setType(ChatType.ENTER);
        messageInfo.setSender("John");
        messageInfo.setRoomId("123");

        // Act
        chatController.enter(messageInfo);

        // Assert
        verify(chatService, times(1)).saveMessage(messageInfo);
        verify(sendingOperations, times(1)).convertAndSend(
                "/topic/chat/room/" + messageInfo.getRoomId(), messageInfo);
    }
}
