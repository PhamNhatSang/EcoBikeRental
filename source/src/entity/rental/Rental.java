package entity.rental;

import java.time.LocalTime;

import entity.bike.Bike;

    /**
     * this is rental class
     * @author NhatSang
     * @version 1.0
     */
public class Rental {
    
	private Bike bike;
    private LocalTime startTime;
    private LocalTime endTime;
    private double totalCost;
    private static Rental rental;
    public static Rental getRental() {
    	if(rental == null) rental= new Rental();
	    return rental;  
		
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
    
}
