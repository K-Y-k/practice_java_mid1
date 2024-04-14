package lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        // String 클래스의 문자열 분할 및 조합 관련 메서드
        // split() : 분할
        String[] splitStr = str.split(",");
        for (String s : splitStr) {
            System.out.println(s);
        }


        // join() 없이하면
        // 의도는 문자 이어지는 부분만 구분 문자를 넣으려는건데 끝에도 구분 문자가 붙는다.
        String joinStr = "";
//        for (String s : splitStr) {
//            joinStr += s + "-";
//        }
        // 즉, 없이 하려면 이 복잡한 로직을 작성해야하는 불편함
        for (int i=0; i < splitStr.length; i++) {
            String s = splitStr[i];
            joinStr += s;

            if (i != splitStr.length-1) {
                joinStr += "-";
            }
        }

        System.out.println("joinStr = " + joinStr);


        // join()으로 위 복잡한 로직없이 편리하게 작성 가능하다.
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열 = " + joinedStr);

        // 문자열 배열 연결
        String result = String.join("-", splitStr);
        System.out.println("result = " + result);
    }
}
