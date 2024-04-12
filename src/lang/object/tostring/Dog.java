package lang.object.tostring;

public class Dog {
    private String dogName;
    private int age;

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

    // Obejct 클래스의 toString() 오버라이드
    // ctrl + insert에 toString 항목으로 자동 완성이 된다.
    @Override
    public String toString() {
        // 직접 작성한 방식
//        return "dogName=" + dogName + "\" + "age=" + age;

        // 자동 완성된 방식
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
}
