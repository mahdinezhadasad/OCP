package Functional.src.collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class Props {
    public static void main(String[] args) {
        Properties p = new Properties ();
        p.setProperty("k1", "v1");
        p.setProperty("k2", "v2");
        p.list(System.out);
        try {
            FileOutputStream out = new FileOutputStream ("myProps.properties");
            p.store(out, "test");           // Line A
            out.close();
        } catch (IOException e) {
            System.out.println("exc 1");
        }
        Properties p2 = new Properties();
        p2.setProperty("a1", "a2");
        try {
            FileInputStream in = new FileInputStream("myProps.properties");
            p2.load(in);                    // Line B
            in.close();
            p2.list(System.out);
        } catch (IOException e) {
            System.out.println("exc 2");
        } } }