package main;

/**
 *
 * @author Quini_Dev
 */
public class Util {

    public static void permuta(int[] sVecino, int n) {
        if (sVecino[n] == 1) {
            sVecino[n] = 0;
        } else {
            sVecino[n] = 1;
        }
    }

    public static int binaryToDecimal(int[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                n += Math.pow(2, i);
            }
        }
        return n;
    }
}
