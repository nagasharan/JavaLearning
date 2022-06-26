import java.util.*;
/**
 * Write a description of CountTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountTester {
    public void testCounts(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("short-test_log");
       HashMap<String,Integer> counts =la.countVisitsPerIP(); 
       System.out.println(counts);
    }
    
    public void countUniqueIPs( ){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("weblog2_log"); 
       HashMap<String,Integer> counts = la.countVisitsPerIP();
       System.out.println(counts.size());
         
        }
        
    public void tester(){
        
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("weblog2_log");
    HashMap<String,Integer> counts =la.countVisitsPerIP();
    
    System.out.println(la.mostNumberVisitsByIP(counts));
    ArrayList <String> pr = la.iPsMostVisits(counts);
    System.out.println(pr);    
        
        
    }
    
    public void testdate(){
        LogAnalyzer le = new LogAnalyzer();
        le.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> out = le.iPsForDays();
        System.out.println(out); 
        System.out.println(le.dayWithMostIPVisits(out));
        System.out.println(le.iPsWithMostVisitsOnDay(out,"Sep 30"));
    }
    
    
}
