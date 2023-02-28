package calculatemethod;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Time.TimeControl;
import entity.rental.Rental;

public class FirstCalculateFees implements CalculateFees {
     
	public double CalculateBikeRentedFees() {
		 int minutes  = LocalTime.parse(TimeControl.getTimeControl().getTimers().getTimeLabel().getText(),DateTimeFormatter.ofPattern("HH:mm:ss")).getMinute();
				 
         System.out.println(minutes);
         if (minutes<=10) return 0;
         else if (minutes<=30) return 10000;
         else {
             int result = (minutes-30)/15+1;
             if ((minutes-30)%15==0) return 10000+(result-1)*3000;
             else return 10000+result*3000;
         }
	}
}
