package nested.inner.ex2;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }


    // 내부 클래스로 활용
    public class Engine {
        // 내부 클래스 덕분에 필드로 Car의 객체를 주입하지 않고 사용할 수 있다.
        public void start() {
            // 바깥 클래스의 인스턴스 멤버를 직접 접근하여 가져옴
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }
}
