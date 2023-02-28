package view.screen.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;


import controller.HomeController;

import controller.ViewParkingController;
import entity.dataaccess.DockDataAccess;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import view.screen.BaseScreenHandler;
import view.screen.home.HomeScreenHandler;
import view.screen.parking.ViewParkingScreenHandler;
import view.screen.popup.PopupScreen;

    /**
     * this is HomeScreenHandler class
     * @author NhatSang
     * @version 1.0
     */
public class HomeScreenHandler extends BaseScreenHandler implements Initializable{
	public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());
	@FXML
	private ImageView img_park1;
	
	@FXML
	private ImageView img_park2;
	
	@FXML
	private ImageView img_park3;
	
	@FXML
	private Label name1;
	
	@FXML
	private Label name2;
	
	@FXML
	private Label name3;
	
	@FXML
	private Label address1;
	
	@FXML
	private Label address2;
	
	@FXML
	private Label address3;
	
	@FXML
	private Button viewpark1;
	
	@FXML
	private Button viewpark2;
	
	@FXML
	private Button viewpark3;
	private List listdocks;
    /**
     * initialize home screen
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setBController(new HomeController());
		
		try {
	   
		this.listdocks=DockDataAccess.getDockDataAccess().getListDock();
		}catch (SQLException e) {
	       e.printStackTrace();
		}catch (Exception e) {
		   e.printStackTrace();
		}
		setImagePark();
		setTextLabel();
        viewpark1.setOnMouseClicked(e->{	
        	ViewParkingScreenHandler parkingScreen;
        	 try {
                 LOGGER.info("User clicked to view parking");
                 
                 parkingScreen = new ViewParkingScreenHandler(this.stage, Configs.PARKING_SCREEN_PATH,((Dock)listdocks.get(0)).getDockId());
                 parkingScreen.setHomeScreenHandler(this);
                 parkingScreen.setBController(new ViewParkingController());
                 parkingScreen.setPreviousScreen(this);
               
                 parkingScreen.requestToViewPark();
             } catch (Exception ex) {
            ex.printStackTrace();
             }
        });
        viewpark2.setOnMouseClicked(e->{
        	ViewParkingScreenHandler parkingScreen;
        	 try {
                 LOGGER.info("User clicked to view parking");
                 parkingScreen = new ViewParkingScreenHandler(this.stage, Configs.PARKING_SCREEN_PATH,((Dock)listdocks.get(1)).getDockId());
                 parkingScreen.setHomeScreenHandler(this);
                 parkingScreen.setBController(new ViewParkingController());
               
                 parkingScreen.requestToViewPark();
                // cartScreen.requestToViewCart(this);
             } catch (Exception ex) {
            ex.printStackTrace();
                // throw new ViewCartException(Arrays.toString(e1.getStackTrace()).replaceAll(", ", "\n"));
             }
        });
        viewpark3.setOnMouseClicked(e->{
        	ViewParkingScreenHandler parkingScreen;
        	 try {
                 LOGGER.info("User clicked to view parking");
                 parkingScreen = new ViewParkingScreenHandler(this.stage, Configs.PARKING_SCREEN_PATH,((Dock)listdocks.get(2)).getDockId());
                 parkingScreen.setHomeScreenHandler(this);
                 parkingScreen.setBController(new ViewParkingController());
                 
                 parkingScreen.requestToViewPark();
                // cartScreen.requestToViewCart(this);
             } catch (Exception ex) {
            ex.printStackTrace();
                // throw new ViewCartException(Arrays.toString(e1.getStackTrace()).replaceAll(", ", "\n"));
             }
        });
        
        
	}
	/**
	 * set image for park
	 */
	private void setImagePark() {
		
		File file1 = new File(((Dock)(listdocks.get(0))).getImageURL());
        Image img1 = new Image(file1.toURI().toString());
        img_park1.setImage(img1);
        
        File file2 = new File(((Dock)(listdocks.get(1))).getImageURL());
        Image img2 = new Image(file2.toURI().toString());
        img_park2.setImage(img2);
        
        File file3 = new File(((Dock)(listdocks.get(2))).getImageURL());
        Image img3 = new Image(file3.toURI().toString());
        img_park3.setImage(img3);
        
		
	}
	/**
	 * set name and address for a dock
	 */
	private void setTextLabel() {
		name1.setText(((Dock)(listdocks.get(0))).getName());
		name2.setText(((Dock)(listdocks.get(1))).getName());
		name3.setText(((Dock)(listdocks.get(2))).getName());
		address1.setText(((Dock)(listdocks.get(0))).getAddress());
		address2.setText(((Dock)(listdocks.get(1))).getAddress());
		address3.setText(((Dock)(listdocks.get(2))).getAddress());
		
	}
   
	public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		
	}
	
}
