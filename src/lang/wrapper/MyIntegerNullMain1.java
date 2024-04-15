package lang.wrapper;

public class MyIntegerNullMain1 {
    public static void main(String[] args) {
        // 기본형의 한계2를 해결한 래퍼 클래스 활용
        MyInteger[] intArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};

        // 객체에서는 데이터가 '없음'이라는 상태가 있다.(null)
        System.out.println(findValue(intArr, -1));  // 값을 찾아서 -1
        System.out.println(findValue(intArr, 0));   // 값을 찾아서 0
        System.out.println(findValue(intArr, 1));   // 값을 찾아서 1
        System.out.println(findValue(intArr, 100)); // 값을 못 찾아서 null
    }

    private static MyInteger findValue(MyInteger[] intArr, int target) {
        // 루프를 돌려 타겟 숫자가 있으면 해당 숫자 반환
        for (MyInteger myInteger : intArr) {
            if (myInteger.getValue() == target) {
                return myInteger; // toString()으로 참조값이 아닌 실제값이 나오도록 오버라이딩한 것이다.
            }
        }

        // 루프에서 타겟 숫자를 못 찾은 경우 데이터가 없는 것이므로
        // 객체라서 null로 반환할 수 있다!
        return null;
    }
}
