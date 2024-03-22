package leetcode.design.cabsharing.ridemanager;

public class Ride {
    private int source;
    private int destination;
    private int availableSeats;
    private String rideStatus;

    public Ride(int source, int destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.availableSeats = this.availableSeats - seats;
        this.rideStatus = "Started";
    }
}
