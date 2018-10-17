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
        Apple d = appleHolder.getValue();
        appleHolder.setValue(d);
//        Holder<Fruit> fruitHolder=appleHolder;
        Holder<? extends Fruit> fruit = appleHolder;
        Fruit p = fruit.getValue();
        d = (Apple) fruit.getValue();
        System.out.println(fruit.equals(d));
        Orange c = (Orange) fruit.getValue();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
