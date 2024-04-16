package lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        // Math.random()을 사용해도 되지만 Random 클래스를 사용하면 더욱 다양한 랜덤값을 구할 수 있다.
        Random random = new Random();
        Random random2 = new Random(1); // seed가 같으면 랜덤의 결과가 동일하게 유지한다.

        // 각 타입의 랜덤 조회
        int randomInt = random.nextInt();                       // 랜덤 int 값
        System.out.println("randomInt = " + randomInt);

        double randomDouble = random.nextDouble();              // 0.0d ~ 1.0d
        System.out.println("randomDouble = " + randomDouble);

        boolean randomBoolean = random.nextBoolean();           // true, false
        System.out.println("randomBoolean = " + randomBoolean);


        // 범위 조회
        int randomRange1 = random.nextInt(10);           // 0 ~ 9까지
        System.out.println("0 ~ 9: " + randomRange1);

        int randomRange2 = random.nextInt(10) + 1;       // 1 ~ 10까지
        System.out.println("1 ~ 10: " +randomRange2);
    }
}
