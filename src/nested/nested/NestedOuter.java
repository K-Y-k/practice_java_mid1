package nested.nested;

public class NestedOuter {
    private static int outClassValue = 3; // 정적 변수
    private int outInstanceValue = 2;     // 인스턴스 변수


    // 정적 중첩 클래스 = static을 붙인 중첩 클래스
    // 바깥 클래스의 인스턴스에 소속되지 않는다.
    static class Nested {
        private int nestedInstanceValue = 1;

        public void print() {
            // 자신의 인스턴스 멤버에 접근 가능
            System.out.println("내부 클래스의 인스턴스 멤버에 접근 가능 = " + nestedInstanceValue);

            // 외부 클래스의 인스턴스 멤버에 접근에는 접근할 수 없다.
            //System.out.println(outInstanceValue);

            // 정적 중첩 클래스의 특징은 외부 클래스의 private static인 정적 멤버에 접근할 수 있다.
            // 즉, 다른 클래스에서 정적 멤버 접근이 불가능했는데 여기서는 된다.
            System.out.println("외부 클래스의 정적 멤버에 접근 가능 = " + outClassValue);
        }
    }
}
