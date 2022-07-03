package ru.netology.product;

public class Smartphone extends Product {

    private final String manufacture;

    public Smartphone(int id, String name, int cost, String manufacture) {

        super(id, name, cost);

        this.manufacture = manufacture;
    }

    public String getManufacture() {

        return manufacture;
    }

    @Override
    public boolean matches(String search) {

        boolean isMatch = super.matches(search);

        if (!isMatch) {

            isMatch = getManufacture().contains(search);
        }

        return isMatch;
    }
}
