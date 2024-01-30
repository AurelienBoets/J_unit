package org.example.model;

public class Product {
    private String name;
    private int sellIn;
    private int quality;
    private ProductEnum type;

    private int increment;

    public Product(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = ProductEnum.OTHER;
    }

    public Product(String name, int sellIn, int quality, ProductEnum type) {
        this(name, sellIn, quality);
        this.type = type;
    }

    private void defineIncrement() {
        switch (type) {
            case DAIRY -> increment = -2;
            case CHEESE -> increment = 1;
            default -> increment = -1;
        }
        if (sellIn <= 0 && this.type != ProductEnum.CHEESE)
            increment *= 2;
    }

    public void update() {
        defineIncrement();
        this.sellIn--;
        this.quality += this.increment;
        if (this.quality > 50)
            this.quality = 50;
        if (this.quality < 0)
            this.quality = 0;
    }

    public int getQuality() {
        return quality;
    }
}
