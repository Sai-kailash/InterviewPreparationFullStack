package Java_Core;

public class Boxing_Unboxing {

    int a;

    public Boxing_Unboxing(int a){
        this.a = a;
    }
   public void boxer(int a){

        Integer boxed_a = a; //background Integer boxed_a = Integer.valueOf(a); This is also known as Autoboxing

       System.out.println("Boxed value "+boxed_a);
   }

   public void unboxer(Integer a_boxed){

        a = a_boxed;

        System.out.println("Unboxed a "+a);
   }

   public static void main(String[] args){

        Boxing_Unboxing b = new Boxing_Unboxing(100);

        b.boxer(200);
        b.unboxer(367);
   }

}
