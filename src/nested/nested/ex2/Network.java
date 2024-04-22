package nested.nested.ex2;

public class Network {
    public void sendMessage(String text) {
        // 나의 클래스에 포함된 중첩 클래스는 바로 중첩 클래스로 선언할 수 있다.
        // 다른 클래스에서의 접근은 나의클래스.중첩클래스로 접근해야함
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }


    // 정적 중첩 클래스로 활용
    // 이제 다른 개발자가 Network로만 사용한다는 것을 알 수 있다.
    private static class NetworkMessage {
        private String content;

        public NetworkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }
}
