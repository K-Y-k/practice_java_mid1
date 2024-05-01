# :rocket: 자바 중급
자바 기본기를 확실히 다지기 위한 공부로 핵심 내용 위주로 정리 (2024.04.11 ~ 2024.04.29)


# :page_facing_up: 목차
- <a href="#0"> java.lang 패키지 </a> 
- <a href="#1"> Object 클래스, 활용법, Object로 OCP 원칙 준수 </a> 
- <a href="#2"> toString() </a>
- <a href="#3"> equals(), 동등성과 동일성 </a>
- <a href="#4"> 불변 객체가 필요한 이유, 활용법, 불변 객체의 내 값 변경 </a>
- <a href="#5"> String 클래스, 비교 처리, 불변 객체 </a>
- <a href="#6"> String 클래스의 주요 메서드 </a>
- <a href="#7"> StringBuilder - 가변 String </a> 
- <a href="#8"> 메서드 체이닝 </a>
- <a href="#9"> 기본형과 래퍼 클래스, 활용법, 박싱/언박싱 </a> 
- <a href="#10"> Class 클래스 </a>
- <a href="#11"> System 클래스 </a>
- <a href="#12"> Math, Random 클래스 </a>
- <a href="#13"> 열거형 (Enum Type) </a>
- <a href="#14"> 날짜와 시간 라이브러리 </a>
- <a href="#15"> 날짜와 시간의 인터페이스 </a>
- <a href="#16"> 날짜와 시간 문자열 파싱과 포맷팅 </a>
- <a href="#17"> 중첩 클래스, 내부 클래스, 지역 클래스와 지역 변수 캡처, 익명 클래스 </a>
- <a href="#18"> 예외 </a>
- <a href="#19"> 체크 예외, 언체크 예외 </a>
- <a href="#20"> 예외 처리 try, catch, finally, try-with-resources </a>
- <a href="#21"> 예외 계층화 </a>
- <a href="#22"> 실무 예외 처리 방안 </a>


## <b id="0"> java.lang 패키지 </b>
- 자바가 기본으로 제공하는 라이브러리(=클래스 모음) 중에 가장 기본이 되는 패키지
- lang은 Language(언어)의 줄임말로 자바 언어를 이루는 가장 기본이 되는 클래스들을 보관한 패키지이다.
- lang 패키지는 import 명시하지 않아도 이 패키지의 클래스들을 묵시적으로 사용할 수 있다.
- 대표 클래스들 (기본을 이루는 클래스라 필수로 기억!)
    - Object : 모든 자바 객체의 부모 클래스
    - String : 문자열
    - Integer, Long, Double : 래퍼 타입, 기본형 데이터 타입을 객체로 만든 것
    - Class  : 클래스 메타 정보
    - System : 시스템과 관련된 기본 기능들 제공


## <b id="1"> Object 클래스, 활용법, Object로 OCP 원칙 준수 </b>
<img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/ed2a901b-12ef-4680-bde0-6c99aa46b48d" width="40%"/>

- 자바 모든 클래스의 최상위 부모 클래스이다.
  
- Object 클래스가 최상위 부모 클래스인 이유
  - 모든 객체에게 필요한 공통 기능을 제공하여 일관성 있게 사용할 수 있다.
     - 객체 정보 확인         : toString()
     - 객체의 같음 비교       : equals()
     - 객체의 클래스 정보 확인 : getClass()

  - 다형성을 활용하여 모든 객체를 Object 클래스로 담을 수 있다.
    
      <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/848541e9-c6c4-4f8f-9571-9972c1ce7ea9" width="30%"/>
      
     - 부모는 자식을 담을 수 있는데

       Object 클래스는 최상위 부모라서 모든 객체를 참조할 수 있어
    
       모든 자바 객체는 Object 타입으로 접근하여 다양한 타입의 객체를 통합적으로 처리할 수 있다.

  - ex1) 모든 객체를 받을 수 있는 메서드를 만들 수 있다.
  
  ```
  public static void main(String[] args) {
      Dog dog = new Dog();
      Car car = new Car();
  
      action(dog);
      action(car);
  }
  
  // 여기서 매개변수의 객체를 최상위 부모라서 어떤 객체든 인자로 전달할 수 있다!
  private static void action(Object obj) {
      // Object의 메서드에는 각 객체들의 메서드가 없으므로 사용을 못한다.
      // 원래 다형적 참조 + 메서드 오버라이딩을 같이 활용해야 하지만
      // Object 클래스는 메서드 오버라이딩이 불가능하기에 다형성의 한계가 있다.
      //obj.sound();  Object는 sound()가 없다.
      //obj.move();   Object는 move()가 없다.
  
      // 그래서 Object 클래스에서는 각 객체에 맞는 다운캐스팅 필요하다.
      if (obj instanceof Dog dog) {
          // ((Dog)obj).sound(); 명시적인 다운캐스팅
          dog.sound(); // 자동 다운캐스팅
      } else if (obj instanceof Car car) {
          car.move();
      }
  }
  ```

  1. instanceof로 자식 객체들을 확인하고
  2. 다운 캐스팅하여 자식 객체들의 메서드를 활용할 수 있다.


  - ex2) 모든 객체를 저장할 수 있는 배열을 만들 수 있다.

  ```
  public static void main(String[] args) {
      Dog dog = new Dog();
      Car car = new Car();
      Object object = new Object();
  
      Object[] objects = {dog, car, object};
      
      size(objects);
  }
  
  // Object는 모든 객체를 담을 수 있어
  // 참조 객체의 변경이 절대 일어날 수 없게 된다.
  private static void size(Object[] objects) {
      System.out.println("전달된 객체의 수는: " + objects.length);
  }
  ```

  - 서로 다른 모든 객체를 Object 배열로 담을 수 있다.
  - 즉, Object 덕분에 모든객체를 참조할 수 있다.


- Object 클래스로 인한 OCP 원칙 준수
   - Object와 toString 메서드가 없으면
      
     아무 관계 없는 객체의 정보를 출력하기 어려웠을 것이다.
   - 각 객체의 매개변수만 다른 중복 메서드를 만들어야 했을 것이다.
      
     각 구체적인 객체 타입에 의존적이게 된다.
     
     <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/3adee2db-fb84-46c0-96e4-5fc387cf752a" width="60%"/>
     
   - 추상적인 Object 클래스에 의존하면
  
     OCP 개방 폐쇄의 원칙을 준수하게 된다.
     - Open : 새로운 클래스에 추가하고 toString()을 오버라이딩해서 기능을 확장할 수 있다.
     - closed: 새로운 클래스를 추가해도 Object와 toString()을 사용하는 클라이언트 코드는 변경하지 않는다.


## <b id="2"> toString() </b>
- 객체의 정보를 문자열 형태로 제공하는 메서드
- Object 클래스에 정의되어 모든 클래스에 상속받아 사용할 수 있다.
- 하지만 이 참조값 정보만 가지고는 객체 상태를 적절히 나타내지 못하여
    
  보통 toString()을 오버라이딩해서 
    
  필드 값 등의 유용한 정보를 제공하는 것이 일반적이다.
  
