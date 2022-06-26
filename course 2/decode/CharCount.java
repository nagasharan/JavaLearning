import edu.duke.*;
/**
 * Write a description of CharCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharCount {
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
        
        
        return maxInd;
        
    }
    
    public static void  countWordLengths(FileResource resource, int[] counts){
        
        
        for(String words : resource.words()){
            int tempCount = 0;
            
            for(int i=0; i<words.length();i++){
                if(Character.isLetter(words.charAt(i))){
                    tempCount +=1;
                }
            }
            if(tempCount>counts.length-1){
                counts[counts.length-1]+=1;
            }
            else{
                counts[tempCount]+=1;
            }
        }
        
        for(int k=0; k<counts.length;k++){
        System.out.println("The words with Letters "+k+" are total = "+counts[k]);
    }
    }

   
    
    
    public static void test(){
    String str = "aaaaabbbbbcccddezkkkkkkkkkk";
    String charecters = "abcdefghijklmnopqrstuvwxyz";
    int[] count;
    count= countLetters(str);
    for(int k=0; k<charecters.length();k++){
        System.out.println(charecters.charAt(k) +"\t"+count[k]);
    }
    int maxi = maxIndex(count);
    System.out.println("Max letter is  "+charecters.charAt(maxi));
}

public static void testCountWordLengths(){
   FileResource fr = new FileResource(); 
   int[] counts = new int[31];
   countWordLengths(fr,counts);
   System.out.println(maxIndex(counts));
}

}
