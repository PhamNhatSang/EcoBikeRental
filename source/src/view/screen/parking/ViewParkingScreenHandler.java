package view.screen.parking;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

//import Time.MyTimer;
import Time.TimeControl;
import controller.RentBikeController;
import controller.ReturnBikeController;
import controller.ViewParkingController;
import entity.bike.Bike;
import entity.dataaccess.DockDataAccess;
import entity.dock.Dock;
import entity.rental.Rental;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Configs;
import utils.Utils;
import view.screen.home.HomeScreenHandler;
import view.screen.popup.PopupScreen;
import view.screen.BaseScreenHandler;
import view.screen.bikeconfirm.ViewBikeConfirmScreenHandler;
import view.screen.bikeinfor.ViewBikeInforScreenHandler;
import view.screen.choosedock.ChooseDockScreenHandler;
    /**
     * this is ViewParkingScreenHandler
     * @author NhatSang
     * @version 1.0
     */
public class ViewParkingScreenHandler extends BaseScreenHandler {
	public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());
	@FXML
	private ImageView bikeLogo;
	@FXML
	private Button rentBike;
	@FXML
	private Button returnBike;
	@FXML
	private HBox hboxBike;
	@FXML
	private Label timeLabel;
	public Label getTimeValueLabel() {
		return timeValueLabel;
	}


	public void setTimeValueLabel(Label timeValueLabel) {
		this.timeValueLabel = timeValueLabel;
	}
	@FXML
	private Label timeValueLabel;
	@FXML
	private AnchorPane bikeRentInfor;
	@FXML
	private Label availableBike;
	@FXML
	private Label numberOfDokcingPoints;
	
	
	
	//private List listbike;

	private String dockId;
	/**
	 * ViewParkingScreenHandler constructor
	 * @param stage
	 * @param screenPath
	 * @param dockId
	 * @throws IOException
	 * @throws SQLException
	 */
	public ViewParkingScreenHandler(Stage stage, String screenPath,String dockId) throws IOException, SQLException {
		super(stage, screenPath);
		bikeLogo.setCursor(Cursor.HAND);
        bikeLogo.setOnMouseClicked(e->{
        	homeScreenHandler.setScreenTitle("Home Screen");
            homeScreenHandler.show();
         });
        this.dockId=dockId;
       // setRentBikeAction();
        setAvaiableBikeAndDockingPoint();
        if(Rental.getRental().getBike() !=null) {
        timeLabel.setText("TIME:");	
        returnBike.setOnMouseClicked(e->{
        		try {
					ChooseDockScreenHandler chooseDockScreenHandler= new ChooseDockScreenHandler(stage,Configs.CHOOSE_DOCK);
					chooseDockScreenHandler.setBController(new ReturnBikeController());
					chooseDockScreenHandler.setPreviousScreen(this);
					chooseDockScreenHandler.show();
					
				}catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	});
        
        rentBike.setOnMouseClicked(e->{
        	try {
				PopupScreen.error("Please return bike to rent a new bike");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	});
        setBikeRentInfor();
        
        }else {
        	requestToRentBike();
        returnBike.setOnMouseClicked(e->{
        	try {
				PopupScreen.error("Please rent bike to return bike");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	});	
        }
}
	
	    /**
	     * add list bike to dock
	     * @param items
	     */
	private void addBikeToDock(List items) {
		ArrayList bikeItems = (ArrayList)((ArrayList) items).clone();
        hboxBike.getChildren().forEach(node -> {
        	AnchorPane aPane = (AnchorPane) node;
            aPane.getChildren().clear();
        });
        while(!bikeItems.isEmpty()){
        	BikeHandler bikeHandler = (BikeHandler) bikeItems.get(0);
        	
        	bikeHandler.getViewBtn().setOnMouseClicked(e->{
        		try {
					ViewBikeInforScreenHandler viewBikeInforScreenHandler =new ViewBikeInforScreenHandler(stage, Configs.BIKE_INFOR_SCREEN_PATH, bikeHandler.getBike());
					viewBikeInforScreenHandler.setPreviousScreen(this);
					viewBikeInforScreenHandler.setBController(getBController());
					viewBikeInforScreenHandler.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	});
        	bikeItems.remove(bikeHandler);
           hboxBike.getChildren().add(bikeHandler.getContent());
        }
	}
	public ViewParkingController getBController() {
		return (ViewParkingController) super.getBController();
	}
	    /**
	     * request to view park
	     * @throws IOException
	     * @throws SQLException
	     */
	public void requestToViewPark() throws IOException, SQLException {
		if (TimeControl.getTimeControl().getTimers()!=null) {
			TimeControl.getTimeControl().getTimers().setTimeLabel(timeValueLabel);
		}
		     hboxBike.getChildren().clear();
		     List listbike= new ArrayList<>();      
        	 List allBike = getBController().getAllBike(dockId);
             System.out.println(allBike.size());
			 for(Object obj:allBike) {
				 Bike bike=(Bike) obj;
				 
				 BikeHandler bikeHandler=new BikeHandler(Configs.VIEW_BIKE_INFOR_PATH, bike, this);
				 listbike.add(bikeHandler);
			 }
        addBikeToDock(listbike);
        setScreenTitle("Parking screen");
        show();
	}
	    /**
	     * get bike infor
	     * @param bikeId
	     * @return
	     */
	public Bike getBikeInfor(String bikeId) {
		try {
			List allBike = getBController().getAllBike(dockId);
			 for(Object obj:allBike) {
				 Bike bike=(Bike) obj;
				 if(bike.getBikeId().equals(bikeId)) {
					 return bike;
				 }
			 }
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	    /**
	     * request to rent bike
	     */
	public void requestToRentBike() {
		rentBike.setOnMouseClicked(e->{
			if(Rental.getRental().getBike()==null){
        	TextInputDialog dialog = new TextInputDialog();
		    dialog.setTitle("Input BarCode");
		    dialog.setHeaderText("Enter BarCode:");
		    dialog.setContentText("BarCode: ");
		    Optional<String> result = dialog.showAndWait();
		    if (result.isPresent()) {
		    	String barCodeInPut=result.get();
		    	RentBikeController rentBikeController=new RentBikeController();
		    	try {
		    		rentBikeController.viewBike(barCodeInPut);
		    		String bikeId=rentBikeController.convertToBikeCode(barCodeInPut);
			    	Rental.getRental().setBike(getBikeInfor(bikeId));
			    	if(Rental.getRental().getBike()==null) {
			    		try {
							PopupScreen.error("Bike is not in this dock");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    	}else {
			    	try {
						ViewBikeConfirmScreenHandler viewBikeConfirmScreenHandler=new ViewBikeConfirmScreenHandler(stage,Rental.getRental().getBike() , Configs.BIKE_INFOR_SCREEN_CONFIRM_PATH);
						viewBikeConfirmScreenHandler.setPreviousScreen(this);
						viewBikeConfirmScreenHandler.setBController(rentBikeController);
						viewBikeConfirmScreenHandler.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	}
				} catch (Exception InvalidCodeException) {
					try {
						PopupScreen.error("Invalid Code");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
		    }
		    
        	
			}else {
				try {
					PopupScreen.error("You must return bike to rent a new bike");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        }); 
	}
	
	
	public void setBikeRentInfor(AnchorPane bikeRentInfor) {
		this.bikeRentInfor = bikeRentInfor;
	}
	
	public void setBikeRentInfor() {
		 try {
			BikeHandler bikeHandler=new BikeHandler(Configs.VIEW_BIKE_INFOR_PATH, Rental.getRental().getBike(), this);
			bikeHandler.getViewBtn().setOnMouseClicked(e->{
        		try {
					ViewBikeInforScreenHandler viewBikeInforScreenHandler =new ViewBikeInforScreenHandler(stage, Configs.BIKE_INFOR_SCREEN_PATH, bikeHandler.getBike());
					viewBikeInforScreenHandler.setPreviousScreen(this);
					viewBikeInforScreenHandler.setBController(getBController());
					viewBikeInforScreenHandler.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	});
			bikeRentInfor.getChildren().addAll(bikeHandler.getContent());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void setAvaiableBikeAndDockingPoint() throws SQLException {
			Dock dock=DockDataAccess.getDockDataAccess().getDockById(dockId);
			numberOfDokcingPoints.setText(""+dock.getNumber_of_docking_points());
			availableBike.setText(""+dock.getNumber_of_available_bikes());
	}
}
