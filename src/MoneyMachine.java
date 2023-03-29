
public class MoneyMachine {
    private CoffeeMachine coffeeMachine;

    PaymentCard[] paymentCards = new PaymentCard[10];
    double profit = 0.0;
    double moneyReceived = 0.0;
    int cPosition = 0;


    public MoneyMachine(CoffeeMachine coffeeMachine) { // create a null array that stores 3 elements
        for (int i = 0; i < paymentCards.length; i++) {
            paymentCards[i] = new PaymentCard();
            this.coffeeMachine = coffeeMachine;

        }
    }

    public void addCard(String cardID, double credit) {
        PaymentCard paymentCard = new PaymentCard(cardID, credit);
        paymentCards[cPosition++] = paymentCard;
        System.out.println("Card is added");
    }


    public void getProfitReport() {
        System.out.println("Profit is " + profit + " so'm");
    }


    public void makePayment(String coffeeName, String ID) {
        double cost = coffeeMachine.menu.getPrice(coffeeName);
        double cardAmountLeft = 0;
        moneyReceived = this.getCredit(ID);
        for (PaymentCard card : paymentCards) {
            if (ID.equals(card.cardID)) {
                cardAmountLeft = card.credit - cost;
                card.credit = cardAmountLeft;
                break;
            }
        }
        if (moneyReceived >= cost) {
            double change = moneyReceived - cost;
            String builder = "And here is your " +
                    change +
                    " so'm in change";
            System.out.println(builder);
            profit += cost;
            moneyReceived = 0.0;
        } else {
        }
    }

    public void displayCards() {
        boolean cardDisplayed = false;
        for (PaymentCard card : paymentCards) {
            if (card == null || card.cardID == null) {
                break;
            }
            System.out.println(card);
            cardDisplayed = true;


        }
        if (!cardDisplayed) {
            System.out.println("No card available right now");
        }
    }

    public double getCredit(String id) {
        double credit = 0.0;
        for (PaymentCard card : paymentCards) {
            if (id.equals(card.cardID)) {
                credit = card.credit;
                return credit;
            }
        }
        return 0;
    }

    public void rechargeCard(String cardId, double credit) {
        boolean cardFound = false;
        for (PaymentCard card : paymentCards) {
            if (card != null && card.cardID != null && card.cardID.equals(cardId)) {
                cardFound = true;
                card.credit += credit;
                System.out.println("Card is recharged with " + credit + " so'm");
                break;  // exit the loop early

            }

        }
        if (!cardFound) {
            System.out.println("No card found with the ID" + cardId + "\nNew card is being added");
            this.addCard(cardId, credit);
        }
    }

    public boolean isCardExists(String cardId) {
        boolean cardFound = false;
        for (PaymentCard card : paymentCards) {
            if (card != null && card.cardID != null && card.cardID.equals(cardId)) {
                cardFound = true;
                break;

            }
        }
        return cardFound;
    }


}
