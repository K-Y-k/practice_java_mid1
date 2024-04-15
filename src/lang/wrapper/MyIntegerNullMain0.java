package lang.wrapper;

public class MyIntegerNullMain0 {
    public static void main(String[] args) {
        // 기본형의 한계2
        int[] intArr = {-1, 0, 1, 2, 3};

        // 기본형에서는 데이터가 없음이라는 상태가 없다.
        // 그래서 없을 때 임의의 값으로 return하는데 이는 찾은 값과 반환값이 같을 수 있는 문제가 발생한다!
        System.out.println(findValue(intArr, -1));  // 값을 찾아서 -1
        System.out.println(findValue(intArr, 0));   // 값을 찾아서 0
        System.out.println(findValue(intArr, 1));   // 값을 찾아서 1
        System.out.println(findValue(intArr, 100)); // 값을 못 찾아서 -1 -> 값을 찾은 -1과 동일한 결과가 나오는 문제!
    }

    private static int findValue(int[] intArr, int target) {
        // 루프를 돌려 타겟 숫자가 있으면 해당 숫자 반환
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }

        // 루프에서 타겟 숫자를 못 찾은 경우
        return -1;
    }
}
