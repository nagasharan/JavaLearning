import edu.duke.*;
/**
 * Write a description of CeaserBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CeaserBreaker {
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

    public static String decrypt(String encrypted,int key){
        
     CaesarCipher cc = new CaesarCipher(26-key);
     String message = cc.encrypt(encrypted);   
        
     return message;   
    }
    
    public static String  halfOfString(String message, int start){
    StringBuilder mes = new StringBuilder();
    
    for(int i = start;i<message.length();i+=2){
        mes.append(message.charAt(i));
        
    }
    return mes.toString();
    }
    
    public static int getKey(String s){
    int[] count = countLetters(s);    
    int maxi = maxIndex(count);
    //System.out.println("test key----"+maxi);
    if(maxi<4){
        return 26-4+maxi;
    }
    else{
        return maxi-4;
    }
    }
    
    public static void decryptTwoKeys(String encrypted){
        StringBuilder decrypted = new StringBuilder();
        String str1 = halfOfString(encrypted,0);
        String str2 = halfOfString(encrypted,1);
        int key1 = getKey(str1); 
        int key2 = getKey(str2);
        System.out.println(key1+"\t"+key2);
        String dec1 = decrypt(str1,key1);
        //System.out.println(dec1);
        
        String dec2 = decrypt(str2,key2);
        //System.out.println(dec2);
        for(int i = 0;i<dec1.length() ||i<dec2.length();i++){
            if(i<dec1.length()){
            decrypted.append(dec1.charAt(i));}
            if(i<dec2.length()){
            decrypted.append(dec2.charAt(i));}
        }
        System.out.println(decrypted);
    }
    
    public static void testDecrypt(){
    FileResource fr = new FileResource();
    
    String msg = fr.asString();
    //int key = 2;
    
    decryptTwoKeys(msg);    
    }
}
