package view.screen.bikeconfirm;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Logger;

import Time.TimeControl;
import common.exception.InvalidCodeException;
import controller.PaymentController;
import controller.RentBikeController;
import entity.bike.Bike;
import entity.rental.Rental;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import view.screen.BaseScreenHandler;
import view.screen.bikeinfor.BikeHandler;
import view.screen.parking.ViewParkingScreenHandler;
import view.screen.payment.PaymentScreenHandler;
import view.screen.popup.PopupScreen;
    /**
     * this is ViewBikeConfirmScreenHandler class
     * @author NhatSang
     * @version 1.0
     */
public class ViewBikeConfirmScreenHandler extends BaseScreenHandler{
	public static Logger LOGGER = Utils.getLogger(ViewBikeConfirmScreenHandler.class.getName());
	@FXML
    private Button backBtn;
    @FXML
    private AnchorPane bikeInfor;
    @FXML
    private Button confirmBtn;
    /**
     * set up infor for ViewBikeConfirmScreen
     * @param stage
     * @param bike
     * @param screenPath
     * @throws IOException
     */
	public ViewBikeConfirmScreenHandler(Stage stage,Bike bike, String screenPath) throws IOException {
		super(stage, screenPath);
	
		backBtn.setOnMouseClicked(e->{
			getPreviousScreen().setScreenTitle("parking screen");
		    getPreviousScreen().show();
		});
		
		BikeHandler bikeHandler=new BikeHandler(Configs.BIKE_INFOR_SCREEN_DETAIL_PATH, bike);
		Label depositLabel=new Label("DEPOSIT   :    "+bike.depositFee());
		depositLabel.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		depositLabel.setTextFill(Color.RED);
		bikeHandler.getBikeDetailInfor().getChildren().addAll(depositLabel);
		bikeInfor.getChildren().addAll(bikeHandler.getContent());
		confirmBtn.setOnMouseClicked(e->{
			try {
			
				 ((RentBikeController) getBController()).processConfirmInfor(bike);
				// ((RentBikeController) getBController()).unlockBike();
			try {
				PaymentScreenHandler paymentScreenHandler=new PaymentScreenHandler(stage,Configs.PAYMENT_SCREEN,bike);
				paymentScreenHandler.setBController(new PaymentController());
				paymentScreenHandler.setPreviousScreen(getPreviousScreen());
				paymentScreenHandler.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}catch (InvalidCodeException ex) {
				ex.printStackTrace();
				try {
					PopupScreen.error("Bike is rented choose another");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		});
	
}
}
