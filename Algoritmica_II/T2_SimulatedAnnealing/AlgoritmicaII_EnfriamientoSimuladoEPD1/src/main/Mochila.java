package main;

import java.util.Arrays;

/**
 *
 * @author Quini_Dev
 */
public class Mochila {

    public static int[] enfriamientoSimulado(int[] elementos, int n, int capacidad) {
        int[] bestSolution = new int[n];
        int[] solutions = new int[n];
        int pesoGlobal = 0;
        double temp = 10000;
        int peso, nuevo;
        while (temp > 1) {
            nuevo = (int) (Math.random() * solutions.length);
            Util.permuta(solutions, nuevo);
            peso = elementos[nuevo] + pesoGlobal;
            for (int i = 0; i < n; i++) {
                Util.permuta(solutions, i);
                peso += elementos[i];
                if (aceptarProbabilidad(peso, pesoGlobal, capacidad, temp) > Math.random()) {
                    pesoGlobal = peso;
                } else {
                    peso -= elementos[i];
                    Util.permuta(solutions, i);
                }
                if (pesoGlobal > calcularPeso(bestSolution, elementos) && pesoGlobal < capacidad) {
                    bestSolution = Arrays.copyOf(solutions, solutions.length);
                }
            }
            temp -= 0.1 * temp;
        }

        return bestSolution;
    }

    private static double aceptarProbabilidad(int peso, int capacidad, int pesoGlobal, double temperatura) {
        if (peso > pesoGlobal && peso < capacidad) {
            return 1.0;
        }
        return Math.exp((pesoGlobal - peso) / temperatura);
    }

    public static int calcularPeso(int[] solution, int[] elementos) {
        int res = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (solution[i] != 0) {
                res += elementos[i];
            }
        }
        return res;
    }
}
