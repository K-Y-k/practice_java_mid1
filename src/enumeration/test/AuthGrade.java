package enumeration.test;

/**
 * 회원의 인증 등급을 AuthGrade라는 이름의 열거형으로 만들어라
 * 인증 등급은 3가지이고 인증 등급에 따른 레벨과 설명을 가진다.
 * 레벨과 설명은 getXXX() 메서드로 조회할 수 있어야 한다.
 */
public enum AuthGrade {
    GUEST(1, "손님"),
    LOGIN(2, "로그인 회원"),
    ADMIN(3, "관리자");

    private final int level;
    private final String discription;

    AuthGrade(int level, String name) {
        this.level = level;
        this.discription = name;
    }


    public int getLevel() {
        return level;
    }

    public String getDiscription() {
        return discription;
    }
}
