package secante;

import java.util.Scanner;

/**
 *
 * @author Ariel AB
 */
public class Secante {

    private Scanner teclado = new Scanner(System.in);

    private void reglaFalsa(double xZero, double xOne, double error) {
        double x0 = xZero;
        double fx0 = f(x0);
        double x1 = xOne;
        double fx1 = f(x1);
        double x2 = xSiguiente(x0, fx0, x1, fx1);
        double fx2 = f(x2);
        double eMax = error;
        short contador = 1;
        System.out.println("Error:" + eMax);
        System.out.println("# iter\t| x0 \t\t| f(x0) \t| xi \t\t| f(xi) \t| xi+1 \t\t| f(xi+1)");

        while (Math.abs(fx2) >= eMax) {

            System.out.print(contador);
            System.out.print(" \t|");
            System.out.printf("%06f", x0);
            System.out.print(" \t|");
            System.out.printf("%06f", fx0);
            System.out.print(" \t|");
            System.out.printf("%06f", x1);
            System.out.print(" \t|");
            System.out.printf("%06f", fx1);
            System.out.print(" \t|");
            System.out.printf("%06f", x2);
            System.out.print(" \t|");
            System.out.printf("%06f", fx2);
            System.out.println();
            x0 = x1;
            fx0 = fx1;

            x1 = x2;
            fx1 = fx2;

            x2 = xSiguiente(x0, fx0, x1, fx1);
            fx2 = f(x2);

            contador++;

        }
        System.out.print(contador);
        System.out.print(" \t|");
        System.out.printf("%06f", x0);
        System.out.print(" \t|");
        System.out.printf("%06f", fx0);
        System.out.print(" \t|");
        System.out.printf("%06f", x1);
        System.out.print(" \t|");
        System.out.printf("%06f", fx1);
        System.out.print(" \t|");
        System.out.printf("%06f", x2);
        System.out.print(" \t|");
        System.out.printf("%06f", fx2);
        System.out.println();
        System.out.print("\n\nRaiz: ");
        System.out.printf("%06f", x2);
        System.out.print("\nF(x+1)= ");
        System.out.printf("%06f", fx2);
        System.out.print("\nIteraciones necesarias" + contador + "\n");

    }

    private double f(double x) {
        double fx;
        fx = (double) (((Math.pow((Math.E), (0.5 * x)))) + (5 * x) - 5);
        return fx;
    }

    private double xSiguiente(double x0, double fx0, double x1, double fx1) {
        return x1 - ((fx1 * (x0 - x1)) / (fx0 - fx1));
    }

    public void main() {
        double x0;
        double x1;
        double error;
        System.out.println("Ingrese el valor x0:");
        x0 = teclado.nextDouble();
        System.out.println("Ingrese el valor x1:");
        x1 = teclado.nextDouble();
        System.out.println("Ingrese el error máximo:");
        error = teclado.nextDouble();
        reglaFalsa(x0, x1, error);
    }
}
