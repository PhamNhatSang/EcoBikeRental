package view.screen.choosedock;

import javafx.scene.control.Label;
import java.io.IOException;

import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.screen.FXMLScreenHandler;
    /**
     * this is DokcHandler class
     * @author NhatSang
     * @version 1.0
     */ 
public class DockHandler extends FXMLScreenHandler{
    @FXML
    private Label dockNameLabel;
    
    @FXML
    private ImageView dockImage;
    
    @FXML
    private Label avaiableBikesLabel;
    @FXML
    private Label dockingPointLabel;
    
    @FXML
    private Button returnBtn; 
    /**
     * set infor for a dock
     * @param screenPath
     * @param dock
     * @throws IOException
     */
	public DockHandler(String screenPath,Dock dock) throws IOException {
		super(screenPath);
		setImage(dockImage, dock.getImageURL());
		dockNameLabel.setText(dock.getName());
		avaiableBikesLabel.setText(""+dock.getNumber_of_available_bikes());
		dockingPointLabel.setText(""+dock.getNumber_of_docking_points());
	}

	public Button getReturnBtn() {
		return returnBtn;
	}

	public void setReturnBtn(Button returnBtn) {
		this.returnBtn = returnBtn;
	}

}
