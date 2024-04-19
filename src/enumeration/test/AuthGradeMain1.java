package enumeration.test;

/**
 * 다음 결과가 출력되도록 코드를 작성해라
 * 앞서 만든 AuthGrade를 활용하자.
 */
public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] values = AuthGrade.values();

        for (AuthGrade value : values) {
            System.out.println("grade=" + value.name() + ", level=" + value.getLevel() + ", 설명=" +  value.getDiscription());
        }
    }
}
