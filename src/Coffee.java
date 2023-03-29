public class Coffee {
    String name;
    double water;
    double milk;
    double coffeeAmount;
    double price;


    public Coffee(String name, double price, double coffeeAmount, double milk, double water) {
        this.water = water;
        this.milk = milk;
        this.coffeeAmount = coffeeAmount;
        this.price = price;
        this.name = name;

    }
    public  Coffee() {

    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", water=" + water + "mL" +
                ", milk=" + milk + "mL" +
                ", coffee=" + coffeeAmount + "mL" +
                ", cost=" + price + " so'm" +
                '}';
    }


}



