public class MySimpleClass {
    public MySimpleClass() {

    }

    @MySimpleAnnotation(firstParam = 2, secondParam = 3)
    public void sum(int firstParam, int secondParam) {
        System.out.println("Sum = "+(firstParam + secondParam));
    }

    @MySimpleAnnotation(firstParam = 8, secondParam = 2)
    public void subtraction(int firstParam, int secondParam) {
        System.out.println("Subtraction = "+(firstParam - secondParam));
    }

    public void multiplication(int firstParam, int secondParam){
        System.out.println("Multiplication = "+(firstParam * secondParam));
    }

}
