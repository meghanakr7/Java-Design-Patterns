package StrategyPayment;

public class PayPalPayment implements StrategyInterface{
    @Override
    public void pay(double amount) {
        System.out.println("Amount paid through paypal " + amount);
    }
}
