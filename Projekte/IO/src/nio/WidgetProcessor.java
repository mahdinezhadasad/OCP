package IO.src.nio;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

public class WidgetProcessor {
    
    public int getWidgetNumber(byte[] data)  throws Exception {
        
        try(InputStream is  = new ByteArrayInputStream (data)) {
            
            System.out.println (is.read (new byte[2]));
            if(!is.markSupported ()) return -1;
            is.mark(5);
            System.out.println (is.read ());
            System.out.println (is.read ());
            is.skip (3);
            is.reset ();
            return is.read ();
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        Console c = System.console();
        if(c != null) {
            c.writer().write('P');
            c.writer().write('a');
            c.writer().write('s');
            c.writer().write('s');
            c.writer().flush();  // t1
            int i;
            StringBuilder sb = new StringBuilder();
            while((i = c.reader().read()) != 'x') {  // t2
                sb.append((char)i);
            }
            c.writer().format("Result: %s",sb.toString());
        }
    }
}