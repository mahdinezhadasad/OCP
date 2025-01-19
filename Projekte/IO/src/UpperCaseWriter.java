package IO.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UpperCaseWriter extends Writer {
    
    private final Writer out;
    
    public UpperCaseWriter(Writer out) {
        this.out = out;
    }
    
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        
        for(int i = off; i < off + len; i++){
            
            cbuf[i] = Character.toUpperCase(cbuf[i]);
        }
        
        out.write(cbuf);
        
    }
    
    @Override
    public void flush() throws IOException {
        out.flush ();
    }
    
    @Override
    public void close() throws IOException {
        out.close ();
    }
    
    public static void main(String[] args) {
        try(Writer out = new UpperCaseWriter(new BufferedWriter (new FileWriter ("Output.txt")))) {
            
            out.write ("Hello World");
        } catch (
                IOException e) {
            throw new RuntimeException (e);
        }
    }
}