package ThinkingInJava.generics;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);
//        Holder<Fruit> fruitHolder=appleHolder;
        Holder<? extends Fruit> fruit = appleHolder;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        System.out.println(fruit.equals(d));
        Orange c = (Orange) fruit.get();
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
