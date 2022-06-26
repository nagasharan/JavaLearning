import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    
    
    
    public TestCaesarCipherTwo(){
        
        
    }
    
    
    public static String  halfOfString(String message, int start){
    StringBuilder mes = new StringBuilder();
    
    for(int i = start;i<message.length();i+=2){
        mes.append(message.charAt(i));
        
    }
    return mes.toString();
    }
    
    public static int[] countLetters(String str){
        int[] count = new int[26];
        String chr = "abcdefghijklmnopqrstuvwxyz";
        char temp ;
        for(int i = 0; i<str.length();i++){
            temp = Character.toLowerCase(str.charAt(i));
            int dex = chr.indexOf(temp);
            if(dex!=-1){
              count[dex]+=1;  
            }
            
        }
        
        return count;
    }
    
    public static int maxIndex(int[] count){
    
        int maxInd = -1;
        int maxCount = 0;
        for(int i=0;i<count.length;i++){
            if(count[i]>maxCount){
               maxCount = count[i]; 
               maxInd= i; 
            }
        }
        
        //System.out.println("Max index----"+maxInd);
        return maxInd;
       
    }
    
    public static void simpleTests(){
        FileResource fr = new FileResource();
        String sr = fr.asString();
        CaesarCipherTwo test = new CaesarCipherTwo(17,3);
        String ecrypt = test.encrypt(sr);
        System.out.println(ecrypt);
        CeaserBreaker cb = new CeaserBreaker();
        cb.decryptTwoKeys(ecrypt);
        
    }
    
}
