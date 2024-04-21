package time.test;

import java.time.LocalDate;
import java.time.Period;

public class TestBetween {
    public static void main(String[] args) {
        // 시작 날짜와 목표 날짜를 입력해서 남은 기간과 디데이틀 구해라
        // 남은 기간: x년 x개월 x일 형식
        // 디데이   : x일 남음      형식

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);

        // 남은 기간 구하기
        Period between = Period.between(startDate, endDate);

        // 디데이 구하기 일 단위로 구하라고 했으므로 ChronoUnit.DAYS의 between() 활용
//        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("시작 날짜 : " + startDate);
        System.out.println("목표 날짜 : " + endDate);
        System.out.println("남은 기간 : " + between.getYears()+"년 " + between.getMonths()+"개월 " + between.getDays()+"일");
//        System.out.println("디데이 : " + daysBetween + "일");
    }
}
