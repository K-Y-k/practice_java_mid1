package time;

import java.time.LocalDate;

public class IsSupportedMain2 {
    public static void main(String[] args) {
        // 각 날짜와 시간 클래스에 지원하지 않는 정보를 넣을 경우
        // LocalDate는 날짜 정보만 가지고 있고 분에 대한 정보가 없어 예외 발생
        LocalDate now = LocalDate.now();
//        int minute = now.get(ChronoField.SECOND_OF_MINUTE);
//        System.out.println("minute = " + minute);

        // TemporalAccessor와 Temporal 인터페이스는 현재 타입에서 특정 시간 단위나 필드를 사용할 수 있는지 확인하는 메서드를 제공한다.
//        boolean supported = now.isSupported(ChronoField.SECOND_OF_MINUTE);
//        System.out.println("supported = " + supported);

        // 지원할 때 처리하면 된다.
//        if (supported) {
//            int minute = now.get(ChronoField.SECOND_OF_MINUTE);
//            System.out.println("minute = " + minute);
//        }
    }
}
