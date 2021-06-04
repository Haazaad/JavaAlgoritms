package ru.haazad.homework5;

public class Entity {
    private String name;
    private int weight;
    private int price;

    public Entity(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
