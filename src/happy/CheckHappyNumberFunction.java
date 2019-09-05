package happy;

import java.util.HashSet;
import java.util.Set;

public class CheckHappyNumberFunction {
    public boolean isHappy(int n) {
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
}