```
public class Car {
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    // toString()이 없어도 Object 부모 객체의 toString() 호출가능
}

public class Dog {
    private String dogName;
    private int age;

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

    // Obejct 클래스의 toString() 오버라이드한 방식
    // ctrl + insert에 toString 항목으로 자동 완성이 된다.
    @Override
    public String toString() {
        // 직접 작성한 방식
//        return "dogName=" + dogName + "\" + "age=" + age;

        // 자동 완성된 방식
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
}

// 객체 정보를 출력하는 클래스를 만들어본 방식
public class ObjectPrinter {
    // 추상적인 Object에 의존한 다형성을 활용하여 매개변수 참조 객체가 모두 올 수 있게 했다.
    // 이 메서드의 원리가 System.out.println()에 객체를 넣으면 toString()이 호출되는 내부 동작 원리이다.
    public static void print(Object obj) {
      String string = "객체 정보 출력: " + obj.toString();
      System.out.println(string);
    }
}


public class ToStringMain2 {
    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        // toString 호출 방식들
        System.out.println("1. 단순 toString 호출 비교");
        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        System.out.println("2. println 내부일 때 toString 호출 비교, println에는 toString()이 들어가 있어 객체변수만 넣어도 동일출력");
        System.out.println(car);
        System.out.println(dog1);
        System.out.println(dog2);

        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);
    
        // 객체 참조값 직접 출력
        String refValue = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println("refValue = " + refValue);
    }
}
```
  

## <b id="3"> equals(), 동등성과 동일성 </b>
- equals()는 동등성 비교를 위한 메서드
- 하지만 자바에서의 기본 equals() 메서드는 동일성으로 되어있어
    
  동등성으로 처리하려면 오버라이딩으로 재정의해야 한다.
    
  동등성 비교가 필요한 경우에만 equals()를 재정의하면 된다.
  ```
  public class UserV2 {
      private String id;
  
      public UserV2(String id) {
          this.id = id;
      }
  
      // 기본 동일성으로 제공하는 equals()를
      // 동등성으로 재정의한 오버라이딩
      // 최소한의 버전으로 버그가 발생할 수 있다.
      @Override
      public boolean equals(Object obj) {
          UserV2 user = (UserV2) obj;
  
          // 문자끼리의 ==은 equals()
          return id.equals(user.id);
      }
  
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
  }
  
  public class EqualsMainV2 {
      public static void main(String[] args) {
          UserV2 user1 = new UserV2("id-100");
          UserV2 user2 = new UserV2("id-100");
  
          // UserV2에 equals()를 동등성으로 재정의하였으므로 서로 다른 결과가 나온다!
          System.out.println("identity = " + (user1 == user2));      // false
          System.out.println("equality = " + (user1.equals(user2))); // true
      }
  }
  ```

- 동일성 vs 동등성
  - 동일성
    - == 연산자를 사용하여
            
     두 객체의 참조가 같은 메모리의 동일한 인스턴스 객체인지 확인
            
  - 동등성
    - equals() 메서드를 사용하여
            
      두 객체가 논리적으로 동등한지 확인
            
    
  - ex)
    - User a = new User(”id-100”) // 참조값: x001
    - User b = new User(”id-100”) // 참조값: x002
    - 이 둘은 각 다른 메모리의 인스턴스이므로 동일성은 다르지만
            
      같은 객체이므로 동등성은 같다.


## <b id="4"> 불변 객체가 필요한 이유, 활용법, 불변 객체의 내부 값 변경 </b>
- 기본형과 참조형의 공유
    - 자바는 값을 복사해서 대입하는 원리이므로
    - 기본형은 하나의 값을 여러 변수에 절대 공유하지 않는다.
        
        ```
        // 아예 다른 메모리에 복사한 값이라 서로 다른 10들이다.
        int a = 10; // 10
        int b = a;  // 10
        
        b = 20;     // 서로 다른 메모리에 있으므로 b만 변경된다.
        ```
        
    - 참조형은 하나의 객체 참조값을 여러 변수에서 공유할 수 있다.
        
        ```java
        Address a = new Address("서울"); // x100
        Address b = a;                   // x100 : a의 참조값을 복사하여 대입
        
        b.setValue("부산"); // 같은 참조값을 공유하므로 a와 b의 필드값이 모두 변경
        ```
        
        - **공유 참조로 인한 사이드 이펙트 발생!**
            
            사이드 이펙트란 
            
            프로그래밍에서 **의도치 않게 어떤 계산이 주된 작업 외에 추가적인 보수 효과를 일으키는 것**
            
            여기서는 의도하지 않은 공유참조로 모두 변경되어 사이드 이펙트가 발생했다.


- 불변 객체
    - 객체의 상태(내부의 값, 필드, 멤버 변수)가 변하지 않는 객체이다.
    - 불변이라는 단순한 제약으로 사이드 이펙트의 큰 문제를 막을 수 있다.
        
        ```
        // 불변 객체
        public class ImmutableAddress {
            private final String value; // 내부 값이 변경되지 못하도록 final 키워드로 값을 고정
        
            public ImmutableAddress(String value) {
                this.value = value;
            }
        
            public String getValue() {
                return value;
            }
        
            // final로 고정했으므로 setter 사용 불가
            // final로 고정하지 않아도 setter를 사용하지 않으면 불변 객체지만 의도를 명확히 할 수 있다.
        //    public void setValue(String value) {
        //        this.value = value;
        //    }
        
            @Override
            public String toString() {
                return "Address{" +
                        "value='" + value + '\'' +
                        '}';
            }
        }
        
        public static void main(String[] args) {
            // 참조형 변수는 하나의 인스턴스를 공유할 수 있다.
            ImmutableAddress a = new ImmutableAddress("서울");
            ImmutableAddress b = a;                // 참조값 대입을 막을 수는 없다.
        
            System.out.println("a = " + a);        // 서울
            System.out.println("b = " + b);        // 서울
            
        //        b.setValue("부산");              // 불변 객체로 컴파일 오류
            b = new ImmutableAddress("부산");      // 다른 개발자가 못바꾼다는 것을 깨닫고 새로 생성
            System.out.println("부산 -> b");
            System.out.println("a = " + a);       // 서울
            System.out.println("b = " + b);       // 부산
        }
        ```
        


- 그러면 모두 불변으로 해야할까?
    - 가변으로 사용할 때는 가변으로 사용한다.
    - ex) 아이가 아직 어려서 아이의 주소를 변경할 때 가족 모두 변경하도록 여러 인스턴스를 하나로 참조한다.

- 불변 객체 사용 예시
    
    ```
    // 불변 객체 : 객체의 상태(내부의 값, 필드, 멤버 변수)가 변하지 않는 객체이다.
    public class ImmutableAddress {
        private final String value; // 내부 값이 변경되지 못하도록 final 키워드로 값을 고정
    
        public ImmutableAddress(String value) {
            this.value = value;
        }
    
        public String getValue() {
            return value;
        }
    
        // final로 고정했으므로 setter 사용 불가
    
        @Override
        public String toString() {
            return "Address{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
    
    public class MemberV2 {
        private String name;
        private ImmutableAddress address; // 불변 객체 사용
    
        public MemberV2(String name, ImmutableAddress address) {
            this.name = name;
            this.address = address;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public ImmutableAddress getAddress() {
            return address;
        }
    
        public void setAddress(ImmutableAddress address) {
            this.address = address;
        }
    
        @Override
        public String toString() {
            return "MemberV1{" +
                    "name='" + name + '\'' +
                    ", address=" + address +
                    '}';
        }
    }
    
    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울"); // 불변 객체의 주소 생성
    
        MemberV2 memberA = new MemberV2("회원A", address); // 서로 같은 주소 객체의 참조값으로 넣음
        MemberV2 memberB = new MemberV2("회원B", address); // 서로 같은 주소 객체의 참조값으로 넣음
    
        // 회원A, 회원B의 처음 주소는 모두 사용
        System.out.println("memberA = " + memberA);       // 서울
        System.out.println("memberB = " + memberB);       // 서울
    
        // 회원B의 주소만 부산으로 변경해야함
    //        memberB.getAddress().setValue("부산");      // 불변 객체로 인해 컴파일 오류
        memberB.setAddress(new ImmutableAddress("부산")); // 부산인 주소 객체를 새로 생성하고 객체 참조값 자체를 변경
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);      // 서울
        System.out.println("memberB = " + memberB);      // 부산
    }
    ```


