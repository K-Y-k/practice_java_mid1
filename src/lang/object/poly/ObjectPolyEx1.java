package lang.object.poly;

public class ObjectPolyEx1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    // 여기서 매개변수의 객체를 최상위 부모라서 어떤 객체든 인자로 전달할 수 있다!
    private static void action(Object obj) {
        // Object의 메서드에는 각 객체들의 메서드가 없으므로 사용을 못한다.
        // 원래 다형적 참조 + 메서드 오버라이딩을 같이 활용해야 하지만
        // Object 클래스는 메서드 오버라이딩이 불가능하기에 다형성의 한계가 있다.
        //obj.sound();  Object는 sound()가 없다.
        //obj.move();   Object는 move()가 없다.

        // 그래서 Object 클래스에서는 각 객체에 맞는 다운캐스팅 필요하다.
        if (obj instanceof Dog dog) {
            // ((Dog)obj).sound(); 명시적인 다운캐스팅
            dog.sound(); // 자동 다운캐스팅
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
