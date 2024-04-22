package nested.inner.ex1;

// 문제점1
// Car 객체에서만 사용
// 이렇게 따로 생성하면 다른 개발자가 패키지를 볼 때
// 이 객체가 Car 객체뿐이 아닌 따로 사용될 수도 있다고 착각할 수 있다.
public class Engine {
    private Car car;

    public Engine(Car car) {
        this.car = car;
    }

    public void start() {
        System.out.println("충전 레벨 확인: " + car.getChargeLevel());
        System.out.println(car.getModel() + "의 엔진을 구동합니다.");
    }
}
