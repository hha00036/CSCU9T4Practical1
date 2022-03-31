// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<AthleteRunRecord> tr;
    private List<SwimmingAthlete> swim;
    private List<RunningAthlete> run; 
    private List<CyclingAthlete> cycle; 
    
    public TrainingRecord() {
        tr = new ArrayList<AthleteRunRecord>();
        swim = new ArrayList<SwimmingAthlete>();
        run = new ArrayList<RunningAthlete>();
        cycle = new ArrayList<CyclingAthlete>();
    } //constructor
    
    // add a record to the list
   public void addEntry(AthleteRunRecord e){
       tr.add(e);    
   } // addClass
   public void addSwimEntry(SwimmingAthlete e){
	   swim.add(e);    
   }
   public void addRunEntry(RunningAthlete e){
	   run.add(e);    
   }
   public void addCycleEntry(CyclingAthlete e){
	   cycle.add(e);    
   }
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
	   ListIterator<SwimmingAthlete> iter = swim.listIterator();
	   ListIterator<RunningAthlete> iter1 = run.listIterator();
	   ListIterator<CyclingAthlete> iter2 = cycle.listIterator();
       String result = "No entries found";
       while (iter.hasNext() || iter1.hasNext() || iter2.hasNext()) {
    	   SwimmingAthlete current = iter.next();
    	   RunningAthlete current1 = iter1.next();
    	   CyclingAthlete current2 = iter2.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
          {
             result = current.getEntry();
          }
         
       if (current1.getDay()==d && current1.getMonth()==m && current1.getYear()==y) {
           result = current1.getEntry();
          }
   if (current2.getDay()==d && current2.getMonth()==m && current2.getYear()==y) {
       result = current2.getEntry();
      }
}
       return result; 
       
   } // lookupEntry
   
   public String removeEntry (String n, int d, int m, int y) {
       ListIterator<AthleteRunRecord> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
    	   AthleteRunRecord current = iter.next();
          if (current.getName()==n && current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
        	  tr.remove(current);
              result = current.getEntry();
            }
       return result; 
   }
   
   public String lookupAllEntries (int d, int m, int y) {
       ListIterator<AthleteRunRecord> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
    	   AthleteRunRecord current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = result + current.getEntry();
            }
       return result;
   }
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord