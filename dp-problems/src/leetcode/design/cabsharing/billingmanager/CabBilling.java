package leetcode.design.cabsharing.billingmanager;

public class CabBilling implements BillingManager {
    private static final double pricePerKm = 30.00;
    @Override
    public double generateBill(final int source, final int destination, final int seats) {
        return (destination - source) * pricePerKm * seats;
    }
}
