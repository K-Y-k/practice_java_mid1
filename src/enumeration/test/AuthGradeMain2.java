package enumeration.test;

import java.util.Scanner;

/**
 * 인증 등급을 입력 받아서 앞서 만든 AuthGrade 열거형으로 변환하자.
 * 인증 등급에 따라 접근할 수 있는 화면이 다르다.
 */
public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String input = scanner.nextLine();

        // Enum을 활용한 방식
        AuthGrade authGrade = AuthGrade.valueOf(input.toUpperCase()); // 소문자도 대문자로만 적용되도록

        System.out.println("당신의 등급은 " + authGrade.getDiscription() + "입니다.");
        System.out.println("==메뉴 목록==");
        if (authGrade.getLevel() > 0) {
            System.out.println("- 메인 화면");
        }

        if (authGrade.getLevel() > 1) {
            System.out.println("- 이메일 관리 화면");
        }

        if (authGrade.getLevel() > 2) {
            System.out.println("- 관리자 화면");
        }


        // 내가 푼 방식 = 스위치
//        switch (input) {
//            case "GUEST":
//                System.out.println("당신의 등급은 손님입니다.");
//                System.out.println("==메뉴 목록==");
//                System.out.println("- 메인 화면");
//                break;
//
//            case "LOGIN":
//                System.out.println("당신의 등급은 로그인 회원입니다.");
//                System.out.println("==메뉴 목록==");
//                System.out.println("- 메인 화면");
//                System.out.println("- 이메일 관리 화면");
//                break;
//
//            case "ADMIN":
//                System.out.println("당신의 등급은 관리자입니다.");
//                System.out.println("==메뉴 목록==");
//                System.out.println("- 메인 화면");
//                System.out.println("- 이메일 관리 화면");
//                System.out.println("- 관리자 화면");
//                break;
//
//            default:
//                System.out.println("잘못 입력하셨습니다.");
//                break;
//        }
    }
}
