package Threads.src.threads;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
    
    public static void main(String[] args) {
        
        
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<Integer, String>();
        
        map.put (5,"Funf");
        map.put (1,"Eins");
        map.put (3,"Drei");
        map.put (2,"zwei");
        map.put (4,"vier");
        
        System.out.println ("Sortierte  Map:" + map);
        System.out.println ("Wert für schlüssel 3:" + map.get (3));
        
        System.out.println ("Erster Eintrag:" + map.firstEntry ());
        System.out.println ("Letzter Eintrag:" + map.lastEntry ());
        
        map.remove (3);
        
        System.out.println ("Nach Entfernen von Schlüssel 3:" + map);
    }
}