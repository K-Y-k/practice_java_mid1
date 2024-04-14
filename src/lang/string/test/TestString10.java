package lang.string.test;

public class TestString10 {
    public static void main(String[] args) {
        // split()을 사용해서 fruits를 분리하고 join()을 사용해서 분리한 문자들을 하나로 합쳐라
        String fruits = "apple,banana,mango";

        // 분리하기
        String[] splitFruits = fruits.split(",");
        for (String part : splitFruits) {
            System.out.println(part);
        }


        // 합치기
        String joinString = String.join("->", splitFruits);
        System.out.println("joinedString = " + joinString);
    }
}