- 불변 객체의 내부 값 변경
    - 불변 객체도 값을 변경해야 하는 메서드가 필요하면?
      - 기존 객체의 값을 그대로 두고
        
        변경된 값을 넣은 새로운 객체로 생성하고 반환한다.
        
        이때 관례로 명칭을 with로 사용한다.
        
        즉, 새로운 객체를 생성하므로 값이 자주 바뀔 경우 가변 객체로 하자.
        
    ```
    // 불변 객체
    public class ImmutableObj {
        private final int value;
    
        public ImmutableObj(int value) {
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }
    
        // 불변 객체에서의 필드 값 변경 메서드
        public ImmutableObj add(int addValue) {
            int result = value + addValue;
    
            // 필드 값을 변경하기 위해 새로 생성한 불변 객체를 반환한다.
            return new ImmutableObj(result);
        }
    }
    
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20); // 연산하여 변경된 값을 반환한 새로운 객체의 참조값을 새로운 객체 변수에 대입한다.
    
        // 계산 이후에도 기존값과 신규값 모두 확인이 가능
        System.out.println("obj1 = " + obj1.getValue()); // 10
        System.out.println("obj2 = " + obj2.getValue()); // 30
    }
    ```
    
    ```
    public class ImmutableMyDate {
        private final int year;
        private final int month;
        private final int day;
    
        public ImmutableMyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    
        // 불변 객체에서의 내부 값을 변경하려면
        // 새로운 객체로 생성해서 반환하기
        // 불변 객체에서 새로운 값을 넣어서 반환할 때는 with로 표현
        public ImmutableMyDate withYear(int newYear) {
            return new ImmutableMyDate(newYear, month, day);
        }
    
        public ImmutableMyDate withMonth(int newMonth) {
            return new ImmutableMyDate(year, newMonth, day);
        }
    
        public ImmutableMyDate withDay(int newDay) {
            return new ImmutableMyDate(year, month, newDay);
        }
    
        @Override
        public String toString() {
            return year + "-" + month + "-" + day;
        }
    }
    
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2024, 1, 1); // x001
        ImmutableMyDate date2 = date1;          // date1과 같은 객체 참조값으로 공유, x001
    
        System.out.println("date1 = " + date1); // 2024-1-1, x001
        System.out.println("date2 = " + date2); // 2024-1-1, x001
    
        System.out.println("2025 -> date1");
    
        date1 = date1.withYear(2025);           // 변경한 년도 값을 넣은 새로운 객체를 생성하여 반환된 참조값으로 변경, x002
        System.out.println("date1 = " + date1); // 2025-1-1, x002
        System.out.println("date2 = " + date2); // 2024-1-1, x001
    }
    ```


## <b id="5"> String 클래스, 비교 처리, 불변 객체 </b>
- 문자 하나는 기본형 char로 담는다.
- 여러 개의 문자일 때는 char[] 배열로 담는다.
- 하지만 위 방식은 불편하므로 자바에서 문자열을 매우 편리하게 만든 String 클래스를 사용한다.
- String 클래스 내부 구조에 char[] 배열인 필드가 있다. (자바 9이후 byte[] 배열로 변경)
    
    ```
    public static void main(String[] args) {
        // char은 문자 하나를 담는다.
        char a = '가';
        System.out.println("a = " + a);
    
        // 여러개의 문자를 담을려면 배열로 담아야 한다.
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(charArr);
    
        // 하지만 자바에서 문자열을 매우 편리하게 다룰 수 있는 String 클래스가 더 편하다.
        String str = "hello";
        System.out.println("str = " + str);
        
        // 문자열은 매우 자주 사용되어 편의상 쌍따옴표로 문자열을 감싸면 new String("")와 같이 변경해준다.
        String str1 = "hello";             // 자바에서 아래처럼 변경해준다.
        String str2 = new String("hello"); // 변경해주는 형태
    
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    		
        String a = "hello";           // x001
        String b = "java";              // x002
    
        String result1 = a.concat(b); // String 클래스에서 제공하는 이어붙이는 메서드
        String result2 = a + b;       // 원래 참조값끼리의 연산은 안되고 concat으로 이어붙여야 하지만 자바에서 편의상 + 연산으로 이어붙이게 제공해준 것
    
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
    ```
    

- String 클래스의 비교
    - String 클래스에서 비교할 때는 ==이 아닌 항상 equals()로 비교 해야한다.
    - 원래 기본 equals()는 동일성이지만
        
      String 클래스에서 equals()를 동등성으로 오버라이딩을 해줬기에 내부 문자 값이 같으면 true이다.
        
    
    - 기존 new String(””); 형태로 생성하면
        
      같은 문자열이어도 서로다른 참조값을 가진다.
        
      - ex)
      - String str1 = new String(”hello”); // x001
      - String str2 = new String(”hello”); // x002

    - String str = “hello”; 처럼 문자열 리터럴 형태인 경우

      <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/d7556333-250e-4597-a33a-f222dea8a14d" width="45%"/>

      - 자바는 성능 최적화를 위해 문자열 풀을 사용한다.
      - 자바가 실행되는 시점에 문자열 리터럴이 있으면 문자열 풀에 String 인스턴스를 미리 만들어둔다.
      - 이때 같은 문자열이 있으면 만들지 않고 해당 문자열의 인스턴스 참조값을 가진다.
      - ex) String str1 =”hello”;  // x001
      - String str2 = ”hello”; // x001

      - 풀
        - 공용 자원이 모여있는 곳
        - 공용으로 사용하면 재사용성을 향상시켜 성능과 메모리를 더 최적화 할 수 있다.

- String은 불변 객체
    - 불변 객체라서 생성 이후에 절대로 내부 문자 값을 변경할 수 없다.
    - 불변 객체로 설계한 이유는 문자열 풀은 같은 인스턴스를 공유할 수 있어 값이 변경되면 참조했던 다른 변수에도 사이드 이펙트가 발생하기 때문이다.
    - 그래서 변경한 값은 새로운 객체 결과를 만들어서 반환한다.
      
      <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/82a78029-da88-4b27-8fc3-21651e15f7d2" width="50%"/>
      
      - ex) String str1  = “hello”;
      - String str2 = str1.concat(“ java”);


## <b id="6"> String 클래스의 주요 메서드 </b>
<img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/51bde1ba-5e76-44f2-855a-f57266ddcb63" width="60%"/>


## <b id="7"> StringBuilder - 가변 String </b>
- String은 불변 객체로 변경할 때 새로운 객체로 생성하고 기존 객체는 GC로 버려진다.
- 즉, 변경이 많을 경우 메모리 자원 소모가 커진다.
- 값을 많이 변경할 경우 가변 String인 StringBuilder를 사용한다.
    - append() : 여러 문자열을 추가
    - insert()    : 특정 위치에 문자열을 삽입
    - delete()   : 특정 범위 문자열을 삭제
    - reverse()  : 문자열 뒤집기
    
- 단 변경에 의한 사이드 이펙트가 발생할 수 있으므로
    
  변경이 끝나면 안전한 불변 String으로 변환하는 것이 좋다.
    

- 자바에서는 String이어도 간단한 + 연산은
    
  자동으로 StringBuilder로 연산한 후 String으로 저장해서 최적화한다.
    
  - ex)
  - String result = str1 + str2; →  String result = new StringBuilder().append(str1).append(str2).toString();
  - 단, 루프 안에서 + 연산은 결국 StringBuilder가 반복 생성되므로 최적화가 안됨
    

- StringBuilder가 더 성능이 좋은 경우
    1. 반복문에서 1000번 이상의 반복해서 문자를 연결할 때
    2. 조건문을 통해 동적으로 문자열을 조합할 때
    3. 복잡한 문자열의 특정 부분을 변경해야 할 때
    4. 매우 긴 대용량 문자열을 다룰 때

