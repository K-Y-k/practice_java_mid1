package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        // 가장 기본이 되는 날짜와 시간 클래스는 LocalDate, LoalTime, LocalDateTime이다.
        // 국내 시간만 사용할 경우 이 클래스들을 사용하면 된다.
        // LocalDate     : 날짜만 표현할 때 사용한다. 년, 월, 일을 다름 ex) 2013-11-21

        // 날짜 가져오기
        LocalDate nowDate = LocalDate.now();                                // 현재 날짜
        LocalDate ofDate = LocalDate.of(2024, 4, 19); // 특정 날짜
        System.out.println("오늘 날짜 = " + nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        // 계산(=불변)
        ofDate.plusDays(10);
        System.out.println("지정 날짜 + 10일 = " + ofDate); // 불변 객체로 반환값을 넣지 않으면 계산 이전 그대로이다.
        
        // 반환값을 넣고 확인
        ofDate = ofDate.plusDays(10);
        System.out.println("지정 날짜 + 10일 = " + ofDate); // 계산이 적용됨
    }
}
