package ThinkingInJava.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
//        Fruit a = fruitReader.readExact(apples);
    }

    static void f3() {
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        Fruit f = fruitCovariantReader.readCovariant(fruit);
        Fruit a = fruitCovariantReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }
}
