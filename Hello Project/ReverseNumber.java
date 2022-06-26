
/**
 * Write a description of ReverseNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseNumber {
    
    public void reverse(int x){
        int y;
        if (x<0){
             y = -x;
        }
        else{
            y = x;
        }
        int dig = countDig(y);
        String out = "";
        for (int i=0; i<dig; i++){
          int out_1 =  y%10;
          out = out + out_1;
          y = (y-out_1)/10;}
        
        if (x<0){
            System.out.println(-(Integer.parseInt(out)));
        }
        else{
            System.out.println(Integer.parseInt(out));
        }  
        
        
    }
    
    public int countDig(int n) {  
        // handling base case  
        if(n / 10 == 0)  
        {  
            return 1;  
        }  
        // recrusively finding the length of the integer n  
    return 1 + countDig(n / 10);  
    }  
    }
