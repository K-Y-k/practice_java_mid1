package exception.ex0;

// NetworkCilent의 전체적인 흐름을 제어해주는 서비스
public class NetworkServiceV0 {
    
    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV0 client = new NetworkClientV0(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
