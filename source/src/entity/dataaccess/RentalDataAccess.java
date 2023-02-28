package entity.dataaccess;

import java.sql.SQLException;
import java.sql.Statement;

import entity.db.CapStoneDB;
import entity.rental.Rental;
       /**
        * this is RentalDataAccess
        * @author NhatSang
        * @version 1.0
        */
public class RentalDataAccess {
       private static RentalDataAccess rentalDataAccess;
       public static RentalDataAccess getRentalDataAccess() {
 	      if(rentalDataAccess==null) {
 	    	 rentalDataAccess= new RentalDataAccess();
 	      }
 	      return rentalDataAccess;
    }  
       /**
        * save Rental into database
        * @param totalCost
        * @throws SQLException
        */
       public void saveCompleteRental(double totalCost) throws SQLException {
    	   String sql="insert into rentals (bikeId,startTime,endTime,totalCost) value ('"+Rental.getRental().getBike().getBikeId()+"','"+Rental.getRental().getStartTime().toString()+"','"+Rental.getRental().getEndTime().toString()+"',"+totalCost+");";
    	   Statement stm = CapStoneDB.getConnection().createStatement();
    	   stm.execute(sql);
    	   
       }
    
}
