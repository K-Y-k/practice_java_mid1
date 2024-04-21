package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class TestCalendarPrinter {
    public static void main(String[] args) {
        // 입력한 년도와 월의 달력 형식으로 출력해라
        Scanner scanner = new Scanner(System.in);

        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        printCalender(year, month);
    }

    private static void printCalender(int year, int month) {
        // 달력의 기준값으로 입력한 년월의 첫번째 날 가져오기
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        // 다음달의 첫번째 날 가져오기
        LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);

        // 월요일은 1 .. 일요일은 0과 같은 값 형태로 만들기
        int offsetWeekDays = firstDayOfMonth.getDayOfWeek().getValue() % 7;

        System.out.println("Su Mo Tu We Th Fr Sa ");

        for (int i = 0; i < offsetWeekDays; i++) {
            System.out.print("   ");
        }
        
        // 처음 기준값인 날짜 가져오기
        LocalDate dayInterator = firstDayOfMonth; // 2024-01-01

        // 다음달 전까지 루프 돌리기
        while (dayInterator.isBefore(firstDayOfNextMonth)) {
            // 2칸을 차지하기 위한 포맷 형식 적용
            System.out.printf("%2d ", dayInterator.getDayOfMonth());
//            System.out.print(dayInterator.getDayOfMonth() + " ");

            // 토요일 일 때 줄 바꾸기
            if (dayInterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }

            // 다음날로 더하기
            dayInterator = dayInterator.plusDays(1);
        }
    }
}
