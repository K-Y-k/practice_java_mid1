package time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodMain {
    public static void main(String[] args) {
        // Peroid : 두 날짜 사이의 간격을 년,월, 일 단위로 나타내는 클래스

        // 기간 생성
        Period period = Period.ofDays(10); // 10일의 기간 생성
        System.out.println("period = " + period);

        // 계산에 기간을 사용
        // 계산 메서드에 Period 클래스 변수를 그대로 넣을 수 있다.
        LocalDate currentDate = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = currentDate.plus(period); // 이전에 생성했던 10일을 넣음
        System.out.println("currentDate = " + currentDate);
        System.out.println("plusDate = " + plusDate);
        
        // 기간 차이
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 4, 2);
        Period between = Period.between(startDate, endDate);
        System.out.println("기간: " + between.getMonths() + "개월 " + between.getDays() + "일");
    }
}
