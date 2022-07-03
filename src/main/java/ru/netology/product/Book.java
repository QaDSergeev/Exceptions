package ru.netology.product;

public class Book extends Product {
    private final String author;

    public Book(int id, String name, int cost, String author) {

        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {

        return author;
    }

    @Override
    public boolean matches(String search) {

        boolean isMatch = super.matches(search);

        if (!isMatch) {

            isMatch = getAuthor().contains(search);
        }

        return isMatch;
    }
}