package main;

import java.util.Arrays;

/**
 *
 * @author Quini_Dev
 */
public class Funcion {

    public static int[] enfriamientoSimulado() {
        int[] bestSolution = {0, 0, 0, 0, 0};
        int[] solutions = {0, 0, 0, 0, 0};
        double mejorValor = Integer.MIN_VALUE;
        double temp = 100;
        int nuevo;
        double valorFuncion;
        while (temp > 1) {
            nuevo = (int) (Math.random() * solutions.length);
            Util.permuta(solutions, nuevo);
            for (int i = 0; i < solutions.length; i++) {
                Util.permuta(solutions, i);
                valorFuncion = funcionCalc(solutions);
                if (aceptarProbabilidad(valorFuncion, mejorValor, temp) > Math.random()) {
                    mejorValor = valorFuncion;
                } else {
                    Util.permuta(solutions, i);
                }
                if (mejorValor > funcionCalc(bestSolution)) {
                    bestSolution = Arrays.copyOf(solutions, solutions.length);
                }
            }
            temp -= 0.1 * temp;
        }
        return bestSolution;
    }

    private static double funcionCalc(int[] array) {
        int n = Util.binaryToDecimal(array);
        return Math.pow(n, 3) - 60 * Math.pow(n, 2) + 900 * n + 100;
    }

    private static double aceptarProbabilidad(double valorFuncion, double mejorValor, double temperatura) {
        if (valorFuncion > mejorValor) {
            return 1.0;
        }
        return Math.exp((mejorValor - valorFuncion) / temperatura);
    }
}
