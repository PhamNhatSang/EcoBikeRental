package calculatemethod;

import entity.rental.Rental;

public class CalculateMethod {
     private CalculateFees calculateFees;
     
     public CalculateMethod(CalculateFees calculateFees ) {
    	 this.calculateFees=calculateFees;
     }
     public double Calculate() {
    	 return this.calculateFees.CalculateBikeRentedFees();     
     
     }
}
