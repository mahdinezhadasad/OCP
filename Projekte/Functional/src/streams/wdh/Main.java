package Functional.src.streams.wdh;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

class Sum extends RecursiveAction {
    static final int THRESHOLD_SIZE = 3;
    int stIndex, lstIndex;
    int[] data;
    
    public Sum(int[] data, int start, int end) {
        this.data = data;
        this.stIndex = start;
        this.lstIndex = end;
    }
    
    @Override
    protected void compute() {
        int sum = 0;
        if (lstIndex - stIndex <= THRESHOLD_SIZE) {
            for (int i = stIndex; i < lstIndex; i++) {
                sum += data[i];
            }
            System.out.println(sum);
        } else {
            Sum subTask1 = new Sum(data, stIndex + THRESHOLD_SIZE, lstIndex);
            Sum subTask2 = new Sum(data, stIndex, Math.min(lstIndex, stIndex + THRESHOLD_SIZE));
            subTask1.fork();
            subTask2.compute();
            subTask1.join();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stream<List<String>> iStr = Stream.of(
                Arrays.asList("1", "John"),
                Arrays.asList("2", null)
        );
        Stream<String> nInSt = iStr.flatMap ((x) -> x.stream());
        nInSt.forEach(System.out::print);
        
        
    }
}