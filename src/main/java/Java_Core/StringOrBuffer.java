package Java_Core;

public class StringOrBuffer {

    public String str1;
    public String str2;
    public StringBuffer str3;
    public StringBuilder str4;

    public StringOrBuffer(String str1, String str2, StringBuffer str3, StringBuilder str4){
        this.str1=str1;
        this.str2=str2;
        this.str3=str3;
        this.str4=str4;
    }

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "abc";

        StringBuffer s3 = new StringBuffer("abc");
        StringBuilder s4 = new StringBuilder("abc");

        StringOrBuffer sb1 = new StringOrBuffer(s1,s2,s3,s4);
        boolean bs1 = (sb1.str1 == sb1.str2);
        boolean bs2 = (sb1.str1.equals(sb1.str3));
        boolean bs3 = (sb1.str3.equals(sb1.str4));

        System.out.println(bs1+ " "+ bs2+ " "+ bs3);

    }
}
