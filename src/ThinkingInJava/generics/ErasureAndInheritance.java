package ThinkingInJava.generics;

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {

}

class Derived2 extends GenericBase{

}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);//warning "unchecked"

        Derived1<Object> d1 = new Derived1<>();
        Object obj1 = d1.get();
        d1.set(obj1);
    }
}
