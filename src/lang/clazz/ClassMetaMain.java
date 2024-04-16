package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {
    public static void main(String[] args) throws Exception {
        // Class 클래스는 클래스의 정보(메타데이터)를 다루는데 사용된다.
        // 실행 중인 자바 애플리케이션 내에서 필요한 클래스의 속성과 메서드에 대한 정보를 조회하고 조작할 수 있다.

        // Class 조회 방법 3가지
        Class clazz = String.class;                                // 1. 클래스에서 조회
        Class clazz2 = new String().getClass();                    // 2. 인스턴스에서 조회
        Class clazz3 = Class.forName("java.lang.String"); // 3. 문자열로 조회


        // 모든 필드 출력
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
            System.out.println("field = " + field.getType() + " " + field.getName());
        }


        // 모든 메서드 출력
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }


        // 상위 클래스 정보 출력
        System.out.println("SupperClass: " + clazz.getSuperclass().getName());


        // 인터페이스 정보 출력
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }
    }
}
