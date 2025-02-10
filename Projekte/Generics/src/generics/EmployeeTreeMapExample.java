package Generics.src.generics;



import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class EmployeeTreeMapExample {
    
    public static void main(String[] args) {
        
        TreeMap<Integer, String> employeeTreeMap = new TreeMap<Integer, String>();
        
        employeeTreeMap.put (104,"Alic"
        );
        
        employeeTreeMap.put(101,"Bob");
        employeeTreeMap.put(102,"Carl");
        employeeTreeMap.put(103,"Dan");
        
        System.out.println ("Mitarbeiter nch ID sortiert: ");
        for(Map.Entry<Integer,String> entry : employeeTreeMap.entrySet()){
            
            System.out.println (entry.getKey() + " " + entry.getValue());
        }
        
        System.out.println ("\n Mitarbeiter nch ID sortiert: " + employeeTreeMap.get (103));
        SortedMap<Integer,String>  subMap = employeeTreeMap.subMap (102,104);
        
        System.out.println (" \n Mitarbeiter nch ID sortiert: "+ subMap);
    }
}