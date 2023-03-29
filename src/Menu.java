public class Menu {
    Coffee[] coffees = new Coffee[3];
    int currentPosition = 0;

    public Menu() {
        for (int i = 0; i < coffees.length; i++) {
            coffees[i] = new Coffee();
        }
    }


    public void addCoffee(String name, double price, double coffeeAmount, double milkAmount, double waterAmount) {
        Coffee coffee = new Coffee(name, price, coffeeAmount, milkAmount, waterAmount);
        coffees[currentPosition++] = coffee;

    }

    public void print() {
        boolean coffeeAvailable = false;
        for (Coffee coffee : coffees) {
            if (coffee.name == null) {
                break;
            }
            if (coffee != null) {
                coffeeAvailable = true;
                System.out.println(coffee.name);

            }
        }
        if (!coffeeAvailable) {
            System.out.println("No coffee available right now!");
        }
    }

    public double getPrice(String coffeeName) {
        double price = 0.0;
        for (Coffee coffee1 : coffees) {
            if (coffee1!= null && coffeeName.equals(coffee1.name)) {
                price = coffee1.price;
                break;
            }
        }
        return price;
    }


}
