package ThinkingInJava.generics;

interface Payable<T> {
}

class Employees implements Payable<Employees> {
}

class Hourly extends Employees implements Payable<Employees> {
}

//class Hourly extends Employees implements Payable<Hourly>{}
public class MultipleInterfaceVariants {
}