- StringBuilder vs StringBuffer
    - 기능은 똑같다.
    - StringBuffer는 내부에 동기화가 되어 있어 멀티 스레드 상황에서 안전하지만
        
      오버헤드가 있어 성능이 더 느리다.
        
      (동기화 과정 = 순차적으로 실행시킴)


## <b id="8"> 메서드 체이닝 </b>
- 자기 객체 참조값으로 반환하게 하여 메서드 체이닝이 가능하도록 한다.
- 코드가 간결해지고 읽기 쉽게 만들어준다.
  
```
public class ValueAdder {
    private int value;

    public ValueAdder add(int addValue) {
        value += addValue;
        return this; // 반환을 자기 자신의 참조값으로 하여 메서드 체이닝 가능하도록함
    }

    public int getValue() {
        return value;
    }
}

public static void main(String[] args) {
    ValueAdder adder = new ValueAdder();     // x001

    // 자신 참조값을 반환하여 메서드 체이닝이 가능한 것이다!
    //           x001.add(1) x001.add(2) x001.add(3)  x001.getValue()
    int result = adder.add(1).add(2).add(3).getValue();

    System.out.println("result = " + result); // 6
}
```


## <b id="9"> 기본형과 래퍼 클래스, 활용법, 박싱/언박싱 </b>
- 기본형의 한계
1. 기본형은 **객체가 아니라서 객체 지향 프로그래밍의 장점을 살릴 수 없다**.
    - ex) 메서드, 컬렉션 프레임워크, 제네릭 사용 불가, null 값 못 가짐
2. 기본형은 **항상 값을 가져야 한다**.
        
   하지만 데이터가 ‘없음’이라는 상태가 필요할 때가 있다.
        
   값을 가져야하는 것은 좋은 제약이지만 때로는 없는 상태가 필요하다.


- 래퍼 클래스
    - 기본형으로 감싸서 만드는 클래스
    - 자바는 기본형에 대응하는 래퍼 클래스를 기본으로 제공한다.
        - byte → Byte
        - short → Short
        - int → Integer
        - long → Long
        - float → Float
        - double → Double
        - char → Character
        - boolean → Boolean
    - 특징
      1. **불변**이다.
      2. **equals()로 비교**해야 한다.
    
    - 래퍼 클래스의 활용법
      - 객체 내부에 만든 메서드를 사용할 수 있다.
      - 즉, 외부 메서드 필요없이 자신이 가진 메서드를 편리하게 호출할 수 있다.
            
        ```
        // 직접 만든 래퍼 클래스
        public class MyInteger {
            private final int value; // final로 불변 객체로 설계
        
            public MyInteger(int value) {
                this.value = value;
            }
        
            public int getValue() {
                return value;
            }
        
            // 객체의 장점인 스스로 자기 자신 값과 다른 값을 비교하는 메서드를 만들어서 더 유용해진다.
            public int compareTo(int target) {
                if (value < target) {
                    return -1;
                } else if (value > target) {
                    return 1;
                } else {
                    return 0;
                }
            }
        
            // 참조값을 호출하지 않고 내부 값을 출력하도록 오버라이딩
            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }
        
        public static void main(String[] args) {
            // 기본형의 한계1을 해결한 래퍼 클래스 활용
            MyInteger myInteger = new MyInteger(10);
        
            // 객체 내부에 만든 메서드로 자기 자신 값과 비교
            // 즉 외부 메서드 필요없이 자신이 가진 메서드를 편리하게 호출할 수 있다.
            int i1 = myInteger.compareTo(5);
            int i2 = myInteger.compareTo(10);
            int i3 = myInteger.compareTo(20);
        
            System.out.println("i1 = " + i1);
            System.out.println("i2 = " + i2);
            System.out.println("i3 = " + i3);
        }
        ```
            
        
      - 객체에서는 데이터가 없음이라는 상태를 사용할 수 있다. (null)
      - 기본형에서는 무조건 숫자로 반환해야 해서 실제 값들이 겹칠 수 있다.
            
        
        ```
        public static void main(String[] args) {
            // 기본형의 한계2를 해결한 래퍼 클래스 활용
            MyInteger[] intArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};
        
            // 객체에서는 데이터가 '없음'이라는 상태가 있다.(null)
            System.out.println(findValue(intArr, -1));  // 값을 찾아서 -1
            System.out.println(findValue(intArr, 0));   // 값을 찾아서 0
            System.out.println(findValue(intArr, 1));   // 값을 찾아서 1
            System.out.println(findValue(intArr, 100)); // 값을 못 찾아서 null
        }
        
        private static MyInteger findValue(MyInteger[] intArr, int target) {
            // 루프를 돌려 타겟 숫자가 있으면 해당 숫자 반환
            for (MyInteger myInteger : intArr) {
                if (myInteger.getValue() == target) {
                    return myInteger; // toString()으로 참조값이 아닌 실제값이 나오도록 오버라이딩한 것이다.
                }
            }
        
            // 루프에서 타겟 숫자를 못 찾은 경우 데이터가 없는 것이므로
            // 객체라서 null로 반환할 수 있다!
            return null;
        }
        ```
        
    - 박싱
        - 기본형을 래퍼 클래스로 변경하는 작업이다.
        - ex) Integer newInteger = Integer.valueOf(10);
    - 언박싱
        - 래퍼 클래스의 실제 기본형 값을 꺼내는 것
        - ex) int intValue = newInteger2.intValue();
    
    - 오토 박싱/언박싱
        - 자동으로 박싱/언박싱하는 것
        - 개발하다보면 박싱, 언박싱 과정이 자주 발생하여
            
          자바5부터 오토 박싱/언박싱을 지원한다.
            
            ```
            int value = 7;
            
            Integer boxedValue = value;     // 오토 박싱
            int unboxedValue = boxedValue;  // 오토 언박싱
            
            ```
            
    
- 기본형 vs 래퍼 클래스
    - 래퍼 클래스는 객체라서 내부 값과 메서드 등 다양하게 들어있어
    
      메모리 차지 비율이 기본형에 비해 약 3~4배정도 가진다.
    
    - 하지만 최근 CPU에서는 그렇게 성능을 많이 잡아먹지 않는다.
        
      (ex) 10억번 반복 연산일 때 기본형=0.2초, 래퍼 클래스=2초 → 큰 의미가 없음)
        
    - 즉, CPU 연산을 아주 많이 수행하는 특수한 경우라면 기본형을 사용해서 최적화를 고려하지만
        
      일반적으로는 코드 유지보수가 더 나은 것을 선택하면 된다.


## <b id="10"> Class 클래스 </b>
- 클래스의 정보(메타데이터)를 다루는데 사용된다.
- 실행 중인 자바 애플리케이션 내에서 필요한 클래스의 속성과 메서드에 대한 정보를 조회하고 조작할 수 있다.

- 주요 기능
    - **타입 정보 얻기** : 클래스 이름, 슈퍼클래스, 인터페이스, 접근 제한자 등과 같은 정보 조회
    - **리플렉션** : 클래스에 정의된 메서드, 필드, 생성자 등을 조회하고 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 등의 작업을 할 수 있다.
    - **동적 로딩과 생성** : Class.forName() 메서드를 사용하여 클래스를 동적으로 로드하고, newInstance() 메서드를 통해 새로운 인스턴스를 생성할 수 있다.
    - **애노테이션 처리** : 클래스에 적용된 애노테이션을 조회하고 처리하는 기능을 제공한다.

- 주요 메서드
    - getDeclaredFields() : 클래스의 모든 필드 조회
    - getDeclaredMethods : 클래스의 모든 메서드 조회
    - getSuperClass()    : 클래스의 부모 클래스들 조회
    - getInterfaces()    : 클래스의 인터페이스들 조회

- 리플렉션이란?
    - Class를 사용하여 클래스에 정의된 메서드, 필드, 생성자 등을 조회하고
        
      이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 등의 작업
        
    - 자주 사용되지는 않지만 프레임워크를 만들거나 자바의 깊이를 이해할 때 도움이 된다.

