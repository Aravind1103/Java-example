package com.dp.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookShop1 implements BookShop {

    private final String name;
    private final List<Book> books;

    public BookShop1(String name, List<Book> books) {
        this.name = name;
        this.books = List.copyOf(books);
    }

    public BookShop1(BookShop1 bookShop1) {
        this.name = bookShop1.name;
        this.books = List.copyOf(bookShop1.books);
    }

    @Override
    public void printBookDetails() {
        System.out.println(books);
    }


    /**
     * Problem with below method is it do shallow copy. So both prototype and this share same reference for books and book elements
     * This should be fine when both List<String> books and Book are immutable. But if we want new copy everything we need to go for deep copy.
     */
    @Override
    public BookShop1 clone() {
        try {
            return (BookShop1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Below functions solves reference in this class. but still it will fail if we have nested references
     */
    public BookShop1 cloneWithSolveMutableReference() {
        return new BookShop1(this);
    }

    /**
     * Below functions solves both reference field and nested reference field in this class. but it requires copy constructors
     */
    public BookShop1 cloneWithSolveBothMutableReference() {
        List<Book> clonedBooks = books.stream().map(Book::new).collect(Collectors.toList());
        return new BookShop1(name, clonedBooks);
    }

    /**
     * Below functions solves both reference field and nested reference field in this class. but all the references should implement clonable
     */
    public BookShop1 cloneWithSolveBothMutableReferenceUsingClone() {
        List<Book> clonedBooks = books.stream().map(Book::clone).collect(Collectors.toList());
        return new BookShop1(name, clonedBooks);
    }

    /**
     * Use the below method both BookShop1 and Book should implement Serializable interface
     */
    public BookShop1 deepCopy() {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {

            // Serialize this object
            out.writeObject(this);

            // Deserialize to create a deep copy
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream in = new ObjectInputStream(bis)) {
                return (BookShop1) in.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to deep copy object", e);
        }
    }
}
