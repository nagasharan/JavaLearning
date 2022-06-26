import edu.duke.*;
import java.util.ArrayList;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> charNames;
    private ArrayList<Integer> charCount;
    
    public CharactersInPlay(){
        
    charNames = new ArrayList<String>();    
    charCount = new ArrayList<Integer>();  
    }
    
    public void update(String person){
        person = person.toLowerCase();
        int index = charNames.indexOf(person);
        if (index==-1){
        charNames.add(person);
        charCount.add(1);
        }
        else{
        int value = charCount.get(index);  
        charCount.set(index,value+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        charNames.clear();
        charCount.clear();
        for(String line: fr.lines()){
            int index = line.indexOf(".");
            
            if(index!=-1){
            String person = line.substring(0,index);    
            update(person);    
            }
            
        }
    }
    
    public void  charactersWithNumParts(int num1, int num2){
        
        for(int i=0;i<charNames.size();i++){
            int count = charCount.get(i);
            if(count>num1 && count<num2){
            System.out.println(charNames.get(i)+"\t"+ count);    
                
            }
        
        }
    }
    
    public void tester(){
        findAllCharacters();
        charactersWithNumParts(5,1500);
        //for(int i=0;i<charNames.size();i++){
            //int count = charCount.get(i);
            //if(count>1){
            //System.out.println(charNames.get(i)+"\t"+ count);    
                
            //}
            
        }
        
        
    }

