import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void PrintUrl(){
       URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
       
       
        for (String words : url.words()){
           String lowerWords = words.toLowerCase();
           
           if (lowerWords.indexOf("youtube") != -1){
               int firstIndex = words.indexOf("http");
               int lastIndex = words.indexOf("\"", firstIndex);
               System.out.println(words.substring(firstIndex,lastIndex));
            }
           
           
           
        }
       
        
        
        
        
    }
}