```
public class Hello {
    public String hello() {
        return "hello!";
    }
}

public static void main(String[] args) throws Exception {
    // Class 조회 방법 3가지
    Class clazz = String.class;                         // 1. 클래스에서 조회
    Class clazz2 = new String().getClass();             // 2. 인스턴스에서 조회
    Class clazz3 = Class.forName("java.lang.String");   // 3. 문자열로 조회

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
    
    
    // 리플렉션
    Class helloClass = Hello.class;
    Class helloClass2 = Class.forName("lang.clazz.Hello");

    Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance(); // 해당 클래스의 생성자를 기반으로 인스턴스를 생성한다는 뜻
    String result = hello.hello();
    System.out.println("result = " + result);
}
```


## <b id="11"> System 클래스 </b>
- 시스템과 관련된 기본 기능을 제공한다.

- 주요 기능
    - 표준 입력, 출력, 오류 스트림: System.in, System.out, System.err
    - 시간 측정 : System.currentTimeMillis(), System.nanoTime()
    - 환경 변수 : System.getenv()
    - 시스템 속성 : System.getProperties(), System.getProperty(String key)
    - 배열 고속 복사 : System.arraycopy() 시스템 레벨에서 최적화된 메모리 복사 연산을 사용하여 반복문을 사용한 복사보다 2~5배 빠른 성능 제공
    - 시스템 종료 : System.exit(int status) 프로그램을 종료하고 OS에 프로그램 종료의 상태 코드 전달
        - 상태 코드 0       : 정상 종료
        - 상태 코드 0이 아님 : 오류나 예외적인 종료

```
public static void main(String[] args) {
    // 현재 시간(밀리초)를 가져온다.
    long currentTimeMillis = System.currentTimeMillis();
    System.out.println("currentTimeMillis = " + currentTimeMillis);

    // 현재 시간(나노초)를 가져온다.
    long currentNano = System.nanoTime();
    System.out.println("currentNano = " + currentNano);


    // 운영체제에서 설정한 환경 변수를 읽는다.
    System.out.println("getenv = " + System.getenv());

    // 자바에서 사용하는 설정 값인 시스템 속성을 읽는다.
    System.out.println("properties = " + System.getProperties());
    System.out.println("Java version: " + System.getProperty("java.version"));


    // 배열을 고속으로 복사한다.
    // 기존은 반복문으로 일일히 하나씩 조회하고 넣는데 이 동작은 느리다.
    char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
    char[] copiedArray = new char[5];

    // 시스템에서 제공하는 배열 복사 메서드는 속도가 매우 빠르다. (2~5배)
    // 자바가 운영체제에게 넘기고 운영체제 하드웨어가 처리해준다.
    System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
    System.out.println("copiedArray = " + copiedArray); // 배열 참조값
    System.out.println("copiedArray = " + Arrays.toString(copiedArray)); // 배열 내부 값을 출력하는 유틸리티 메서드


    // 프로그램 종료
    // 프로그램 종료 전에는 실행된 것들을 모두 종료해야하므로
    // 이 기능은 가급적 사용을 권장하지 않는다.
    // ex) 웹 애플리케이션에서 종료해버리면 다른 사용자의 요청이 차단되고 작동이 안된다.
    System.exit(0);
}
```


## <b id="12"> Math, Random 클래스 </b>
- Math 클래스
    - 수 많은 수학 문제를 해결해주는 클래스
    - 주요 메서드
      
        <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/c564a385-3cca-4898-8122-7c3f000b3376" width="25%"/>

- Random 클래스
    - Math.random()을 사용해도 되지만
    - Random 클래스를 사용하면 더욱 다양한 랜덤값을 구할 수 있다.
    - seed가 같으면 랜덤의 결과가 동일하게 유지한다.
      - ex) 테스트 코드 같은 곳에서 같은 결과를 검증할 수 있다.

    ```
    public static void main(String[] args) {
    // Math.random()을 사용해도 되지만 Random 클래스를 사용하면 더욱 다양한 랜덤값을 구할 수 있다.
    Random random = new Random();
    Random random2 = new Random(1); // seed가 같으면 랜덤의 결과가 동일하다.

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
    ```


## <b id="13"> 열거형 (Enum Type) </b>
- 열거형이 필요한 이유
    - String 사용시 데이터 일관성과 타입의 안정성이 부족하기 때문이다.
    - ex) 오타를 입력해도 컴파일 오류가 발생하지 않고 작동함
        
        ```
        public static void main(String[] args) {
            // 존재하지 않는 등급을 넣을 경우
            // 컴파일 오류가 안나서 데이터 일관성과 타입 안정성이 부족하다!
            int price = 10000;
            DiscountService discountService = new DiscountService();
            
            // 존재하지 않은 등급을 넣음
            int vip = discountService.discount("VIP", price);
            System.out.println("VIP 등급 할인 가격 = " + vip);
        
            // 오타인 등급을 넣음
            int diamond = discountService.discount("DIAMONDD", price);
            System.out.println("DIAMOND 등급 할인 가격 = " + diamond);
        
            // 소문자 등급을 입력
            int gold = discountService.discount("gold", price);
            System.out.println("GOLD 등급 할인 가격 = " + gold);
        }
        ```
        
    - 즉, 특정 범위 값으로 제한해야 한다.

- 클래스의 상수를 미리 선언하여 사용한 방안
    - 이 방식을 사용하면 오타의 문제를 해결할 수 있다.
    - 하지만, 미리 선언한 클래스의 문자열 상수를 넣지 않고 일반 문자열을 넣을 수 있는 문제는 그대로다.
        
        ```
        public class StringGrade {
            public static final String BASIC = "BASIC";
            public static final String GOLD = "GOLD";
            public static final String DIAMOND = "DIAMOND";
        }
        
        public static void main(String[] args) {
            // 클래스에 미리 선언한 문자열 상수인 등급으로 할인 가격을 출력해보기
            // 선언된 등급을 가져오므로 오타시 컴파일 시점에 오류가 발생한다.
            
            int price = 10000;
            DiscountService discountService = new DiscountService();
        
            int basic = discountService.discount(StringGrade.BASIC, price);
            int gold = discountService.discount(StringGrade.GOLD, price);
            int diamond = discountService.discount(StringGrade.DIAMOND, price);
        
            System.out.println("BASIC 등급 할인 가격 = " + basic);
            System.out.println("GOLD 등급 할인 가격 = " + gold);
            System.out.println("DIAMOND 등급 할인 가격 = " + diamond);
        
            // 하지만, 미리 선언한 클래스의 문자열 상수를 넣지 않고 일반 문자열을 넣을 수 있는 문제는 그대로다!
            System.out.println("VIP 등급 할인 가격 = " + vip);
        }
        ```
        

