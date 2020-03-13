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
	
	// Faster pointer and slow pointer way
	// Without using hashset to check if there is duplicates
	public boolean isHappy3(int n){
		// slow will reach to fast if there is duplicates cycle 
		int slow = n;
		
		int fast = findNext(n);
		
		// If fast is 1, then its already a happy number
		// If slow == fast, there is a cycle
		while(fast != 1 && slow != fast){
			slow = findNext(slow);
			
			fast = findNext(findNext(fast));
		}
		
		// If its 1, then its happy number (true), if not (false)
		return fast == 1;
	}
	
	// Add all the squares from each digits
	private int findNext(int n){
		int squaredSum = 0;
		
		while(n > 0){
			int lastDigit = n % 10;
			
			squaredSum += (lastDigit * lastDigit);
			
			n /= 10;
		}
		
		return squaredSum;
	}
	
	
}
