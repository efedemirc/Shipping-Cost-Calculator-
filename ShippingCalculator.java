import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;

    public Product(String name, double width, double height, double length, double weight) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {

        return (this.width / 100) * (this.height / 100) * (this.length / 100);
    }
}

class Container {
    private String type;
    private double height;
    private double width;
    private double length;

    public Container(String type, double height, double width, double length) {
        this.type = type;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }
}

public class ShippingCalculator {
    private List<Product> products;
    private List<Container> containers;

    public ShippingCalculator() {
        this.products = new ArrayList<>();
        this.containers = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addContainer(Container container) {
        this.containers.add(container);
    }

    public boolean canFit(Product product, Container container) {
        return (product.getWidth() / 100) <= container.getWidth() &&
               (product.getHeight() / 100) <= container.getHeight() &&
               (product.getLength() / 100) <= container.getLength();
    }

    public void displayShippingInfo() {
        for (Container container : containers) {
            System.out.println(container.getType() + " can contain:");
            for (Product product : products) {
                if (canFit(product, container)) {
                    double p_width = product.getWidth() / 100;
                    double p_height = product.getHeight() / 100;
                    double p_length = product.getLength() / 100;
                    int qty_w = (int) (container.getWidth() / p_width);
                    int qty_h = (int) (container.getHeight() / p_height);
                    int qty_l = (int) (container.getLength() / p_length);
                    int quantity = qty_w * qty_h * qty_l;
                    System.out.println(" - " + quantity + " " + product.getName());
                } else {
                    System.out.println(" - " + product.getName() + " does not fit in " + container.getType());
                }
            }
        }
    }

    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();

        Product laptop = new Product("Laptop", 60, 50, 50, 6.5);
        Product mouse = new Product("Mouse", 30, 30, 20, 0.2);
        Product desktop = new Product("Desktop", 100, 150, 50, 20.0);
        Product lcdScreen = new Product("LCD Screen", 120, 140, 80, 2.6);

        calculator.addProduct(laptop);
        calculator.addProduct(mouse);
        calculator.addProduct(desktop);
        calculator.addProduct(lcdScreen);

        Container smallContainer = new Container("Small Container", 2.59, 2.43, 6.06);
        Container bigContainer = new Container("Big Container", 2.59, 2.43, 12.01);

        calculator.addContainer(smallContainer);
        calculator.addContainer(bigContainer);

        calculator.displayShippingInfo();
    }
}
