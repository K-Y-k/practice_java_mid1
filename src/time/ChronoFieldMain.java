package time;

public class ChronoFieldMain {
    public static void main(String[] args) {
        // 시간의 단위와 시간 필드 인터페이스는
        // - 시간의 단위를 뜻하는 TemporalUnit(구현체 ChronoUnit)과
        // - 시간의 필드를 뜻하는 TemporalField(구현체 ChronoField)이 있다.

        // - TemporalField 인터페이스
        //   TemporalField는 날짜와 시간을 나타내는데 사용된다.
        //   ChronoField가 구현체인 열거형이다.
        //   이 열거형은 다양한 필드를 통해 날짜와 시간의 특정 부분을 나타낸다.
        //   년, 월, 일 시간, 분 등이 포함된다.

        // 날짜와 시간의 필드와 해당 필드 값의 범위 가져오기
//        ChronoField[] values = ChronoField.values();
//        for (ChronoField value : values) {
//            System.out.println(value + ", range = " + value.range());
//        }

        // 특정 필드의 범위 구하기
//        System.out.println("MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range()); // 1 - 12    달의 범위
//        System.out.println("DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());   // 1 - 28/31 일의 범위
    }
}
