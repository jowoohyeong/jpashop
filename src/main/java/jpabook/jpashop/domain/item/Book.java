package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;

    //==생성메서드==//
    public static Book createBook(String name, String isbn, String author, int price, int count) {
        Book book = new Book();

        book.setAuthor(author);
        book.setName(name);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setStockQuantity(count);

        return book;
    }
}
