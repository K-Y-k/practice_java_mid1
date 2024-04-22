package nested.inner;

public class InnerOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;


    // 내부 클래스 → static이 붙지 않는 클래스
    // 바깥 클래스의 인스턴스 멤버에 소속된다.
    class Inner {
        private int innerInstanceValue = 1;

        public void print() {
            // 자기 자신에 접근
            System.out.println("내부 클래스의 인스턴스 멤버에 접근 가능 = " + innerInstanceValue);

            // 외부 클래스의 인스턴스 멤버에 접근 가능, private도 접근 가능
            System.out.println("내부 클래스의 바깥 클래스 인스턴스 멤버에 접근 가능 = " + outInstanceValue);
            
            // 외부 클래스의 정적 멤버에 접근 가능, private도 접근 가능
            System.out.println("내부 클래스의 바깥 클래스의 정적 멤버에 접근 가능 = " + outClassValue);
        }
    }
}
