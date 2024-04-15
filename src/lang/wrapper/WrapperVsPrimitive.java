package lang.wrapper;

public class WrapperVsPrimitive {
    public static void main(String[] args) {
        // 기본형이 유리한 경우
        // 래퍼 클래스는 객체라서 내부 값과 메서드 등 다양하게 들어있어 
        // 메모리 차지 비율이 기본형에 비해 약 3~4배정도 가진다.
        int iterations = 1_000_000_000;  // 반복 횟수 설정 10억, 자바에서는 _로 숫자를 구분할 수 있다.
        long startTime, endTime;

        // 기본형 long 사용
        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();

        for (int i = 0; i <iterations; i++) {
            sumPrimitive += i;
        }

        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive);
        System.out.println("기본 자료형 long 실행 시간: " + (endTime - startTime) + "ms");
        // 0.2초


        // 래퍼 클래스 Long 사용
        Long sumWrapper = 0L; // 래퍼 클래스는 L 표기해야함
        startTime = System.currentTimeMillis();

        for (int i = 0; i <iterations; i++) {
            sumWrapper += i; // 오토 박싱 발생
        }

        endTime = System.currentTimeMillis();
        System.out.println("sumWrapper = " + sumWrapper);
        System.out.println("래퍼 클래스 Long 실행 시간: " + (endTime - startTime) + "ms");
        // 2.5초로 대략 12배 차이남
        // 하지만 10억번이나 돌린 것이므로 그렇게 큰 차이가 아니다.
        // 현재 CPU 상황에서는 최적화의 의미가 없다.

        // 즉, CPU 연산을 아주 많이 수행하는 특수한 경우라면 기본형을 사용해서 최적화를 고려하지만
        // 일반적으로는 코드 유지보수가 더 나은 것을 선택하면 된다.
    }
}
