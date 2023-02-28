package Time;

import java.util.TimerTask;

import javafx.scene.control.Label;
    /**
     * this is TimerControl class
     * @author NhatSang
     * @version 1.0
     */
public class TimeControl{
    private static TimeControl timeControl;
    private Timers timers;
    
	public static TimeControl getTimeControl() {
		if(timeControl==null) {
			timeControl=new TimeControl();
		}
		return timeControl;
	}

	public Timers getTimers() {
		return timers;
	}

	public void setTimers(Timers timers) {
		this.timers = timers;
	}

	
	
}
