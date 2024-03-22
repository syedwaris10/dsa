package leetcode.design.cabsharing.ridemanager;

public class CabRide implements RideManager {

    @Override
    public Ride bookRide(final int source, final int destination, final int seats) {
        return new Ride(source, destination, seats);
    }

    @Override
    public void updateStatus(String status) {
        //ride.setStatus
    }
}
