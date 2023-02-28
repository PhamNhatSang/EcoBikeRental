package view.screen.bikeinfor;

import java.awt.Font;
import java.io.IOException;

import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.FontWeight;
import utils.Configs;
import view.screen.FXMLScreenHandler;
import view.screen.parking.ViewParkingScreenHandler;
    /**
     * this is BikeHandler class
     * @author NhatSang
     * @version 1.0
     */
public class BikeHandler extends FXMLScreenHandler {
	@FXML
    private ImageView bikeImage;
    @FXML
    private VBox bikeDetailInfor;
        /**
         * set infor for bike to confirm
         * @param screenPath
         * @param bike
         * @throws IOException
         */
	public BikeHandler(String screenPath,Bike bike) throws IOException {
		super(screenPath);
		bikeDetailInfor.setSpacing(10);
		

		 setImage(bikeImage, bike.getImageURL());
		 Label barCodelabel =new Label("BARCODE  :    "+bike.getBarCode());
		 barCodelabel.setFont(javafx.scene.text.Font.font(Configs.STYLE,Configs.WEIGHT, 24));
		 Label rentalCodelabel=new Label("RENTAL CODE  :   "+bike.getRentalCode());
		 rentalCodelabel.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		 Label linsencePlatelabel=new Label("LINSENCE PLATE   :    "+bike.getLinsencePlate());
		 linsencePlatelabel.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		 Label type=new Label("TYPE   :   "+bike.getType());
		 type.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		
		 HBox hBox=new HBox();
         
		 if(bike.isStatus()==true) {
		 
		     Label status=new Label("STATUS   :   ");
		     status.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		     hBox.getChildren().add(status);
		     Label realStatus=new Label("READY");
		     realStatus.setTextFill(Color.GREEN);
		     realStatus.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
		     hBox.getChildren().add(realStatus);
		 }else{
			 Label status=new Label("STATUS   :   ");
			 status.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			 hBox.getChildren().add(status);
			 Label realStatus=new Label("RENTED");
			 realStatus.setTextFill(Color.RED);
			 realStatus.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			 hBox.getChildren().add(realStatus);
		 }
		 
		if(bike instanceof StandardEBike) {
			Label price=new Label("PRICE  :    " +((StandardEBike) bike).getPrice());
			price.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			Label  hourlyRate=new Label("HOURLY RATE   :   "+((StandardEBike) bike).getHourlyRate()+" Giờ");
			hourlyRate.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			Label batteryPercentage=new Label("BATTERRY PERCENTAGE   :  "+((StandardEBike) bike).getBatteryPercentage()+" %");
			batteryPercentage.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			bikeDetailInfor.getChildren().addAll(barCodelabel,rentalCodelabel,linsencePlatelabel,type,hBox,price,hourlyRate,batteryPercentage);
			
		}else if(bike instanceof StandardBike) {
			Label price=new Label("PRICE  :    " +((StandardBike) bike).getPrice());
			price.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			bikeDetailInfor.getChildren().addAll(barCodelabel,rentalCodelabel,linsencePlatelabel,type,hBox,price);
			
		}else if(bike instanceof TwinBike){
			Label price=new Label("PRICE  :    " +((TwinBike) bike).getPrice());
			price.setFont(javafx.scene.text.Font.font(Configs.STYLE, Configs.WEIGHT, 24));
			bikeDetailInfor.getChildren().addAll(barCodelabel,rentalCodelabel,linsencePlatelabel,type,hBox,price);
			
		}else {
			bikeDetailInfor.getChildren().addAll(barCodelabel,rentalCodelabel,linsencePlatelabel,type,hBox);
		}
	}
	public VBox getBikeDetailInfor() {
		return bikeDetailInfor;
	}
	public void setBikeDetailInfor(VBox bikeDetailInfor) {
		this.bikeDetailInfor = bikeDetailInfor;
	}
	
	
}
