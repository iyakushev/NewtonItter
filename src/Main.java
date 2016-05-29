public class Main {

    public static void main(String[] args) {

        System.out.println("Here are some results ::\n------------------\n"+
                "Simple Iterations Method: "+ iterations(-1.0,4.0,Math.pow(10,-15),true)+
                "\nNewton's method: "+Newton(-1.0,4.0,Math.pow(10,-15),true));
    }

    private static int iterations(double x1, double x2, double E, boolean out) {
        double a=x1;
        double b=x2;

        System.out.println("*********SIMPLE ITERATIONS*********");

        // Check boundaries
        if(Math.abs(derivative(a))>1||Math.abs(derivative(b))>1) {
            System.out.println("Wrong function! Nothing to look here.");
            return 0;
        }

        // Run simple iterations
        int i;
        for(i=0; Math.abs(b-a)>E; i++) {
            a=transform(a);
            b=transform(b);
            if(out)
                System.out.printf("Iter %d\tx1: %f\tx2: %f\tx2-x1: %1.15f\n", i, a, b, b-a);
        }

        if(out)
            System.out.printf("Root = %1.13f\n", a);
        return i;
    }

    private static double transform(double x) {
        return Math.pow(x,5)-32*x-100;
    }

    private static double derivative(double x) {
        return 5*Math.pow(x,4)-32*x;
    }

    private static int Newton(double x1, double x2, double E, boolean out) {
        double a=x1,b=x2;
        System.out.println("**************NEWTON***************");

        if(transform(a)*transform(b)>0){
            System.out.println("Wrong function! Nothing to look here.");
            return 0;
        }

        int i;
        //Method itself
        for(i=0; Math.abs(b-a)>E; i++) {
            b=a;
            a=b-transform(a)/derivative(a);
            if(out)
                System.out.printf("Iter %d\tx1: %f\tx2: %f\tx2-x1: %1.15f\n", i, a, b, b-a);
        }
        if(out)
            System.out.printf("Root = %1.13f\n", a);
        return i;
    }
}