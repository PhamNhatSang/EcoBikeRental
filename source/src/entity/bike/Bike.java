package entity.bike;

import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.exception.InvalidCodeException;
import entity.dataaccess.BikeDataAccess;
import entity.db.CapStoneDB;
import entity.dock.Dock;



    /**
     * this is bike class
     * @author NhatSang
     * @version 1.0
     */
public class Bike {
	protected String barCode;
	protected String rentalCode;
	protected String linsencePlate;
	protected String bikeId;
	protected String dockId;
	protected boolean status;
	protected Statement stm;
	protected String type;
	protected String imageURL;
	protected double price;
    public Bike(){
    }
    /**
     * this is bike constructor
     * @param barCode
     * @param rentalCode
     * @param linsencePlate
     * @param bikeId
     * @param status
     * @param type
     * @param price
     * @param dockId
     */
    public Bike(String barCode, String rentalCode, String linsencePlate, String bikeId, boolean status, String type,double price,String dockId) {
		this.barCode = barCode;
		this.rentalCode = rentalCode;
		this.linsencePlate = linsencePlate;
		this.bikeId = bikeId;
		this.status = status;
		this.type = type;
		this.dockId=dockId;
		this.price=price;
	} 
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getLinsencePlate() {
		return linsencePlate;
	}
	public void setLinsencePlate(String linsencePlate) {
		this.linsencePlate = linsencePlate;
	}
	public String getBikeId() {
		return bikeId;
	}
	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageURL(){
		return imageURL;
	}
	public void setImageURL(String imageURL){
		this.imageURL = imageURL;
	}
	public String getDockId() {
		return dockId;
	}
	public void setDockId(String dockId) {
		this.dockId = dockId;
		
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double depositFee() {
		return price*40/100;
	}
	 /**
	  * this function check valid code
	  * @param barCode
	  * @throws SQLException
	  * @throw InvalidCodeException
	  */
	public static void checkIsValidCode(String barCode) throws SQLException {
		boolean condition=false;
		List listbike=new ArrayList<>();
		
			listbike=BikeDataAccess.getBikeDataAccess().getListBike();
			for(Object bike:listbike) {
				Bike bikeItem=(Bike) bike;
				if(bikeItem.getBarCode().equals(barCode)) {
					condition=true;
					return;
				}
			}
		
		if(condition==false) {
			throw new InvalidCodeException("INVALID CODE");
		}
		
	}
	  
	  /**
	   * this function get bikeCode from barCode
	   * @param barCode
	   * @return bikeCode
	   */
	public static String barcodeToBikeCode(String barCode) {
    List listbike;
	try {
		listbike =BikeDataAccess.getBikeDataAccess().getListBike();
		for(Object bike:listbike) {
			Bike bikeItem=(Bike) bike;
			System.out.println(bikeItem.getBikeId());
			if(bikeItem.getBarCode().equals(barCode)) {
				return bikeItem.getBikeId();	
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	   /**
	    * this function check if that bike is rented
	    * @throws SQLException
	    * @throw InvalidCodeException
	    */
	public  void checkIsRented() throws SQLException {
		boolean condition=false;
		List listbike=new ArrayList<>();
		
			listbike=BikeDataAccess.getBikeDataAccess().getListBike();
			for(Object bike:listbike) {
				Bike bikeItem=(Bike) bike;
				if(bikeItem.getBikeId().equals(this.bikeId)) {
					if(bikeItem.isStatus()) {
					condition=true;
					return;
					}
				}
			}
		
		if(condition==false) {
			throw new InvalidCodeException("INVALID CODE");
		}
	}
	
	
    
}
