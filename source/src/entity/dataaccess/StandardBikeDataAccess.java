package entity.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.bike.StandardBike;
import entity.db.CapStoneDB;
     /**
      * this is StandardBikeDataAccess
      * @author NhatSang
      * @version 1.0
      */
public class StandardBikeDataAccess {
	private static StandardBikeDataAccess standardBikeDataAccess;
	  
    public static StandardBikeDataAccess getBikeDataAccess() {
 	   if(standardBikeDataAccess==null) {
 		  standardBikeDataAccess= new StandardBikeDataAccess();
 	   }
 	   return standardBikeDataAccess;
    } 
      /**
       * get list standardBike in dokc
       * @param dockId
       * @return list[StandardBike]
       * @throws SQLException
       */
    public List getListBikeInDock(String dockId) throws SQLException {
    	String sql="Select * from capstoneproject.standardbikes, capstoneproject.bikes where standardbikes.bikeId=bikes.bikeId   and dockId='"+dockId+"'";
    	Statement stm = CapStoneDB.getConnection().createStatement();
    	ResultSet res = stm.executeQuery(sql);
    	List liststandardbike=new ArrayList<>();
    		while(res.next()){
    			String barCode=res.getString("barCode");
    	    	String rentalCode=res.getString("rentalCode");
    	    	String linsencePlate=res.getString("linsencePlate");
    	    	boolean status=res.getBoolean("status");
    	    	String type=res.getString("type");
    	    	String bikeId=res.getString("bikeId");
    	    	double price=res.getDouble("price");
    	    StandardBike standardBike=new StandardBike(barCode,rentalCode, linsencePlate,bikeId, status,type,price,dockId);
    	    standardBike.setImageURL(res.getString("imageURL"));
    	        liststandardbike.add(standardBike);
    		}
    	return liststandardbike;
    }
    
    
}
