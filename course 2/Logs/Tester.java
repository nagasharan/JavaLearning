
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        //log.printAll();
        //System.out.println(log.countUniqueIps());
        //log.printAllHigherThanNum(400);
        //ArrayList test = log.uniqueIPVisitsOnDay("Mar 24");
        //for(int i=0;i<test.size();i++){
         //   System.out.println(test.get(i));
            
        //}
        
        ArrayList test2 = log.countUniqueIPsInRange(400,499);
        for(int i=0;i<test2.size();i++){
            System.out.println(test2.get(i));
            
        }
    }
    
    
}
