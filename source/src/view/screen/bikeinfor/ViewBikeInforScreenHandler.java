package view.screen.bikeinfor;
import java.io.IOException;
import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
    /**
     * this is ViewBikeInforScreenHandler class
     * @author NhatSang
     * @version 1.0
     */
public class ViewBikeInforScreenHandler extends BaseScreenHandler {
    
    @FXML
    private Button backBtn;
    @FXML
    private AnchorPane bikeInfor;
    /**
     * set detail infor for a bike
     * @param stage
     * @param screenPath
     * @param bike
     * @throws IOException
     */
	public ViewBikeInforScreenHandler(Stage stage, String screenPath,Bike bike) throws IOException {
		super(stage, screenPath);
		
		backBtn.setOnMouseClicked(e->{
			getPreviousScreen().setScreenTitle("parking screen");
			getPreviousScreen().show();
		});
		bikeInfor.getChildren().addAll(new BikeHandler(Configs.BIKE_INFOR_SCREEN_DETAIL_PATH, bike).getContent());
	}

}
