import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String,ArrayList> mymap;   
    private ArrayList<String> usedList;
    private int count;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        mymap = new HashMap<String,ArrayList>();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
        mymap = new HashMap<String,ArrayList>();
    }
    
    private void initializeFromSource(String source) {
        mymap = new HashMap<String,ArrayList>();
        String[] category={"adjective","noun","color","country"
        ,"name","animal","timeframe","verb","fruit"};
        ArrayList<String> data=new ArrayList<String>();
        for(int i=0;i<category.length;i++){
           data.clear(); 
           data = readIt(source+"/"+category[i]+".txt");
           //System.out.println(data.get(i));
           
           mymap.put(category[i],data); 
        
        }
        
        
    }
    
    private String randomFrom(ArrayList<String> source){
        
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    
    }
    
    private String getSubstitute(String label) {
        
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else{
            ArrayList<String> a = mymap.get(label);
            return randomFrom(a);
        }
        
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        usedList = new ArrayList<String>();
        
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(true){
            if(usedList.indexOf(sub)==-1){
                break;
              }
            sub = getSubstitute(w.substring(first+1,last));  
          }
        usedList.add(prefix+sub+suffix);
        count+=1;
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public int totalWordsInMap(){
    int vl = 0;
    for(String s : mymap.keySet()){
        vl = vl+mymap.get(s).size();
        
    }
    return vl;    
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println(count);
        System.out.println(totalWordsInMap());
        
    }
    
    

}
