package nested;

public class ShadowingMain {
    // 바깥 클래스의 필드명과 
    // 내부 클래스의 필드명이 같은 경우
    // 더 가깝운 곳의 필드명이 우선시된다.
    public int value = 1;

    class Inner {
        public int value = 2;

        void go() {
            int value = 3;
            System.out.println("value = " + value);           // 지역 변수가 제일 가깝다.
            System.out.println("this.value = " + this.value); // 인스턴스 참조 this로 내부 클래스의 필드로 접근
            System.out.println("ShadowingMain.this.value = " + ShadowingMain.this.value); // 바깥클래스명.this로 바깥 클래스의 필드로 접근
        }
    }

    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
