package ThinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}
class Orange extends Fruit {
}

class Jonathan extends Apple {
}

public class CovariantArrays {

    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<Apple>();
//        list.add(new Apple());
//        list.add(new Orange());
//        list.add(new Fruit());
//        list.add(new Object());
        list.add(null);

        Fruit f = list.get(0);

    }
}
