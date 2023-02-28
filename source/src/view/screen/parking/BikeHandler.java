package view.screen.parking;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.Utils;
import view.screen.FXMLScreenHandler;
import view.screen.bikeinfor.ViewBikeInforScreenHandler;
import view.screen.home.HomeScreenHandler;
    /**
     * 
     * @author dell
     *
     */
public class BikeHandler extends FXMLScreenHandler {
	
    @FXML
    private ImageView bikeImage;
    @FXML
    private Label lincensePlateLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button viewBtn;
    private Bike bike;
    private ViewParkingScreenHandler viewParkingScreenHandler;
	public static Logger LOGGER = Utils.getLogger(BikeHandler.class.getName());
	/**
	 *  BikeHandler contructor
	 * @param screenPath
	 * @param bike
	 * @param viewParkingScreenHandler
	 * @throws IOException
	 */
	public BikeHandler(String screenPath,Bike bike,ViewParkingScreenHandler viewParkingScreenHandler) throws IOException {
		super(screenPath);
		this.bike=bike;
		this.viewParkingScreenHandler= viewParkingScreenHandler;
		setBikeViewInfor();
		
	}
	/**
	 * set infor for a bike to viewc
	 */
	private void setBikeViewInfor() {
		System.out.println(bike.getImageURL());
		File file = new File(bike.getImageURL());
        Image image = new Image(file.toURI().toString());
        bikeImage.setImage(image);
        lincensePlateLabel.setText(bike.getLinsencePlate());
        if(bike.isStatus()) {
        	statusLabel.setText("READY");
        	statusLabel.setTextFill(Color.GREEN);
        }else {
        	statusLabel.setText("RENTED");
        	statusLabel.setTextFill(Color.RED);
        }
	}

	public Button getViewBtn() {
		return viewBtn;
	}

	public void setViewBtn(Button viewBtn) {
		this.viewBtn = viewBtn;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
}
