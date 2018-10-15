package ThinkingInJava.generics;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
//        gia= (Generic<Integer>[]) new Object[SIZE]; //error
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
//        gia[1]= (Generic<Integer>) new Object(); //error
    }
}