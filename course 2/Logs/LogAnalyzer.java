
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String line: fr.lines()){
             records.add(WebLogParser.parseEntry(line));
             
            }
     }
     
     public int countUniqueIps(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
             String check = le.getIpAddress();
             if(!uniqueIPs.contains(check)){
                 uniqueIPs.add(check);
                }
            }
         return uniqueIPs.size();
        }
     
     public void printAllHigherThanNum(int num){
         ArrayList<String> status = new ArrayList<String>();
         for (LogEntry le : records) {
             int check = le.getStatusCode();
             if(check>num){
                 System.out.println(le);
                }
            }
         
         
        }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public ArrayList uniqueIPVisitsOnDay(String day){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for (LogEntry le : records) {
             String check = le.getIpAddress();
             String date = le.getAccessTime().toString();
             if(date.substring(4,10).equals(day)&&!uniqueIPs.contains(check)){
                 uniqueIPs.add(check);
                }
            }
         return uniqueIPs;
        }
     
     public ArrayList countUniqueIPsInRange(int low, int high){
            ArrayList<String> uniqueIPs3 = new ArrayList<String>();
         
            for (LogEntry le : records) {
             String check = le.getIpAddress();
             int SC = le.getStatusCode();
             
             if(SC >= low && SC <= high && !uniqueIPs3.contains(check)){
                 uniqueIPs3.add(check);
                }
            }
            return uniqueIPs3;
            
        }
        
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         
         for(LogEntry le:records){
             String ip = le.getIpAddress();
             
             if(counts.containsKey(ip)){
                 int val = counts.get(ip);
                 counts.put(ip,val+1);
                }
             else{
                 counts.put(ip,1);
                 
                }
             
            }
         return counts;
         
         
        }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
         int maxC = 0;
         String maxIP = "";
         for(String ip: counts.keySet()){
             if(counts.get(ip)>maxC){
                maxC = counts.get(ip); 
                maxIP = ip; 
                }
             
            }
         
         return maxC;
        }
        
     public ArrayList<String>  iPsMostVisits(HashMap<String,Integer> counts){
         int maxC = mostNumberVisitsByIP(counts);
         
         ArrayList<String> out= new ArrayList<String>();
         
         for(String ip: counts.keySet()){
             if(counts.get(ip).equals(maxC)){
                out.add(ip);
                }
             
            }
         return out;
         
        }
        
     public HashMap<String,ArrayList<String>> iPsForDays(){
         HashMap<String,ArrayList<String>> ipd = new HashMap<String,ArrayList<String>>();
         
         for(LogEntry le:records){
             String date = le.getAccessTime().toString();
             date = date.substring(4,10);
             if(!ipd.containsKey(date)){
                 ArrayList<String> ip= new ArrayList<String>();
                 ip.add(le.getIpAddress());
                 ipd.put(date,ip);
                }
             else{
                 ArrayList<String> ips = ipd.get(date);
                 String test = le.getIpAddress();
                 ips.add(test);
                 ipd.put(date,ips);
                 
                }
             
            }
         
         
         
         return ipd;
        }
        
        
        
     public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> counts){
         int maxS = 0;
         String maxD = "";
         
         for (String data: counts.keySet() ){
             int count = counts.get(data).size();
             if(count>maxS){
                maxS = count;
                maxD = data;
                 
                }
             
            }
         
         
         return maxD;
    }
    
    public ArrayList<String>  iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> counts, String date){
        ArrayList<String> out = new ArrayList<String>();
        HashMap<String,Integer> count = new HashMap<String,Integer>();
        for (String data: counts.keySet() ){
             
             if(data.equals(date)){
                out = counts.get(data);
                for(String ip : out){
                    if(count.containsKey(ip)){
                        int val = count.get(ip);
                        count.put(ip,val+1);
                }
                else{
                 count.put(ip,1);
                 
                }
                    
                }
                }
             
            }
        
        ArrayList<String> outr = iPsMostVisits(count);
            
        
        return outr;
        
    }
}
