package view.screen.payment;

import java.io.IOException;
import java.sql.SQLException;

import calculatemethod.FirstCalculateFees;
import controller.RentBikeController;
import controller.ReturnBikeController;
import entity.bike.Bike;
import entity.dock.Dock;
import entity.rental.Rental;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.bikeinfor.BikeHandler;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
      /**
       * this is PaymentScreenHandler
       * @author NhatSang
       * @version 1.0
       */
public class PaymentScreenHandler extends BaseScreenHandler{
	   @FXML
	   private ImageView loadingImage;
	   @FXML
	   private Button btnConfirmPayment;
	   @FXML
	   private Pane bikeDetail;
	   @FXML
	   private ScrollPane frame;
	   
	   
	  /**
	   * set infor for payment screen
	   * @param stage
	   * @param screenPath
	   * @param obj
	   * @throws IOException
	   * @throws SQLException
	   */
      public PaymentScreenHandler(Stage stage, String screenPath,Object obj) throws IOException, SQLException {
		super(stage, screenPath);
    if(obj instanceof Bike) {
    	frame.setVisible(false);
	btnConfirmPayment.setOnMouseClicked(e->{
		try {
		    RentBikeController rentBikeController=new RentBikeController();
	
		    rentBikeController.unlockBike((Bike)obj);
		    Rental.getRental().setBike((Bike)obj);
		    rentBikeController.saveRental();
			ResultScreenHandler resultScreenHandler= new ResultScreenHandler(stage, Configs.RESULT_SCREEN);
			resultScreenHandler.setPreviousScreen(this);
			resultScreenHandler.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
    }else if (obj instanceof Dock){
    	    ReturnBikeController returnBikeController= new ReturnBikeController();
    	    BikeHandler bikeHandler=new BikeHandler(Configs.BIKE_INFOR_SCREEN_DETAIL_PATH, Rental.getRental().getBike());
		    returnBikeController.returnBike(((Dock)obj).getDockId());

    	    Double totalCost=returnBikeController.renBikeFees(new FirstCalculateFees());
    	    Label price=new Label("TOTAL COST  :    " +totalCost);
    	    price.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
    	    price.setTextFill(Color.RED);
    	    Label starTimeLabel=new Label("START TIME :    " +Rental.getRental().getStartTime().toString());
    	    starTimeLabel.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
    	    Label endTimeLabel=new Label("END TIME :    " +Rental.getRental().getEndTime().toString());
    	    endTimeLabel.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
    	    
    	    bikeHandler.getBikeDetailInfor().getChildren().addAll(starTimeLabel,endTimeLabel,price);
    	    bikeDetail.getChildren().addAll(bikeHandler.getContent());
            btnConfirmPayment.setOnMouseClicked(e->{
    	
    	try {
			//returnBikeController.returnBike(((Dock)obj).getDockId());
			returnBikeController.lockBike(totalCost);
			ResultScreenHandler resultScreenHandler= new ResultScreenHandler(stage, Configs.RESULT_SCREEN);
			resultScreenHandler.setPreviousScreen(this);
			resultScreenHandler.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    });
    
    }
	}
    
   	public Button getBtnConfirmPayment() {
		return btnConfirmPayment;
	}
	public void setBtnConfirmPayment(Button btnConfirmPayment) {
		this.btnConfirmPayment = btnConfirmPayment;
	}
	
}