- 타입 안전을 위한 열거형 패턴 활용 방안
    - 클래스의 각 문자열 상수를 미리 인스턴스로 생성한다.
    - 미리 생성한 인스턴스로만 비교해서 안전하게 해당 문자열 상수만 이용할 수 있게 된다.
    - 하지만, 해당 클래스를 따로 생성하여 사용하면 다른 인스턴스를 받아 문제가 발생한다.
        
      → 생성자를 private로 막음으로 해결
        
        ```
        public class ClassGrade {
            // 각 등급별로 상수를 선언한다.
            // 이때 각 상수마다 별도의 인스턴스를 생성하고 생성한 인스턴스를 대입한다.
            public static final ClassGrade BASIC = new ClassGrade();   // x001
            public static final ClassGrade GOLD = new ClassGrade();    // x002
            public static final ClassGrade DIAMOND = new ClassGrade(); // x003
        
            // 외부에서 생성하지 못하도록 생성자를 private로 막음
            private ClassGrade() {}
        }
        
        public class DiscountService {
            // 매개변수를 Enum 타입으로 받아옴
            public int discount(Grade classGrade, int price){
                int discountPercent = 0;
        
                // 미리 각 상수의 인스턴스를 생성한 Enum 타입이므로
                // 같은 참조값의 비교가 가능하다.
                if (classGrade == BASIC) {
                    discountPercent = 10;
                } else if (classGrade == GOLD) {
                    discountPercent = 20;
                } else if (classGrade == DIAMOND){
                    discountPercent = 30;
                } else {
                    System.out.println("할인X");
                }
        
                return price * discountPercent / 100;
            }
        }
        
        public static void main(String[] args) {
            // 각 상수는 모두 ClassGrade 타입을 기반으로 인스턴스를 만들었기 때문에
            // getClass()의 결과는 모두 ClassGrade
            System.out.println("class BASIC = " + ClassGrade.BASIC.getClass());
            System.out.println("class GOLD = " + ClassGrade.GOLD.getClass());
            System.out.println("class DIAMOND = " + ClassGrade.DIAMOND.getClass());
        
            // 각 상수는 모두 서로 다른 ClassGrade 인스턴스를 참조하기 때문에
            // 참조값이 모두 다르게 출력된다.
            System.out.println("ref BASIC = " + ClassGrade.BASIC);
            System.out.println("ref GOLD = " + ClassGrade.GOLD);
            System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);
        }
        
        public static void main(String[] args) {
            // ClassGrade의 각 상수는 미리 선언한 인스턴스의 참조값으로
            // 이 참조값이 같음을 활용하여 비교했다.
            int price = 10000;
            DiscountService discountService = new DiscountService();
        
            int basicDiscountPrice = discountService.discount(ClassGrade.BASIC, price);
            int goldDiscountPrice = discountService.discount(ClassGrade.GOLD, price);
            int diamondDiscountPrice = discountService.discount(ClassGrade.DIAMOND, price);
        
            System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
            System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
            System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
        
            // 생성자를 private로 막음으로 해결
            // ClassGrade newClassGrade = new ClassGrade();
        }
        ```
        

- 열거형 (Enum Type)
    - 타입 안전 열거형 패턴이다.
    - 클래스에 각 문자열 상수의 각 인스턴스를 미리 생성하여 이를 비교하는 패턴인데
        
      이 패턴을 편리하게 사용하도록 열거형을 제공한다.
        
    - ex) String에서 아무 문자열이나 사용할 수 있는 것이 아닌 나열한 항목만 안전하게 사용한다.
        
        ```
        public enum Grade { // 열거형을 정의할 때는 class 대신 enum으로 선언한다.
            // public static final ClassGrade BASIC = new ClassGrade();                   // x001
            // public static final enumeration.ex2.ClassGrade GOLD = new ClassGrade();    // x002
            // public static final ClassGrade DIAMOND = new ClassGrade();                 // X003
        
            // 위 방식과 같은 것으로 원하는 상수의 이름을 나열하면 된다.
            BASIC, GOLD, DIAMOND
        }
        
        public class DiscountService {
            // 매개변수를 Enum 타입으로 받아옴
            public int discount(Grade classGrade, int price){
                int discountPercent = 0;
        
                // 미리 각 상수의 인스턴스를 생성한 Enum 타입이므로
                // 같은 참조값의 비교가 가능하다.
                if (classGrade == Grade.BASIC) {
                    discountPercent = 10;
                } else if (classGrade == Grade.GOLD) {
                    discountPercent = 20;
                } else if (classGrade == Grade.DIAMOND){
                    discountPercent = 30;
                } else {
                    System.out.println("할인X");
                }
        
                return price * discountPercent / 100;
            }
        }
        
        public static void main(String[] args) {
            // Enum 타입의 각 상수는 미리 선언한 인스턴스의 참조값으로
            // 이 참조값이 같음을 활용하여 비교했다.
            int price = 10000;
            DiscountService discountService = new DiscountService();
        
            int basicDiscountPrice = discountService.discount(Grade.BASIC, price);
            int goldDiscountPrice = discountService.discount(Grade.GOLD, price);
            int diamondDiscountPrice = discountService.discount(Grade.DIAMOND, price);
        
            System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
            System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
            System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
        
            // 해당 클래스를 따로 생성하여 사용하면 다른 인스턴스를 받아 문제가 발생한다.
            // 하지만 Enum 타입은 private 생성자로 막아두었다.
            // Grade newClassGrade = new Grade();
        }
        ```
        
- Enum 타입의 장점
    - 타입 안정성 향상 : 사전에 정의된 상수들만 구성되므로 유효하지 않은 입력 값은 컴파일 시점에 오류가 발생한다.
    - 간결성 및 일관성 : 열거형을 사용하면 코드가 더 간결하고 명확해지며 데이터 일관성이 보장된다.
    - 확장성 : 새로운 상수를 편리하게 추가할 수 있다.
    
- 열거형의 주요 메서드
    - 모든 열거형은 java.lang.Enum 클래스를 자동으로 상속 받으므로
        
      해당 클래스가 제공하는 기능들을 사용할 수 있다.
        
      즉, 다른 객체를 상속 받을 수 없다.
        
    - 열거형은 인터페이스를 구현할 수 있다.
    - 추상 메서드를 선언하고 구현할 수 있다. (익명 클래스와 같은 방식)

    ```
    public static void main(String[] args) {
        // Enum 클래스의 주요 메서드
    
        // 모든 Enum 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values)); // 한번에 출력
        for (Grade value : values) {      // 각 이름과 순서 반환, 단 순서 ordianl()은 중간에 추가될 수 있으므로 사용하지 말자.
            System.out.println("name = " + value.name() + ", ordinal = " + value.ordinal());
        }
        
        // String -> Enum 변환, 잘못된 문자면 IllegalArgumentException 발생
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold); // toString() 오버라이딩 되어 상수 이름이 나옴
    }
    ```
    

## <b id="14"> 날짜와 시간 라이브러리 </b>
- 필요한 이유
    - 날짜와 시간을 계산하는 것은 실제로 매우 어렵고 복잡하다.
    - ex) 윤년, 각 달의 일수, 일광 절약 시간 변환, 세계별 타임존 계산 등 모두 고려해야함

- 자바의 날짜와 시간 라이브러리 역사
    1. JDK 1.0 (java.util.Date)
        - 타임 처리 부족 : 초기 Date 클래스는 타임존을 제대로 처리 못함
        - 불편한 날짜 시간 연산 : 날짜 간 연산이나 시간의 증감 등을 처리하기 어려웠음
        - 불변 객체 부재 : Date 객체는 변경 가능하여 데이터가 쉽게 변경될 수 있어 사이드 이펙트 발생
        
        → 이를 개선한 JDK 1.1의 Calendar 클래스
        
    2. JDK 1.1 (java.util.Calendar)
        - 사용성 저하 : Calendar 클래스는 사용하기 복잡하고 직관적이지 않음
        - 성능 문제 : 일부 사용 사례에서 성능 저하 문제
        - 불변 객체 부재 : Calendar 객체도 변경 가능하여 사이드 이펙트, 스레드 안전성 문제
        
        → 이를 개선한 Joda-Time
        
    3. Joda-Time 오픈소스 라이브러리
        - 표준 라이브러리가 아님 : 외부 라이브러리로 자바 표준에 포함되지 않아 프로젝트에 별도로 추가해야 함
        
        → 이를 개선한 JDK 8의 클래스들
        
    4. JDK 8(1.8)
        - 이전 API의 문제점 해결하면서 사용성, 성능, 스레드 안전성 타임존 처리 등에서 크게 개선되었다.
        - 불변 객체 설계로 사이드 이펙트, 스레드 안전성을 보장했고
        - 직관적인 API 제공으로 날짜, 시간 연산을 단순화했다.
        - LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Instant 등의 클래스를 포함
        - Joda-Time의 많은 기능을 표준 자바 플랫폼으로 가져온 것
    
