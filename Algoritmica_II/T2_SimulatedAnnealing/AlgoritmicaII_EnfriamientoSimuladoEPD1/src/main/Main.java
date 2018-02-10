package main;

import java.util.Arrays;

/**
 *
 * @author Quini_Dev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("------------ EJERCICIO 1 ---------");
        int max = (int) Util.binaryToDecimal(Funcion.enfriamientoSimulado());
        System.out.println("Máximo encontrado: " + max);
        System.out.println("-----------------------------------");
        
        System.out.println("------------ EJERCICIO 2 ---------");
        int n = 100;
        int capacidad = 180;
        int[] elementos = new int[n];
        for (int i = 0; i < n; i++) {
            int r;
            do {
                r = (int) (Math.random() * 100);
            } while (r < 1);
            elementos[i] = r;
        }
        Arrays.sort(elementos);
        int[] sol = Mochila.enfriamientoSimulado(elementos, n, capacidad);
        System.out.println("Tamaño mochila: " + 180);
        System.out.println("Cantidad de elementos: " + n);
        System.out.println("Total Peso encontrado: " + Mochila.calcularPeso(sol, elementos));
        System.out.println("Resultado: " + Arrays.toString(elementos));
        System.out.println("Resultado: " + Arrays.toString(sol));
        System.out.println("-----------------------------------");
    }

    

    

}
