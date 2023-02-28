package controller;

import java.sql.SQLException;
import java.util.List;

import entity.dataaccess.DockDataAccess;
    /**
     * this is HomeController class
     * @author NhatSang
     * @version 1.0
     */
public class HomeController extends BaseController{
    /**
     * this function get all docks 
     * @return list[Dock]
     * @throws SQLException
     */
	public List getAlldocks() throws SQLException {
		return  DockDataAccess.getDockDataAccess().getListDock(); 
  }
}
