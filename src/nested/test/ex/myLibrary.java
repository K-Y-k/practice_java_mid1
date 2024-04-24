package nested.test.ex;

// 내가 시도한 코드
public class myLibrary {
    private int bookCount;
    private Book[] books = new Book[bookCount];

    public myLibrary(int size) {
        this.bookCount = size;
    }


    class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }


    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);

        for (Book book : books) {
            if (book.title.equals("")) {
                book.title = newBook.title;
                book.author = newBook.author;
            }
        }
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (Book book : books) {
            System.out.println("도서 제목: " + book.title + ", 저자: " + book.author);
        }
    }
}
