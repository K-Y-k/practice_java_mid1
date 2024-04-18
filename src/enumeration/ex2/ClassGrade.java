package enumeration.ex2;

public class ClassGrade {
    // 각 등급별로 상수를 선언한다.
    // 이때 각 상수마다 별도의 인스턴스를 생성하고 생성한 인스턴스를 대입한다.
    public static final ClassGrade BASIC = new ClassGrade();   // x001
    public static final ClassGrade GOLD = new ClassGrade();    // x002
    public static final ClassGrade DIAMOND = new ClassGrade(); // x003

    // 외부에서 생성하지 못하도록 생성자를 private로 막음
    private ClassGrade() {
    }
}