- 날짜와 시간 라이브러리 소개

<img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/e851c685-d6c3-4350-9c69-3bfca032a60d" width="60%"/>

- 국내 시간 관련 클래스
    - LocalDate : 날짜만 표현할 때 사용한다. 년, 월, 일을 다름 ex) 2013-11-21
    - LocalTime : 시간만을 표현할 때 사용한다. 시, 분, 초를 다룸 ex) 08:20:30.12
    - LocalDateTime : LocalDate와 LocalTime을 합한 개념


- 글로벌 시간 관련 클래스
    - ZonedDateTime : 시간대를 고려한 날짜와 시간을 표현할 때 사용한다.
        - ex) 2013-11-21T08:20:30.12+9:00[Asia/Seoul]
        - +9:00은 UTC(협정 세계시)로 부터의 시간대 차이다. 오프셋이라고 한다. 한국은 UTC보다 +9시간이다.
        - Asia/Seoul은 타임존이다. 타임존을 알면 오프셋과 일광 절약 시간제를 알 수 있다.
    - OffsetDateTime : 시간대를 고려한 날짜와 시간을 표현할 때 사용한다.
        - ex) 2013-11-21T08:20:30.12+9:00
        - 타임존은 없어 일광 절약 시간제 적용 X
          
    - ZonedDateTime은 구체적인 지역 시간대를 다룰 때 사용되며 일광 절약 시간을 자동으로 처리해준다. 사용자 지정 시간대에 따른 시간 계산이 필요할 때 적합
        - ex) 회의시간 잡을때, 달력에 약속을 잡을때
    - OffsetDateTime은 UTC와의 시간 차이만 나타낼 때 사용된다.
        - ex) 시간대 변환없이 로그를 기록하고 데이터를 저장 처리할 때


- Year, Month, YearMonth, MonthDay
    - 년, 월, 년월, 달일을 다룰 때 사용하는 클래스들로 잘 사용 안함
    - DayOfWeek와 같은 월~일요일을 나타내는 Enum 클래스도 있다.

- Instant
    - UTC를 기준으로 하는 시간의 한 지점을 나타낸다.
    - 날짜와 시간을 나노초 정밀도로 표현하며 1970년 1월 1일 0시 0분 0초(UTC)를 기준으로 경과한 시간으로 계산된다.
    - 초 데이터만 들어있다. (나노초 포함)
    - 즉, 날짜 시간 계산할 때는 적합하지 않다.
    - 사용 예시)
        - 전 세계적인 시간 기준 필요시 : 전 세계 일관된 시점을 표현할 때 좋다.
        - 시간대 변환 없이 시간 계산 필요시 : 시간대 변화 없이 순수한 시간의 흐름(ex) 지속 시간 계산)만을 다룰 때 적합, 시간대 변환의 복잡성 없이 계산하기 때문
        - 데이터 저장 및 교환: DB에 날짜 시간 정보를 저장하거나 다른 시스템과 날짜와 시간 정보를 교환할 때 일관성 유지할 수 있다.
    
    - 특징
        - 장점
            - 시간대 독립성 : UTC 기준으로 전 세계 어디서나 동일한 시점
            - 고정된 기준점 : 동일한 시점이므로 시간 계산 및 비교가 명혹하고 일관됨
        - 단점
            - 사용자 친화적이지 않음 : 기계적인 시간 처리에 적합하지만
            - 시간대 정보 부재

- 시간의 개념
    1. 특정 시점의 시간(시각) 
        - ex) 2013년 8월 16일까지/11시30분에 진행/생일은 8월16일
    2. 시간의 간격(기간) 
        - ex) 앞으로 4년은 더 공부해야 해/3개월 남았어/3분 끓여야 해
    
- 시간의 간격을 나타내는 클래스
    - Peroid
        - 두 날짜 사이의 간격을 **년,월, 일** 단위로 나타내는 클래스
    - Duration
        - 두 시간 사이의 간격을 **시, 분, 초**(나노초) 단위로 나타내는 클래스


## <b id="15"> 날짜와 시간의 인터페이스 </b>
- 특정 시점의 시간과 시간의 간격 인터페이스
    - 날짜와 시간은 특정 시점의 시간(시각)과 시간의 간격(기간)으로 나눌 수 있으므로 인터페이스도 이 둘로 나뉘어져 있다.
 
     <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/1bf375d0-d90e-46ba-95a1-3e745d72ee45" width="60%"/>
    
    - TemporalAccessor 인터페이스
        - 날짜와 시간을 읽기 위한 기본 인터페이스
        - 이 인터페이스는 특정 시점의 날짜와 시간 정보를 읽을 수 있는 최소한의 기능을 제공한다.
          
    - Temporal 인터페이스
        - TemporalAccessor의 하위 인터페이스로 날짜와 시간을 조작하기 위한 기능을 제공한다.

    - TempoalAmount 인터페이스
        - 시간의 간격(시간의 양, 기간)을 나타내며
        
          날짜와 시간 객체를 적용하여 그 객체를 조정할 수 있다.
        
          ex) 특정 날짜에 일정 기간을 더하거나 빼는데 사용됨
        

- 시간의 단위와 시간 필드 인터페이스
    - 시간의 단위를 뜻하는 TemporalUnit(구현체 ChronoUnit)과
        
      시간의 필드를 뜻하는 TemporalField(구현체 ChronoField)이 있다.
        
    - 주로 날짜와 시간을 조회하거나 조작할 때 사용한다.
      
    <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/aa954f93-c547-4d37-850f-56790169a428" width="35%"/>

- TemporalUnit 인터페이스 (구현체 ChronoUnit)
    - 날짜와 시간을 측정하는 단위를 나타내며, 주로 사용되는 구현체는 ChronoUnit 열거형 클래스이다.
    - ChronoUnit은 다양한 시간 단위를 제공한다.

- TemporalField 인터페이스 (구현체 ChronoField)
    - TemporalField는 날짜와 시간을 나타내는데 사용된다.
    - ChronoField가 구현체인 열거형이다.
    - 이 열거형은 다양한 필드를 통해 **날짜와 시간의 특정 부분**을 나타낸다.
    - 년, 월, 일 시간, 분 등이 포함된다.
    - ex) 2024년 8월 16일
        - YEAR: 2024
        - MONTH_OF_YEAR: 8
        - DAY_OF_MONTH: 16

- TemporalAdjusters 클래스
    - with()는 아주 단순한 날짜만 변경할 수 있다.
    - 복잡한 날짜 계산하고 싶을 때 사용한다.
    - ex) TempralAdjusters.next(DayOfWeek.FRIDAY) : 다음주 금요일
    - TempralAdjusters.lastInMonth(DayOfWeek.SUNDAY) : 이번달 마지막 일요일
    - 제공하는 기능


## <b id="16"> 날짜와 시간 문자열 파싱과 포맷팅 </b>
- 포맷팅 : 날짜와 시간 데이터를 원하는 포맷의 문자열로 변경 (Date → String)
- 파싱     : 문자열을 날짜와 시간 데이터로 변경하는 것             (String → Date)

- DateTimeFormatter 클래스
    - LocalDate와 같은 날짜 객체를 원하는 형태의 문자로 변경할 때 사용한다.
    - ofPattern() 메서드로 원하는 포맷을 지정하면 된다.
    - ex) DateTimeFormatter fomatter = DateTimeFormatter.*ofPattern*("yyyy년 MM월 dd일");

- 포맷팅 파싱 예시
  
