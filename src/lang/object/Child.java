package lang.object;

// Child는 다른 부모 클래스를 상속받으므로 Object를 직접적으로 상속받지 않지만
// 결국 부모의 부모를 거치면 최상위 부모인 Object를 상속받고 있다.
public class Child extends Parent {

    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
