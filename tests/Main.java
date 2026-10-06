
import rgen.LCG; 

public class Main{
    
    public static void main(String[] args) {
        int dist_err = 0;
        double total_average = 0.0;
        for(int j = 0; j < 1000; j++){
            LCG test_lcg = LCG.makeLCG();
            int[] myarr = new int[1000000];
            
            int[] distlarr = new int[100];
        
            double total = 0.0;

            for(int i = 0; i < myarr.length; i++){
                int toAdd = (test_lcg.genInt() % 100);
                if(toAdd < 0) toAdd *= -1;
                toAdd += 1;

                myarr[i] = toAdd;
                total += (double) toAdd;
                distlarr[toAdd - 1] += 1;
            }

            for(int i = 0; i < distlarr.length; i++){
                if(distlarr[i] <= 9750){
                    dist_err++;
                }
            }

            total_average += (total /((double)myarr.length));
        
        }
    
        System.out.println("total Average :: " + total_average / 1000.0);
        System.out.println("total dist_err :: " + dist_err);
        System.out.println("out of a possible " + (1000 * 100) + " dist errors");
    }

}
