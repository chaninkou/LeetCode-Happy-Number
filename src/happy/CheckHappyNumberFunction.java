package happy;

import java.util.HashSet;
import java.util.Set;

public class CheckHappyNumberFunction {
    public boolean isHappy1(int n) {
        Set<Integer> inLoop = new HashSet<>();
        
        int squareSum;
        int remain;
        
        // Once there is a duplicate, stop the loop and return false
        while(inLoop.add(n)){
            squareSum = 0;
            while(n > 0){
                // Getting single digit
                remain = n % 10;
                
                // Adding the square numbers
                squareSum = squareSum + remain * remain;
                
                // Decrease the number of digit by 1 place
                n = n / 10;
            }
            // If its 1, then it is a happy number
            if(squareSum == 1){
                return true;
            } else {
                //  Checking next sum now
                n = squareSum;
            }
        
        }
        return false;
    }
	
	// Method number 2, easier to understand
	public boolean isHappy2(int n ){
		Set<Integer> set = new HashSet<>();
	
		// If this loop break, we know its 1
		while(n != 1){
			int current = n;
			int nextSum = 0;
			
			// When current is zero, we know we added up all the digits
			while(current != 0){
				int currentDigit = current % 10;
				
				nextSum += currentDigit * currentDigit;
				
				current = current/10;
			}
			
			// If the set already contain the next sum, we know it is just a cycle
			if(set.contains(nextSum)){
				return false;
			}
			
			set.add(nextSum);
			
			n = nextSum;
		}
		
		// Return true since n becomes 1, which is a happy number
		return true;
	}
	
	
}
