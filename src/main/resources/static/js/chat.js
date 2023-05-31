var socket = new SockJS('/ws'); // WebSocket 연결을 생성합니다.
var stompClient = Stomp.over(socket); // Stomp 클라이언트를 생성합니다.

// WebSocket 연결이 성공하면 호출됩니다.
socket.onopen = function() {
    console.log('WebSocket connection established.');
};

// WebSocket 연결이 종료되면 호출됩니다.
socket.onclose = function() {
    console.log('WebSocket connection closed.');
};

// 채팅 메시지를 전송합니다.
function sendMessage() {
    var roomId = $('#roomId').text();
    var sender = $('#sender').text();
    var message = $('#messageInput').val();

    // Stomp 클라이언트를 사용하여 메시지를 전송합니다.
    stompClient.send(`/app/chat/${roomId}/${sender}`, {}, message);

    $('#messageInput').val(''); // 입력 필드를 초기화합니다.
}

// 채팅 메시지를 수신합니다.
stompClient.connect({}, function() {
    var roomId = $('#roomId').text();
    var sender = $('#sender').text();

    // 특정 채팅방의 메시지를 구독합니다.
    stompClient.subscribe(`/topic/chat/${roomId}`, function(message) {
        var messageContent = JSON.parse(message.body);
        var sender = messageContent.sender;
        var content = messageContent.content;

        // 수신한 메시지를 화면에 표시합니다.
        $('#messageList').append('<li><strong>' + sender + ':</strong> ' + content + '</li>');
    });
});
