package leetcode.design.cabsharing.billingmanager;

public class BikeBilling implements BillingManager {
    private static final double pricePerKm = 26.40;

//    public BikeBilling(double pricePerKm) {
//        this.pricePerKm = pricePerKm;
//    }
    @Override
    public double generateBill(final int source, final int destination, final int seats) {
        return (destination - source) * pricePerKm * seats;
    }
}
