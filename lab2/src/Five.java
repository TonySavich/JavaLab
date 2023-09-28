import java.util.Random;
import java.util.Scanner;

public class Five {



    public static void main(String[] args) {
        int a = 15;

        int [] mas = new int[a];
        Random rand = new Random();
        for (int i = 0; i <a; i++){
                mas[i] = rand.nextInt(10) + 1;
                System.out.print(mas[i] + " ");
            }
            System.out.println("");
        int target;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        target = scanner.nextInt();
        System.out.println("");

        int[] m = Poisk(mas, target);

            for (int i = 0; i < m.length; i++) {
                System.out.print(m[i] + " ");
            }


    }

    public static int[] Poisk(int[] mas, int target) {
        int[] a = new int[2];
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i] + mas[j] == target) {
                   a[0] = mas[i];
                   a[1] = mas[j];
                   return a;
                }
            }
        }
return a;
    }




}
