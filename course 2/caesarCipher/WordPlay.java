import edu.duke.*;
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public static Boolean  isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch=='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String replaceVowels(String phrase, char ch){
        
        StringBuilder output = new StringBuilder(phrase);
        int length = phrase.length();
        
        for(int i = 0; i<length; i++){
            
            if(isVowel(output.charAt(i))){
                output.setCharAt(i,ch);
            }
            
            
        }
        
        return output.toString();
        
        
    }
    
    public static String emphasize(String phrase, char ch){
        char chLower = Character.toLowerCase(ch);
        char chUpper = Character.toUpperCase(ch);
        StringBuilder output = new StringBuilder(phrase);
        int length = phrase.length();   
        for(int i = 0; i<length; i++){
           if(output.charAt(i)==chLower || output.charAt(i)==chUpper && (i+1)%2==0){
             output.setCharAt(i,'+');  
            }
           if(output.charAt(i)==chLower || output.charAt(i)==chUpper && (i+1)%2!=0){
             output.setCharAt(i,'*');  
               
            }
            
            
        }
        
        return output.toString();   
    }
    
    
    public static void test(){
       //System.out.println(isVowel('Z')); 
       System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
       //System.out.println(replaceVowels("Hello world",'*')); 
    }
}

