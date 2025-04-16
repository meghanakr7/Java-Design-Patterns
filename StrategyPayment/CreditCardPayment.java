package StrategyPayment;

public class CreditCardPayment implements StrategyInterface{
    @Override
    public void pay(double amount) {
        System.out.println("Credit card payment "+amount+" done");
    }
}
