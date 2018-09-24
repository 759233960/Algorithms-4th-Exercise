package ThinkingInJava.exceptions;

public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut,BaseballException {
    }
    public StormyInning(String s) throws Foul,BaseballException {
    }

    @Override
    public void walk(){
        super.walk();
    }

    @Override
    public void event() {
    }

    @Override
    public void atBat() throws PopFoul{

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic Baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        }catch (Strike strike) {
            System.out.println("strike");
        }catch (Foul foul) {
            System.out.println("foul");
        }catch (RainedOut rainedOut) {
            System.out.println("rainedOut");
        }catch (BaseballException e) {
            System.out.println("BaseballException");
        }
    }
}

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract void atBat() throws Strike,Foul;
    public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}
