public class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayBook() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("12345", "Java Basics", "John Doe");
        ebook.displayBook();
        System.out.println("Author: " + ebook.getAuthor());
    }
}
