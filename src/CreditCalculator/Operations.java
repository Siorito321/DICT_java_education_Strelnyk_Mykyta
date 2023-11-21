package CreditCalculator;

public class Operations {
    public void annuity(float i, float n, float p) {
        i = i / 1200;
        double a = p * (i * Math.pow((double)(1 + i), n)) / (Math.pow((double)(1 + i), n) - 1);
        System.out.println("Your annual payment is " + Math.ceil(a) + "!");
    }

    public void number_of_payments(float principal, float monthly_payment, float interest) {
        interest = interest / 1200;
        double n_months = Math.log(monthly_payment / (monthly_payment - (interest * principal))) / Math.log(1 + interest);
        if (n_months < 12) {
            System.out.println("You need to pay your loan for " + Math.ceil(n_months) + " months");
        } else {
            System.out.println("You need to pay your loan for " + Math.floor(n_months / 12)
                    + " years and " + (Math.ceil(n_months % 12)) + " months");
        }
    }

    public void principal(float i, float n, float a) {
        i = i / 1200;
        double p = a / ( (i * Math.pow((double)(1 + i), (double)n)) / (Math.pow((double)(1 + i), (double)n) - 1));
        System.out.println("Your loan principal is " + Math.ceil(p) + "!");
    }
}
