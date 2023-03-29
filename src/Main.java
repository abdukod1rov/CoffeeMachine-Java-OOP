import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        MoneyMachine moneyMachine = new MoneyMachine(cm);
        cm.addCoffee("Cappuccino", 7000, 100, 100, 100);
        cm.addCoffee("Espresso", 6000, 100, 100, 100);
        cm.addCoffee("Latte", 7000, 100, 50, 150);
        moneyMachine.addCard("7", 50000);
        moneyMachine.addCard("11", 10000);
        moneyMachine.addCard("24", 7500);
        Scanner myObj = new Scanner(System.in);  // Create a scanner object
        System.out.println("Welcome to Coffee Machine!");
        while (true) {
            System.out.println("\n");
            System.out.println("What would you like to do in the machine?(s to sell, a to add card, d to display cards," +
                    "p to get profit report,r to refill a product, m to display menu, c to charge card, g to get product report, e to exit)");
            String answer = myObj.nextLine();
            if (answer.equals("s")) {
                cm.displayMenu();
                System.out.println("What would you like?: ");
                String chosenCoffee = myObj.nextLine();
                System.out.println("Please enter your card number!: ");
                String cardNumber = myObj.nextLine();
                if (cm.availableCoffee(chosenCoffee)) {
                    if (cm.isResourcesSufficient(chosenCoffee)) {
                        if (moneyMachine.isCardExists(cardNumber)) {
                            if (Double.compare(moneyMachine.getCredit(cardNumber), cm.menu.getPrice(chosenCoffee)) >= 0) {
                                cm.makeCoffee(chosenCoffee);
                                moneyMachine.makePayment(chosenCoffee, cardNumber);
                            } else { // if card has not enough money
                                System.out.println("Not enough money!");
                            }

                        } else {
                            System.out.println("No card exists !");
                        }
                    } else {
                        System.out.println("Sorry, there is not enough resources!");
                    }

                } else {
                    System.out.println("Sorry, there is no such coffee!");
                }
            }

            if (answer.equals("a")) {
                System.out.println("Please enter your card number!: ");
                String card = myObj.nextLine();
                System.out.println("Please enter your credit!: ");
                double credit = myObj.nextDouble();
                moneyMachine.addCard(card, credit);
            }
            if (answer.equals("d")) {
                moneyMachine.displayCards();
            }
            if (answer.equals("p")) {
                moneyMachine.getProfitReport();
            }

            if (answer.equals("m")) {
                cm.displayMenu();
            }
            if (answer.equals("e")) {
                break;
            }
            if (answer.equals("r")) {
                System.out.println("What would you like to refill? (water, coffee, milk)");
                String product = myObj.nextLine();
                System.out.println("How much would you like to refill?");
                int amount = myObj.nextInt();
                cm.refillProduct(product, amount);
            }

            if (answer.equals("c")) {
                System.out.println("Please enter your card number!: ");
                String cardNumber = myObj.nextLine();
                System.out.println("Please enter your credit!: ");
                double credit = myObj.nextDouble();
                moneyMachine.rechargeCard(cardNumber, credit);
            }
            if (answer.equals("g")) {
                cm.getProductReport();
            }
        }
    }
}