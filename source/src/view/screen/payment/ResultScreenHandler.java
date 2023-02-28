package view.screen.payment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

//import Time.MyTimer;
import Time.TimeControl;
import Time.Timers;
import controller.HomeController;
import controller.RentBikeController;
import controller.ViewParkingController;
import entity.rental.Rental;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.home.HomeScreenHandler;
import view.screen.parking.ViewParkingScreenHandler;
    /**
     * this is resultScreenHandler class
     * @author dell
     * @version 1.0
     */
public class ResultScreenHandler extends BaseScreenHandler {
	@FXML
	private Button okButton;
	/**
	 * set infor result screen
	 * @param stage
	 * @param screenPath
	 * @throws IOException
	 */
	public ResultScreenHandler(Stage stage, String screenPath) throws IOException {
		super(stage,screenPath);
		if(Rental.getRental().getBike()!=null) {
		okButton.setOnMouseClicked(e->{
			try {
			  ViewParkingScreenHandler viewParkingScreenHandler=new ViewParkingScreenHandler(stage, Configs.PARKING_SCREEN_PATH, Rental.getRental().getBike().getDockId());
			  viewParkingScreenHandler.setBController(new ViewParkingController());
		      viewParkingScreenHandler.setHomeScreenHandler(new HomeScreenHandler(stage, Configs.HOME_PATH));
			  Timers timers= new Timers(viewParkingScreenHandler.getTimeValueLabel());
			  Timer realTimer=new Timer();
			  TimeControl.getTimeControl().setTimers(timers);
			  realTimer.scheduleAtFixedRate(timers,0,1000);
			  
				viewParkingScreenHandler.requestToViewPark();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		}else {
			okButton.setOnMouseClicked(e->{
			
			try {
				
				HomeScreenHandler homeScreenHandler = new HomeScreenHandler(stage, Configs.HOME_PATH);
				homeScreenHandler.setBController(new HomeController());
				homeScreenHandler.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			});
		}
		
	}
	public Button getOkButton() {
		return okButton;
	}
	public void setOkButton(Button okButton) {
		this.okButton = okButton;
	}

}
