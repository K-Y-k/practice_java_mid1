package lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {
    public static void main(String[] args) {
        // System 클래스는 시스템의 기본 기능을 제공한다.

        // 현재 시간(밀리초)를 가져온다.
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 현재 시간(나노초)를 가져온다.
        long currentNano = System.nanoTime();
        System.out.println("currentNano = " + currentNano);


        // 운영체제에서 설정한 환경 변수를 읽는다.
        System.out.println("getenv = " + System.getenv());

        // 자바에서 사용하는 설정 값인 시스템 속성을 읽는다.
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java version: " + System.getProperty("java.version"));


        // 배열을 고속으로 복사한다.
        // 기존은 반복문으로 일일히 하나씩 조회하고 넣는데 이 동작은 느리다.
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];

        // 시스템에서 제공하는 배열 복사 메서드는 속도가 매우 빠르다. (2~5배)
        // 자바가 운영체제에게 넘기고 운영체제 하드웨어가 처리해준다.
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        System.out.println("copiedArray = " + copiedArray); // 배열 참조값
        System.out.println("copiedArray = " + Arrays.toString(copiedArray)); // 배열 내부 값을 출력하는 유틸리티 메서드


        // 프로그램 종료
        // 프로그램 종료 전에는 실행된 것들을 모두 종료해야하므로
        // 이 기능은 가급적 사용을 권장하지 않는다.
        // ex) 웹 애플리케이션에서 종료해버리면 다른 사용자의 요청이 차단되고 작동이 안된다.
        System.exit(0);
    }
}
