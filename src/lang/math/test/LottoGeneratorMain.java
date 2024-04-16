package lang.math.test;

import java.util.Arrays;

public class LottoGeneratorMain {
    public static void main(String[] args) {
        // 로또 번호를 자동으로 만들어주는 자동 생성기를 만들자
        // 로또 번호는 1~45 사이의 숫자를 6개 뽑아야 한다.
        // 각 숫자는 중복되면 안된다.
        // 실행할 때 마다 결과가 달라야 한다.
        LottoGenerator lottoGenerator = new LottoGenerator();
        int[] result = lottoGenerator.generate();

        System.out.print("로또 번호: ");
        for (int lottoNumber : result) {
            System.out.print(lottoNumber + " ");
        }

        System.out.println();
        System.out.println(lottoGenerator.toString());
    }
}
