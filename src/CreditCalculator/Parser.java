package CreditCalculator;
import java.util.Hashtable;
import java.util.Objects;
public class Parser {
    public void consoleParser(String[] args) {
        System.out.println("Usage: java CreditCalculator -type=<type> -principal=<principal> -payment=<payment> -periods=<periods> -interest=<interest>");
        int n_of_params = args.length;
        Hashtable<String, String> key_value = new Hashtable<>();
        for (int i = 0; i < n_of_params; i++) {
            String[] keyValueArray = args[i].split("=");
            key_value.put(keyValueArray[0], keyValueArray[1]);
        }
       Operations operations = new Operations();
        String payment = key_value.get("-payment");
        String principal = key_value.get("-principal");
        String periods = key_value.get("-periods");
        String interest = key_value.get("-interest");

        if (key_value.containsKey("-type")) {
            System.out.println("Incorrect parameters!");
            System.exit(1);
        } else if (Objects.equals(key_value.get("-type"), "diff") && !(key_value.containsKey("-payment"))) {
            System.out.println("Incorrect parameters!");
            System.exit(1);
        } else if (!(key_value.containsKey("-interest"))){
            System.out.println("Incorrect parameters!");
            System.exit(1);
        }
        try {
            switch (key_value.get("-type")) {
                case "diff":
                    if (interest != null && periods != null && principal != null) {
                        operations.differentialPayment(Float.parseFloat(interest), Float.parseFloat(periods), Float.parseFloat(principal));
                    } else {
                        System.out.println("Incorrect parameters");
                    }
                    break;
                case "annuity":
                    if (payment == null && periods != null && principal != null && interest != null) {
                        operations.annuity(Float.parseFloat(interest), Float.parseFloat(periods), Float.parseFloat(principal));
                    }
                    if (principal == null && interest != null && periods != null && payment != null) {
                        operations.principal(Float.parseFloat(interest), Float.parseFloat(periods), Float.parseFloat(payment));
                    }
                    if (interest != null && payment != null && principal != null) {
                        operations.number_of_payments(Float.parseFloat(principal), Float.parseFloat(payment), Float.parseFloat(interest));
                    } else {
                        System.out.println("Incorrect parameters");
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Parameters should be numbers!");
        }
    }
}