```
public static void main(String[] args) {
    // 포맷팅 : 날짜 -> 문자열로 변경
    LocalDate date = LocalDate.of(2024, 12, 31);
    System.out.println("date = " + date);

    // get()메서드를 활용한 난잡한 포맷팅 방식
    System.out.println(date.getYear() + "년 " + date.getMonthValue() + "월");

    // DateTimeFormatter를 활용한 포맷팅 방식 = 코드 작성에 더 효율적
    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    String formattedDate = date.format(fomatter);
    System.out.println("날짜와 시간 포맷팅 = " + formattedDate);


    // 파싱 : 문자열 -> 날짜로 변경
    String input = "2030년 01월 01일";
    LocalDate parsedDate = LocalDate.parse(input, fomatter);
    System.out.println("parsedDate = " + parsedDate);
}
```  


## <b id="17"> 중첩 클래스, 내부 클래스, 지역 클래스와 지역 변수 캡처, 익명 클래스 </b>
- 중첩 클래스
    - 클래스 안에 클래스를 중첩해서 정의한 클래스
    - 특정 클래스가 다른 하나의 클래스 안에서만 사용되거나,
        
      둘이 아주 긴밀하게 연결된 경우에만 사용된다.
        
    - 논리적인 그룹화, 캡슐화를 위한 목적으로 사용

      <img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/08873e88-8b73-42a5-8b1c-ff94876f936c" width="25%"/>


- 중첩 클래스는 크게 static에 따른 2가지로 분류
  
<img src="https://github.com/K-Y-k/practice_java_basic/assets/102020649/8a26802b-5f2b-4fe7-98c2-43540f559b51" width="35%"/>

1. 정적 중첩 클래스 → static을 붙인 중첩 클래스
2. 내부 클래스         → static이 붙지 않는 클래스
    - 내부 클래스
    - 지역 클래스 → 내부 클래스 + 지역 변수와 같은 위치에 선언
    - 익명 클래스 → 지역 클래스 + 클래스 이름이 없는 특별한 클래스
- static은 인스턴스에 소속되지 않으므로

  정적 중첩 클래스는 바깥 클래스 인스턴스에 소속되지 않고 내부 클래스는 바깥 클래스 인스턴스에 소속된다.

- **중첩은 위치만 내부에 있는 것**이고

  **내부는 바깥 클래스의 구성 요소**인 것


- 지역 클래스
    - 내부 클래스의 종류 중 하나로
    - 내부클래스의 특징을 가지면서
        
      지역 변수와 같은 위치인 코드 블록 안에서 정의된다.
        
    - 지역 변수와 같은 특징으로 클래스에 private 같은 접근 제어자 사용 불가능

- 지역 클래스의 지역 변수 캡처
    - 지역 변수와 인스턴스 변수의 생명주기가 서로 다른데
        
      만약 지역 클래스에서 바깥의 지역 변수를 사용할 때 지역 클래스의 인스턴스와 바깥의 지역 변수 주기가 달라 접근이 불가능 해질 수 있다.
        
    - 이 문제를 해결하기 위해
        
      인스턴스를 생성할 때 바깥의 지역 변수를 사용하는 것들은 캡처해서 가져온다.
        
    - 즉, 지역 클래스가 접근하는 지역 변수는 절대로 중간에 값이 변하면 안된다.
        
      그래도 변경을 하려면 새로운 변수에 저장해서 사용한다.
        
    
    ```
    public class LocalOuterV3 {
        private int outInstanceVar = 3;        // 바깥 클래스의 인스턴스 멤버
    
        public Printer process(int paramVar) { // 매개변수
            int localVar = 1; // 지역변수 = 스택 프레임이 종료되는 순간 함께 제거된다.
    
            // 지역 클래스
             class LocalPrinter implements Printer{
                 int value = 0; // 지역 클래스의 인스턴스 멤버
    
                 // 지역 클래스의 인스턴스를 생성할 때는
                 // 지역 클래스에서 사용하는 바깥의 지역 변수는 캡처를 한다.
                 // 즉, 지역 클래스가 접근하는 지역 변수는 절대로 중간에 값이 변하면 안된다.
                 // int localVar = 1;
                 // int paramVar = 2;
    
                 @Override
                 public void print() {
                     // 자신의 인스턴스 멤버 접근 가능
                     System.out.println("value = " + value);
    
                     // 인스턴스는 지역 변수보다 더 오래 살아남는다.
                     System.out.println("localVar = " + localVar);
    
                     // 매개변수 접근 가능
                     System.out.println("paramVar = " + paramVar);
    
                     // 내부 클래스이므로 바깥 클래스의 인스턴스 멤버 접근 가능
                     System.out.println("outInstanceVar = " + outInstanceVar);
                 }
            }
    
            // 인스턴스를 생성하는 시점에 지역 변수 캡처가 진행된 것이다.
            LocalPrinter printer = new LocalPrinter();
            //printer.print();를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.
            
            /**
             * 만약 캡처한 지역 변수의 값을 변경하려면?
             * => 동기화 문제로 사이드 이펙트가 발생하므로 절대 변경 못하게 막았다.
             */
            // localVar = 10; // 사용되는 곳에서 컴파일 오류
    
            /**
             * 대안은 새로운 변수를 선언해서 적용할 수 있다.
             */
            int newLocalVar = 10;
            
            return printer;
        }
    
        public static void main(String[] args) {
            LocalOuterV3 localOuter = new LocalOuterV3();
    
            // process()가 메서드 영역의 스택 프레임으로 생성하고
            // 실행이 끝나면 그 안의 지역 변수들의 생존이 종료된다.
            Printer printer = localOuter.process(2); // Printer 인스턴스 생존 시작
    
            // 하지만 여기서 위 생존이 끝난 지역 변수를 접근하는데 정상적으로 실행되었다.
            // 지역 변수의 생명 주기는 짧고 인스턴스의 생명 주기는 길어서 발생하는 문제다.
            printer.print(); // 여기서 실행한다. 즉, process()의 스택 프레임이 사라진 후에 실행
    
            // 이 문제를 해결하기 위해 지역 클래스의 인스턴스를 생성하는 시점에 필요한 지역 변수를 복사해서
            // 생성한 인스턴스에 함께 넣어두는 변수 캡처이다.
            System.out.println("필드 확인");
            Field[] fields = printer.getClass().getDeclaredFields();
            for (Field field : fields) {
                System.out.println("field = " + field); // 캡처한 바깥의 지역 변수도 같이 나온다.
            }
        }
    }
    ```
    

- 익명 클래스
    - 지역 클래스인데 클래스의 이름이 없다는 특징이 추가된 클래스
    - 이 특징으로 지역 클래스는 선언과 생성이 따로 사용되었지만
        
      익명 클래스는 클래스의 이름을 생략하고 선언과 생성을 한번에 처리할 수 있다. 
        
    - 익명 클래스는 부모 클래스를 상속 받거나 인터페이스가 필요하다.
    - 기본 생성자만 사용되고 다른 생성자를 가질 수 없다.
    
    ```
    // 지역 클래스
    // 선언
    class LocalPrinter implements Printer {
    }
    // 생성
    Printer printer = new LocalPrinter();
    
    // 익명 클래스
    // 생성과 선언 한번에
    Printer printer = new Printer() {
    }
    ```
    
    - 클래스를 별도로 정의하지 않고도 추상 클래스를 즉석에서 구현하여 코드가 더 간결해진다.
        
      즉, 지역 클래스가 일회성으로 사용되거나 간단한 구현일 때 사용된다.
        
    - 하지만 복잡하거나 재사용이 필요한 경우에는 별도의 지역 클래스를 정의하는 것이 좋다.


## <b id="18"> 예외 </b>



## <b id="19"> 체크 예외, 언체크 예외 </b>



## <b id="20"> 예외 처리 try, catch, finally, try-with-resources </b>



## <b id="21"> 예외 계층화 </b>



## <b id="22"> 실무 예외 처리 방안 </b>
