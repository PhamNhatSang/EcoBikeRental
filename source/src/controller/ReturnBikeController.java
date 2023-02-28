package controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Time.TimeControl;
import calculatemethod.CalculateFees;
import calculatemethod.CalculateMethod;
import entity.dataaccess.BikeDataAccess;
import entity.dataaccess.RentalDataAccess;
import entity.rental.Rental;
import utils.Utils;
      /**
       * this class is ReturnBikeController
       * @author NhatSang
       * @version 1.0
       */
public class ReturnBikeController extends BaseController {
      /**
       * this function calculate the rent bike fees with the calculate method that you choose
       * @param calculateFees
       * @return fees
       */
	
	  public double renBikeFees(CalculateFees calculateFees) {
		  CalculateMethod calculateMethod=new CalculateMethod(calculateFees);
		  return calculateMethod.Calculate();
	  }
	  /**
	   * this function stop the renting and return  the bike to the dock have dockId 
	   * @param dockId
	   * @throws SQLException
	   */
	  public void returnBike(String dockId) throws SQLException {
		     TimeControl.getTimeControl().getTimers().cancel();
		     Rental.getRental().setEndTime(Utils.plusTime(LocalTime.parse(TimeControl.getTimeControl().getTimers().getTimeLabel().getText(),DateTimeFormatter.ofPattern("HH:mm:ss")),Rental.getRental().getStartTime()));
		     Rental.getRental().getBike().setStatus(true);
			 Rental.getRental().getBike().setDockId(dockId);
	 	     BikeDataAccess.getBikeDataAccess().updateStatus(Rental.getRental().getBike().getBikeId(), true,dockId );
	   
 
      }
	  /**
	    * this function lock that bike you rent and save the rental
	    * @param totalCost
	    * @throws SQLException     
	    */
	  public void lockBike(double totalCost) throws SQLException {
		  TimeControl.getTimeControl().setTimers(null);
		    RentalDataAccess.getRentalDataAccess().saveCompleteRental(totalCost);
		    Rental.getRental().setBike(null);
	  }
	  
}
