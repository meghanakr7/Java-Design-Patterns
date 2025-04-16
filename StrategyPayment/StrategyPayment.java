package StrategyPayment;


public class StrategyPayment {
    public static void main(String[] args) {
        System.out.println("Hiiii!!");
        PaymentService service = new PaymentService();
        service.setPaymentStrategy(new CreditCardPayment());
        service.makePayment(50000);

        service.setPaymentStrategy(new PayPalPayment());
        service.makePayment(25000);
    }
    
}
