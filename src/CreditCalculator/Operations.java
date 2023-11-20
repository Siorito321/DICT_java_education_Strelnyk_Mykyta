package CreditCalculator;

public class Operations {
    public float payments(float months, float principal) {
        return (float) Math.ceil(principal / months);
    }

    public void number_of_payments(float principal, float payment ) {
        float n_months = principal / payment;
        System.out.println("You need to pay your loan for " + Math.ceil(n_months) + " months");
        if (!(n_months % 1 > 0)) {
            float lastpayment = principal - (n_months - 1) * payment;
            System.out.println("The last payment is " + lastpayment + "$");
        }
    }
}
