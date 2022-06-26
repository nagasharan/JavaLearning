
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences(String a , String b){
        if (b.indexOf(a) != -1){
            
            if (b.indexOf(a,b.indexOf(a)+1) != -1){
                
             return true;   
                
            }
            else{
                return false;}
            }
            else{
                return false;}
            }
        
        
            public void testingtwoOccurrences(){
                String a = "atg";
                
                String b = "ctgtatgta";
                
                boolean result = twoOccurrences(a,b);
                System.out.println(result);
                
                
                
                
            }
       public String lastPart(String a , String b){
           int lengthOfA = a.length();
           int indexA = b.indexOf(a);
           if (indexA == -1){
               return b;}
           else{
           String output = b.substring(indexA+lengthOfA,b.length());
           return output;}
        }
        
        public void testingLastPart(){
         String a = "zoo";
         String b = "forest";
         
         String out = lastPart(a,b);
         System.out.println(out);
            
            
            
        }
        
        
    }


