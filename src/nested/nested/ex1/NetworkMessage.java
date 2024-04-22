package nested.nested.ex1;

// 문제점
// Network 객체 안에서만 사용하는 클래스를 따로 만든 경우
// 이렇게 따로 생성하면 다른 개발자가 패키지를 볼 때
// 이 객체가 Nextwork 객체뿐이 아닌 따로 사용될 수도 있다고 착각할 수 있다.
public class NetworkMessage {
    private String content;

    public NetworkMessage(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
