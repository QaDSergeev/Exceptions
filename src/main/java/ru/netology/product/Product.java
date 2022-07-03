package ru.netology.product;

public class Product {

    protected int id;
    protected final String name;
    protected final int cost;

    protected Product(int id, String name, int cost) {

        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {

        return this.id;
    }

    public String getName() {

        return this.name;
    }

    public boolean matches(String search) {

        return getName().contains(search);
    }
}
