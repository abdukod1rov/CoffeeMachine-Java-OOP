
public class PaymentCard {
    String cardID;
    double credit;

    public PaymentCard(String cardID, double credit) {
        this.cardID = cardID;
        this.credit = credit;
    }

    public PaymentCard(){

    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "cardID='" + cardID + '\'' +
                ", credit=" + credit +
                '}';
    }
}



