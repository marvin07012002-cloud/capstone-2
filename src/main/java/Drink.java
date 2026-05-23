public class Drink implements PriceItem {
    Size size;

    public Drink(Size size) {
        this.size = size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {

        double price = 0;
        switch (this.size) {
            case SMALL:
                price = 2.00;
                break;
            case MEDIUM:
                price = 2.50;
                break;
            case LARGE:
                price = 3.00;
                break;
            default:
                throw new RuntimeException("invalid size");
        }

        return price;
    }

    @Override
    public void displayDetails() {
        System.out.println("Drink");
        System.out.println(" Size: " + this.size);
        System.out.printf(" Price: $%.2f\n",getPrice());
    }
}
