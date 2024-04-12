package lang.object.equals;

import java.util.Objects;

public class UserV2 {
    private String id;

    public UserV2(String id) {
        this.id = id;
    }

    // 기본 동일성으로 제공하는 equals()를
    // 동등성으로 재정의한 오버라이딩

    // 최소한의 버전으로 버그가 발생할 수 있다.
//    @Override
//    public boolean equals(Object obj) {
//        UserV2 user = (UserV2) obj;
//
//        // 문자끼리의 ==은 equals()
//        return id.equals(user.id);
//    }

    // 완벽한 equals() 재정의 버전
    // ctrl + insert에 equals and hashCode() 항목 선택
    // 비교할 필드를 체크하며 next하기
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserV2 userV2 = (UserV2) o;
        return id.equals(userV2.id);
    }

    // equals() 메서드를 구현할 때 지켜야 하는 규칙
    // - 반사성 : 객체는 자기 자신과 동등해야 한다.
    // - 대칭성 : 두 객체가 서로에 대해 동일하다고 판단하면 이는 양방향으로 동일해야 한다.
    // - 추이성 : 만약 한 객체가 두번째 객체와 동일하고, 두번재 객체가 세번째 객체와 동일하다면, 첫번째 객체는 세번째 객체와도 동일해야 한다.
    // - 일관성 : 두 객체의 상태가 변경되지 않는 한, equals() 메서드는 항상 동일한 값을 반환해야 한다.
    // - null에 대한 비교 : 모든 객체는 null일 때 false를 반환해야 한다.
}
