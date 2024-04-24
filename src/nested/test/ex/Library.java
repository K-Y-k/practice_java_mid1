package nested.test.ex;

public class Library {
    private int bookCount;
    private Book[] books;

    public Library(int size) {
        books = new Book[size];
        bookCount = 0;
    }


    // Library 인스턴스를 사용할 일이 없으므로
    // 정적 중첩 클래스로 선언한다. 추가로 외부에 노출되면 안된다고 했으므로 private
    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }


    public void addBook(String title, String author) {
        // 검증 로직 분리
        if (bookCount == books.length) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }

        // 정상 로직
        books[bookCount] = new Book(title, author);
        bookCount++;
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");

        // 배열로 고정 생성했으므로 책을 모두 넣지 않은 상황일 때가 있으므로
        // 모두 조회하는 향상된 for문은 사용하면 안된다.
        for (int i = 0; i < bookCount; i++) {
            System.out.println("도서 제목: " + books[i].title + ", 저자: " + books[i].author);
        }
    }
}
