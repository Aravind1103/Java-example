package com.dp.prototype;

public class Book implements Cloneable {
    private final String name;
    private final String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(Book book) {
        this.name = book.name;
        this.author = book.author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
