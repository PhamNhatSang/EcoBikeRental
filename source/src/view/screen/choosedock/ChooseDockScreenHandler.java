package view.screen.choosedock;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.PaymentController;
import entity.dataaccess.DockDataAccess;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.payment.PaymentScreenHandler;
import view.screen.payment.ResultScreenHandler;
    /**
     * this is ChooseDockScreenHandler class
     * @author NhatSang
     * @version 1.0
     */
public class ChooseDockScreenHandler extends BaseScreenHandler {
    @FXML
    private VBox listDock;
    /**
     * set infor all dock for choose dock screen
     * @param stage
     * @param screenPath
     * @throws IOException
     * @throws SQLException
     */
	public ChooseDockScreenHandler(Stage stage, String screenPath) throws IOException, SQLException {
		
		super(stage, screenPath);
		listDock.getChildren().clear();
		List listDockElement=new ArrayList<>();
		listDockElement= DockDataAccess.getDockDataAccess().getListDock();
		for(Object obj:listDockElement) {
			Dock dockItem=(Dock) obj;
			DockHandler dockHandler=new DockHandler(Configs.DOCK_HANDLER, dockItem);
			listDock.getChildren().addAll(dockHandler.getContent());
			dockHandler.getReturnBtn().setOnMouseClicked(e->{
				try {
					PaymentScreenHandler paymentScreenHandler= new PaymentScreenHandler(stage, Configs.PAYMENT_SCREEN,dockItem);
					paymentScreenHandler.setBController(new PaymentController());
					paymentScreenHandler.setPreviousScreen(this);
				    paymentScreenHandler.show();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}
		
	}

}
