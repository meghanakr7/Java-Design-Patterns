package StrategyPayment;

public class PaymentService {
    private StrategyInterface strategy;
    void setPaymentStrategy(StrategyInterface strategy) {
        this.strategy = strategy;
    }
    void makePayment(double amount) {
        this.strategy.pay(amount);
    }
}
