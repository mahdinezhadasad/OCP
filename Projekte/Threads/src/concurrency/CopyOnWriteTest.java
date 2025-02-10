package Threads.src.concurrency;

import java.util.*;
import java.util.concurrent.*;

public class CopyOnWriteTest {
    public static void main(String[] args) throws InterruptedException {
        List<StringBuilder> c = new CopyOnWriteArrayList<>(
                Arrays.asList(new StringBuilder("1"),
                        new StringBuilder("2"),
                        new StringBuilder("3"),
                        new StringBuilder("4")));
        
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println("got exc");
                }
                c.add(new StringBuilder("5"));
                c.get(3).replace(0, 1, "four"); // 🔹 StringBuilder verändert sich!// 🔹 Fügt ein neues Element hinzu (kopiert Liste)
                System.out.print("Thread: " + c + " ");
            }
        }).start();
        
        for (StringBuilder s : c) { // Hauptthread iteriert über die alte Kopie
            System.out.print(s + " ");
            Thread.sleep(100);
        }
        
        Locale i1 = Locale.getDefault();       // US
        Locale i2 = new Locale("it");          // Italy
        Locale i3 = new Locale("it", "CH");    // Switzerland
        System.out.println(i3.getDisplayCountry(i1));
    }
}