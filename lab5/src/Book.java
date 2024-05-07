import java.util.Objects;

public class Book {
    public String title;
    public String author;
    public int article;

    public boolean equals(Book obj) {
        return Objects.equals(title, obj.title) && Objects.equals(author, obj.author) && article == obj.article;
    }
    @Override
    public String toString() {
        return "title: " + title + ", author: " + author + ", article: " + article;
    }

    public Book(String title, String author, int article) {
        this.title = title;
        this.author = author;
        this.article = article;
    }
    public Book() {
        this.title = "Anonymous";
        this.author = "Anonymous";
        this.article = 0;
    }
}
