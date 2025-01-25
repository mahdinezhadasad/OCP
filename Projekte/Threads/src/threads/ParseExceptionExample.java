package Threads.src.threads;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseExceptionExample  {
    
    public static void main(String[] args) {
        
        String dateStr = "2025-01-30";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Date date = sdf.parse(dateStr);
            System.out.println ("Parsed date: " + date);
        }catch(ParseException e){
            
            System.out.println ("ParseException: " + e);
        }
        
        String numberSr = "12,34";
        NumberFormat nf = NumberFormat.getInstance();
        try{
            
            Number number = nf.parse (numberSr);
            System.out.println ("Parsed number: " + number);
            
        }catch (ParseException e){
            System.out.println ("ParseEcepion: Ungültiges Zahlenformat!");
        }
    }
}