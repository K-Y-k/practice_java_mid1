package lang.object.poly;

public class ObjectPolyEx2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object object = new Object();

        //Object[] objects = new Object[3];
        //objects[0] = dog;
        //objects[1] = car;
        //objects[2] = object;
        Object[] objects = {dog, car, object};
        
        size(objects);
    }

    // Object는 모든 객체를 담을 수 있어
    // 참조 객체의 변경이 절대 일어날 수 없게 된다.
    private static void size(Object[] objects) {
        System.out.println("전달된 객체의 수는: " + objects.length);
    }
}
