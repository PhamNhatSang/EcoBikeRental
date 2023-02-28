package entity.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.bike.TwinBike;
import entity.db.CapStoneDB;
    /**
     * this is TwinBikeDataAccess class
     * @author NhatSang
     * @version 1.0
     */
public class TwinBikeDataAccess {
	private static TwinBikeDataAccess twinBikeDataAccess;
    public static TwinBikeDataAccess getTwinBikeDataAccess() {
 	   if(twinBikeDataAccess==null) {
 		  twinBikeDataAccess= new TwinBikeDataAccess();
 	   }
 	   return twinBikeDataAccess;
    }
    /**
     * get list Twinbike in dock
     * @param dockId
     * @return list[TwinBike]
     * @throws SQLException
     */
    public List getListTwinBikeInDock(String dockId) throws SQLException {
    	String sql="Select * from twinbikes,bikes where twinbikes.bikeId=bikes.bikeId   and dockId='"+dockId+"'";
		Statement stm = CapStoneDB.getConnection().createStatement();
		ResultSet res = stm.executeQuery(sql);
		List listtwinbike=new ArrayList<>();
	
			while(res.next()) {
				String barCode=res.getString("barCode");
		    	String rentalCode=res.getString("rentalCode");
		    	String linsencePlate=res.getString("linsencePlate");
		    	boolean status=res.getBoolean("status");
		    	String type=res.getString("type");
		    	String bikeId=res.getString("bikeId");
		    	double price=res.getDouble("price");
		    TwinBike twinBike=new TwinBike(barCode,rentalCode, linsencePlate,bikeId, status,type,price,dockId);
		    twinBike.setImageURL(res.getString("imageURL"));
		    listtwinbike.add(twinBike);
		    
			}
		return listtwinbike;	
    }
}
