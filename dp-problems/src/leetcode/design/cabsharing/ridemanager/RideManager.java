package leetcode.design.cabsharing.ridemanager;

public interface RideManager {
    public Ride bookRide(int source, int destination, int seats);
    public void updateStatus(String status);

}
