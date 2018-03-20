package exercise.chapter1_1;

public class Ex02 {
    public static void main(String[] args) {
        Object o = (1 + 2.236) / 2;
        System.out.println(o + "\t" + o.getClass().getName());

        o = 1 + 2 + 3 + 4.0;
        System.out.println(o + "\t" + o.getClass().getName());

        o = 4.1 >= 4;
        System.out.println(o + "\t" + o.getClass().getName());


        o = 1 + 2 + "3";
        System.out.println(o + "\t" + o.getClass().getName());
    }
}
