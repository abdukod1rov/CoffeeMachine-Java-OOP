public class CoffeeMachine {


    double water = 700;
    double milk = 800;
    double coffee = 900;
    public Menu menu = new Menu();

    public boolean isResourcesSufficient(String drink) {
        boolean canMake = false;
        for (Coffee mycoffee : menu.coffees) {
            if (drink.equals(mycoffee.name)) {
                if (water > mycoffee.water && milk > mycoffee.milk && coffee > mycoffee.coffeeAmount) {
                    canMake = true;
                } else {
                    canMake = false;
                }

            }
        }
        return canMake;

    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "water=" + water +
                ", milk=" + milk +
                ", coffee=" + coffee +
                ", menu=" + menu +
                '}';
    }

    public void makeCoffee(String order) {
        for (Coffee coffee2 : menu.coffees) {
            if (order.equals(coffee2.name)) {
                water -= coffee2.water;
                milk -= coffee2.milk;
                coffee -= coffee2.coffeeAmount;
                System.out.println("Here is your " + order + "☕️.Enjoy!");
            }

        }
    }

    public void addCoffee(String name, double price, double coffeeAmount, double milkAmount, double waterAmount) {
        menu.addCoffee(name, price, coffeeAmount, milkAmount, waterAmount);

    }


    public void refillProduct(String productName, int amount) {
        if (productName.equals("water")) {
            water += amount;
        } else if (productName.equals("milk")) {
            milk += amount;

        } else if (productName.equals("coffee")) {
            coffee += amount;
        }
        else {
            System.out.println("Invalid product name!");
            return;
        }
        System.out.println("Refilled " + productName + " by " + amount + " mL");

    }

    public boolean availableCoffee(String coffeeName) {
        boolean availableCoffee = false;
        for (Coffee coffee1 : menu.coffees) {
            if (coffeeName.equals(coffee1.name)) {
                availableCoffee = true;

            }
        }
        return availableCoffee;
    }


    public void displayMenu() {
        menu.print();
    }
    public void getProductReport() {
        System.out.println("Coffee:" + coffee + " mL\nWater:" + water + " mL\nMilk:" + milk + " mL");
    }
}
