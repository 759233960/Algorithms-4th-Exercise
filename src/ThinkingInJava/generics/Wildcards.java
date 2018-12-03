package ThinkingInJava.generics;

public class Wildcards {

    static void rawArgs(Holder holder, Object arg) {
        Object obj = holder.get();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg) {
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T t =holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();

        raw = new Holder();

        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
//        Long r7 = exact2(unbounded, lng);
//        Long r8 = exact2(bounded, lng);

        Long r9 = wildSubType(raw, lng);
        Long r10 = wildSubType(qualified, lng);
        Object r11 = wildSubType(unbounded, lng);
        Long r12 = wildSubType(bounded, lng);

        wildSuperType(raw, lng);
        wildSuperType(qualified, lng);
//        wildSuperType(unbounded, lng);
//        wildSuperType(bounded,lng);
    }
}
