import java.util.*;
import edu.duke.*;
import java.io.*;
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsInFiles {
    private HashMap<String,ArrayList> wordData;
    
    public WordsInFiles(){
    
        wordData = new HashMap<String,ArrayList>();
        
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f.getAbsolutePath());
        for(String word: fr.words()){
            
            if(!wordData.containsKey(word)){
                ArrayList<String> newFile = new ArrayList<String>();
                newFile.add(f.getName());
                wordData.put(word,newFile);
            }
            else{
            ArrayList<String> fileNames = wordData.get(word);    
            if(!fileNames.contains(f.getName())){
                fileNames.add(f.getName());
                wordData.put(word,fileNames);
            }
            }
        }
        
    }
    
    public void buildWordFileMap(){
    
        DirectoryResource dr = new DirectoryResource();
        wordData.clear();
        for(File f : dr.selectedFiles()){
           addWordsFromFile(f); 
            
        }
        
        
    }
    
    public int maxNumber(){
    int maxN=0;    
    for (ArrayList v : wordData.values()) {
        if(v.size()>maxN){
           maxN=v.size(); 
        }
    }     
    return maxN;    
    }
    
    public ArrayList wordsInNumFiles(int n){
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> outList = new ArrayList<String>();
        for (String s:wordData.keySet()){
            list = wordData.get(s);
            if(list.size()==n){
                outList.add(s);
            }
        }
        return outList;
    }
    
    public void printFilesIn(String word){
        ArrayList<String> printL = new ArrayList<String>();
        printL = wordData.get(word);
        for(int i = 0;i<printL.size();i++){
            System.out.println(printL.get(i));
            
        }
    }
    
    public void tester(){
        buildWordFileMap();
        System.out.println("word present in max num of file count: "+maxNumber());
        System.out.println("The word in given file with exact num: "+wordsInNumFiles(7).size());
        printFilesIn("sea");
    }
}
