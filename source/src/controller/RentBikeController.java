package controller;


import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import common.exception.InvalidCodeException;
import entity.bike.Bike;
import entity.dataaccess.BikeDataAccess;
import entity.dataaccess.DockDataAccess;
import entity.rental.Rental;
    /**
     * this class is RentBikeController
     * @author NhatSang
     * @version 1.0
     */
public class RentBikeController extends BaseController{
    
	/**
	 * this function use to request to view bike
	 * @param code
	 * @throws InvalidCodeException
	 * @throws SQLException
	 */
	public void viewBike(String code) throws InvalidCodeException, SQLException{
		Bike.checkIsValidCode(code);
	}
	/**
	 * this function convert barcode to bikecode
	 * @param code
	 * @return bikeCode
	 */
	public String convertToBikeCode(String code) {
		return Bike.barcodeToBikeCode(code);
		
	}
	/**
	 * this function process bike infor , check it is rented or not
	 * @param bike
	 * @throws SQLException
	 */
	
	public void processConfirmInfor(Bike bike) throws SQLException {
		bike.checkIsRented();
	}
	
	/**
	 * this function unlock the bike and start renting process
	 * @param bike
	 * @throws SQLException
	 */
	
	public void unlockBike(Bike bike) throws SQLException {
		bike.setStatus(false);
		BikeDataAccess.getBikeDataAccess().updateStatus(bike.getBikeId(), false, bike.getDockId());
	} 
	/**
	 * this function set start time when you rent bike
	 */
	public void saveRental() {
		Rental.getRental().setStartTime(LocalTime.now());
	}
	
	
}
