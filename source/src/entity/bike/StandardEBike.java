package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.db.CapStoneDB;
    /**
     * this is StandardEBike class
     * @author NhatSang
     * @version 1.0
     */
public class StandardEBike extends Bike{


	
    private int hourlyRate;
    private int batteryPercentage;
    /**
     * StandardEBike constructor
     * @param barCode
     * @param rentalCode
     * @param linsencePlate
     * @param bikeId
     * @param status
     * @param type
     * @param price
     * @param hourlyRate
     * @param batteryPercentage
     * @param dockId
     */
    public StandardEBike(String barCode, String rentalCode, String linsencePlate, String bikeId, boolean status,
			String type,double price,int hourlyRate,int batteryPercentage,String dockId) {
		super(barCode, rentalCode, linsencePlate, bikeId, status, type,price,dockId);
	   
	    this.hourlyRate=hourlyRate;
	    this.batteryPercentage=batteryPercentage;
	}
	public StandardEBike() {
		super();
	}
	
	public int getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	
	
}
