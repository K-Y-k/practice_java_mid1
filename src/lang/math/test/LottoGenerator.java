package lang.math.test;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {
    private final Random random = new Random();
    private int[] lottoNumbers;
    private int count;

    public int[] generate() {
        lottoNumbers = new int[6];
        count = 0;

        while (count < 6) {
            // 내가 푼 방식은 중복 검사를 메서드화 하지 않고 반복문 안에 작성
//            boolean duplication = false;
            int randomNum = random.nextInt(45) + 1;

            if (isUnique(randomNum)) {
                lottoNumbers[count] = randomNum;
                count++;
            }

//            for (int lottoNumber : lottoNumbers) {
//                if (lottoNumber == randomNum) {
//                    duplication = true;
//                    break;
//                }
//            }

            // 중복되지 않은 경우에만 추가
//            if (!duplication) {
//                lottoNumbers[count] = randomNum;
//                count++;
//            }
        }

        return lottoNumbers;
    }

    // 이미 생성된 번호와 중복되는지 검사 메서드
    private boolean isUnique(int number) {
        for (int i = 0; i < count; i++) {
            if (lottoNumbers[i] == number) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "로또 번호: " + Arrays.toString(lottoNumbers);
    }
}
