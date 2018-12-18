package ThinkingInJava;

import java.util.Arrays;
import java.util.List;

public class Test {

    private Test() {

        List<PrivateOverride> list = Arrays.<PrivateOverride>asList(new TDerived(), new Derived());
    }
}

class PrivateOverride {
    public static void s() {
        //cannot be inherited
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }

    private void f() {
        System.out.println("private f()");
    }

    Glyph g() {
        return new Glyph();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }

    @Override
    RoundGlyph g() {
        return new RoundGlyph(2);
    }
}

class TDerived extends PrivateOverride {

}

class Glyph {
    Glyph() {
        System.out.println("Glyph before draw");
        draw();
        System.out.println("Glyph after draw");
    }

    void draw() {
        System.out.println("Glyph.draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 100;

    RoundGlyph(int r) {
        radius = r;
        System.out.println(" RoundGlyph(int r): " + radius);
    }

    @Override
    void draw() {
        System.out.println(" RoundGlyph.draw: radius=" + radius);
    }
}

class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}