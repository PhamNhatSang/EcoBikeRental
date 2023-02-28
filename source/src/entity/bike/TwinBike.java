package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.db.CapStoneDB;
    /**
     * this is TwinBike class
     * @author NhatSang
     * @version 1.0
     */
public class TwinBike extends Bike{
    

	/**
	 * TwinBike constructor
	 * @param barCode
	 * @param rentalCode
	 * @param linsencePlate
	 * @param bikeId
	 * @param status
	 * @param type
	 * @param price
	 * @param dockId
	 */
	public TwinBike(String barCode, String rentalCode, String linsencePlate, String bikeId, boolean status,
			String type,Double price,String dockId) {
		super(barCode, rentalCode, linsencePlate, bikeId, status, type,price,dockId);
	}
	public TwinBike() {
		super();
	}
	
}
