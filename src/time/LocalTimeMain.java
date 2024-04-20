package time;

import java.time.LocalTime;

public class LocalTimeMain {
    public static void main(String[] args) {
        // 가장 기본이 되는 날짜와 시간 클래스는 LocalDate, LoalTime, LocalDateTime이다.
        // 국내 시간만 사용할 경우 이 클래스들을 사용하면 된다.
        // LocalTime     : 시간만을 표현할 때 사용한다. 시, 분, 초를 다룸 ex) 08:20:30.1

        // 시간 가져오기
        LocalTime nowTime = LocalTime.now(); // 현재 시간
        LocalTime ofTime = LocalTime.of(9, 10, 30);// 특정 시간
        System.out.println("현재 시간 = " + nowTime);
        System.out.println("지정 시간 = " + ofTime);

        // 계산(=불변이므로 계산 괄과를 반환값에 넣어줘야함)
        LocalTime ofTimePlus = ofTime.plusSeconds(30);
        System.out.println("지정 시간 + 30s = " +ofTimePlus);

    }
}
