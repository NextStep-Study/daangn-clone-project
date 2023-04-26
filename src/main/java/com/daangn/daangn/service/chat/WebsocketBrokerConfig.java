package com.daangn.daangn.service.chat;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.logging.Logger;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketBrokerConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 메시지를 구독하는 요청 url => 즉 메시지를 받을 때
        registry.enableSimpleBroker("/user");
        // 메시지를 발행하는 요청 url => 즉 메시지를 보낼 때
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // stomp 접속 주소 url => /broadcast
        registry.addEndpoint("/broadcast")// 연결될 엔드포인트
                .withSockJS() // SoketJS를 연결한다는 설정
                // STOMP에서 TCP 연결이 잘 되어있는지 체킹하는 것, HTTP header를 통해 연결 상태를 주기적으로 확인한다.
                .setHeartbeatTime(60_000);
    }

}
