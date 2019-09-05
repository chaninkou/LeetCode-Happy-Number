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
                remain = n % 10;
                
                squareSum = squareSum + remain * remain;
                
                n = n / 10;
            }
            if(squareSum == 1){
                return true;
            } else {
                n = squareSum;
            }
        
        }
        return false;
    }
}
