package Time;

import java.security.PublicKey;
import java.util.DoubleSummaryStatistics;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;
   /**
    * this is Timers class
    * @author NhatSang
    * @version 1.0
    */
public class Timers extends TimerTask{
    
	
	private Label timeLabel;
	int seconds=0 ;
    int minutes=0 ;
    int hours=0 ;

	public Timers(Label timeLabel) {
		this.timeLabel=timeLabel;
		
	}
	@Override
	public void run() {
		Platform.runLater(()->{
			
			seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
            System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
            String hourString = String.format("%02d", hours);
            String minuteString = String.format("%02d", minutes);
            String secondString = String.format("%02d", seconds);
		    this.timeLabel.setText(hourString+":"+minuteString+":"+secondString);
		    System.out.println(this.timeLabel.getText());
		   });
		
}
	public Label getTimeLabel() {
		return timeLabel;
	}
	public void setTimeLabel(Label timeLabel) {
		this.timeLabel = timeLabel;
	}
	public void setTime() {
		String[] time=this.timeLabel.getText().split(":");
		this.hours  =Integer.parseInt(time[0]);
		this.minutes=Integer.parseInt(time[1]);
		this.seconds=Integer.parseInt(time[2]);
		
		
	}
}
