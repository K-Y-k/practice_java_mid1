package lang.string.test;

public class TestString6 {
    public static void main(String[] args) {
        // 키가 나온 횟수를 출력해라
        
        // 내가 푼 방식
        // String str = "start hello java, hello spring, hello jpa";
        //String key = "hello";

        //String[] strArr = str.split(" ");

        //int count = 0;

        //for (String s : strArr) {
        //    if (s.equals(key)) {
        //        count += 1;
        //    }
        //}

        //System.out.println("count = " + count);


        // indexOf로 활용한 방식
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";

        int count = 0;
        int keyIdx = str.indexOf(key); // 처음 키에 위치한 인덱스 초기화

        // indexOf는 못찾으면 -값이 나오므로 while문 조건에 0보다 크거나 같을 때까지 반복한다.
        while (keyIdx >= 0) {
            keyIdx = str.indexOf(key, keyIdx + 1); // 찾으면 현재 키 인덱스를 한칸 이동하여 다음 해당하는 키가 있는지 루프
            count++;
        }

        System.out.println("count = " + count);

    }
}
