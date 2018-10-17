package ThinkingInJava.generics;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t =holder.getValue();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw=new Holder<>(1);
        Holder str=new Holder<>("S");
        f1(raw);
        f1(str);
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.setValue(new Object());
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
        f1(wildcarded);
    }

}