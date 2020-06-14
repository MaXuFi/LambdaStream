package lambdaTest;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/9 21:41
 * @description lambda表达式入门一
 */
public class LambdaDemo1 {
    interface Printer{
        void print(String val);
    }

    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();
        String something = "This is the first lambda demo";
        lambdaDemo1.printSomething(something,toPrint -> System.out.println(toPrint));
    }
}
