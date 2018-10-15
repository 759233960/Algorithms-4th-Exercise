package ThinkingInJava.generics;


import ThinkingInJava.typeinfo.factory.Factory;

class Foo2<T> {
    private T x;

    public <F extends Factory<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }

    public static class Factory implements ThinkingInJava.typeinfo.factory.Factory<Integer> {

        @Override
        public Integer create() {
            return new Integer(0);
        }
    }
}

class Widget {
    public static class Factory implements ThinkingInJava.typeinfo.factory.Factory<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new IntegerFactory.Factory());
        new Foo2<>(new Widget.Factory());
    }
}
