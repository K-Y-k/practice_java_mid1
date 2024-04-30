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

  ex1) 모든 객체를 받을 수 있는 메서드를 만들 수 있다.
  
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


  ex2) 모든 객체를 저장할 수 있는 배열을 만들 수 있다.

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
    
    ```java
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



## <b id="6"> String 클래스의 주요 메서드 </b>



## <b id="7"> StringBuilder - 가변 String </b>



## <b id="8"> 메서드 체이닝 </b>



## <b id="9"> 기본형과 래퍼 클래스, 활용법, 박싱/언박싱 </b>



## <b id="10"> Class 클래스 </b>



## <b id="11"> System 클래스 </b>



## <b id="12"> Math, Random 클래스 </b>



## <b id="13"> 열거형 (Enum Type) </b>



## <b id="14"> 날짜와 시간 라이브러리 </b>



## <b id="15"> 날짜와 시간의 인터페이스 </b>



## <b id="16"> 날짜와 시간 문자열 파싱과 포맷팅 </b>



## <b id="17"> 중첩 클래스, 내부 클래스, 지역 클래스와 지역 변수 캡처, 익명 클래스 </b>



## <b id="18"> 예외 </b>



## <b id="19"> 체크 예외, 언체크 예외 </b>



## <b id="20"> 예외 처리 try, catch, finally, try-with-resources </b>



## <b id="21"> 예외 계층화 </b>



## <b id="22"> 실무 예외 처리 방안 </b>
