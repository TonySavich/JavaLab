import java.util.Arrays;
import java.util.Random;

public class Two {

    public static void main(String[] args) {
        int a = 10;

        int[] mas = new int[a];
        Random rand = new Random();
        for (int i = 0; i < a; i++) {

            mas[i] = rand.nextInt(100) + 1;

            System.out.print(mas[i] + " ");
        }

        System.out.println("");
        int b = 7;
        int[] masTwo = new int[b];
        for (int i = 0; i < b; i++) {

            masTwo[i] = rand.nextInt(100) + 1;

            System.out.print(masTwo[i] + " ");
        }
        System.out.println("");
        System.out.println("");

        int[] c = Unity(SimpleSort(mas), SimpleSort(masTwo));
        for (int i = 0; i < a + b; i++) {

            System.out.print(c[i] + " ");
        }

    }

    public static int[] SimpleSort(int[] mas) {
        int[] dop = Arrays.copyOfRange(mas, 0, mas.length);
        for (int i = 0; i < dop.length; i++) {
            for (int j = i + 1; j < dop.length; j++) {
                if (dop[i] > dop[j]) {
                    int tmp = dop[i];
                    dop[i] = dop[j];
                    dop[j] = tmp;
                }
            }
        }
        return dop;
    }

    public static int[] Unity(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int count = 0;

        while ((i < a.length) || (j < b.length)) {

            if (i < a.length && j < b.length) {

                if (a[i] > b[j]) {
                    c[count] = b[j];
                    j++;
                    count++;
                } else if (a[i] < b[j]) {
                    c[count] = a[i];
                    i++;
                    count++;
                } else {
                    c[count] = a[i];
                    count++;
                    c[count] = b[j];
                    count++;
                    i++;
                    j++;
                }


            } else {
                if (i >= a.length) {
                    c[count] = b[j];
                    j++;
                    count++;
                } else {
                    c[count] = a[i];
                    i++;
                    count++;
                }
            }



        }
        return c;
    }

}
