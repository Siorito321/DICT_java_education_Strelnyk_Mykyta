package CreditCalculator;

public class Operations {
    public void annuity(float i, float n, float p) {
        i = i / 1200;
        double a = p * (i * Math.pow((double)(1 + i), n)) / (Math.pow((double)(1 + i), n) - 1);
        System.out.println("Your annual payment is " + Math.ceil(a) + "!");
    }

    public void number_of_payments(float principal, float payment ) {
        float n_months = principal / payment;
        System.out.println("You need to pay your loan for " + Math.ceil(n_months) + " months");
        if (!(n_months % 1 > 0)) {
            float lastpayment = principal - (n_months - 1) * payment;
            System.out.println("The last payment is " + Math.ceil(lastpayment) + "$");
        }
    }

    public void principal(float i, float n, float a) {
        i = i / 1200;
        double p = a / ( (i * Math.pow((double)(1 + i), (double)n)) / (Math.pow((double)(1 + i), (double)n) - 1));
        System.out.println("Your loan principal is " + Math.ceil(p) + "!");
    }
}
