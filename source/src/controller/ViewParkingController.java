package controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import entity.dataaccess.DockDataAccess;
import entity.dataaccess.StandardBikeDataAccess;
import entity.dataaccess.StandardEBikeDataAccess;
import entity.dataaccess.TwinBikeDataAccess;
     /**
      * this is ViewParkingController class
      * @author NhatSang
      * @version 1.0
      */
public class ViewParkingController extends BaseController {
      /**
       * this function allow us to get all bike of a dock
       * @param dockId
       * @return list[Dock]
       * @throws SQLException
       */
    public List getAllBike(String dockId) throws SQLException {

           return DockDataAccess.getDockDataAccess().getAllBikeInDock(dockId);
    }
    
}
