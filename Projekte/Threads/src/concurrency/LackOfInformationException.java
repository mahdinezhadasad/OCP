package Threads.src.concurrency;

import java.util.Arrays;
import java.util.List;

class InformationException extends Exception {}
public class LackOfInformationException extends InformationException {
    public LackOfInformationException() {  // t1
        super();
    }
    public LackOfInformationException(String s) {  // t2
        this(Arrays.asList ("dadad", "eewer" ,s));
    }
    public LackOfInformationException(List<String> c) {  // t3
        super();
    }
    @Override public String getMessage() {
        return "lackOf";
    }
}