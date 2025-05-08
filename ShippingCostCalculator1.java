package HOMEWORK;

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double width;
    double height;
    double length;
    double weight;

    public Product(String name, double width, double height, double length, double weight) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public double getVolume() {
        
        return (this.width / 100) * (this.height / 100) * (this.length / 100);
    }
}

class Container {
    String type;
    double height;
    double width;
    double length;

    public Container(String type, double height, double width, double length) {
        this.type = type;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }
}

public class ShippingCostCalculator1 {

    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 60, 50, 50, 6.5);
        Product mouse = new Product("Mouse", 30, 30, 20, 0.2);
        Product desktop = new Product("Desktop", 100, 150, 50, 20.0);
        Product lcdScreen = new Product("LCD Screen", 120, 140, 80, 2.6);

        List<Product> products = new ArrayList<>();
        products.add(laptop);
        products.add(mouse);
        products.add(desktop);
        products.add(lcdScreen);


        Container smallContainer = new Container("Small Container", 2.59, 2.43, 6.06);
        Container bigContainer = new Container("Big Container", 2.59, 2.43, 12.01);

        List<Container> containers = new ArrayList<>();
        containers.add(smallContainer);
        containers.add(bigContainer);

        for (Container container : containers) {
            System.out.println(container.type + " can contain:");
            for (Product product : products) {
                int quantity = (int) (container.getVolume() / product.getVolume());
                System.out.println(" - " + quantity + " " + product.name);
            }
        }
    }
}
