package Java_Core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public void StreamPrintOps(){
        List<Integer> list = Arrays.asList(1,2,3,4,95,6,7,8,9);

        List<Integer> evenNumbers = list.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .collect(Collectors.toList());
        System.out.println("List stream");

        IntStream.of(1,2,3,4,5).toArray();
        Stream.of(1,2,3,4,5);
        int[] set2 = Arrays.stream(new int[]{1,2,3,4,5}).filter(i -> i%2 == 0).toArray();

        for(int number: evenNumbers){
            System.out.println(number);
        }

        System.out.println("Set stream");
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        for(int number: set){
            System.out.println(number);
        }

    }

    public static void main(String[] args){
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.StreamPrintOps();

//        String s = "sai";
//        char[] ch = s.toCharArray();
//        s.substring(0, 2);

    }
}
