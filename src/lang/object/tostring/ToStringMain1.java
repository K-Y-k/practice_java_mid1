package lang.object.tostring;

public class ToStringMain1 {
    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // toString() 반환값 출력
        // return getClass().getName() + "@" + Integer.toHexString(hashCode());
        System.out.println(string); // 0bject@인스턴스참조값이 나온다.

        // object 직접 출력
        // System.out.println은 toString()을 호출해주어 같은 결과가 나온다.
        System.out.println(object); // toString()과 같은 결과값
    }
}
