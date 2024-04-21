package time.test;

import java.time.LocalDateTime;

public class TestPlus {
    public static void main(String[] args) {
        // 2024년 1월 1일 0시 0분 0초에 1년 2개월 3일 4시간 후의 시각을 찾아라
        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        // 불변 객체는 새로 적용한 값을 반환값으로 객체에 넣으므로 메서드 체인이 가능하다.
        LocalDateTime result = date.plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4);

        System.out.println("기준 시각: " + date);
        System.out.println("1년 2개월 3일 4시간 후의 시각 = " + result);
    }
}
