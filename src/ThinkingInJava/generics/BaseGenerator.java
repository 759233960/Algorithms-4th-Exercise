package ThinkingInJava.generics;

public class BaseGenerator<T> implements Generator<T> {
    private Class<T> type;

    private BaseGenerator(Class<T> type) {
        this.type = type;
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BaseGenerator<>(type);
    }

    @Override
    public T nextItem() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
