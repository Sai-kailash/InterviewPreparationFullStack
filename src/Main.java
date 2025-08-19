//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Java_Core.StreamDemo;

class Data{
    String field;
    int value;
    int timestamp;

    public Data(String field, int value, int timestamp) {
        this.field = field;
        this.value = value;
        this.timestamp = timestamp;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        StreamDemo streamDemo = new StreamDemo();
        streamDemo.StreamPrintOps();

    }
}