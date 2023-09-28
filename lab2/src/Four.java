import java.util.Random;

public class Four {


    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int [][] matrix = new int[a][b];
        Random rand = new Random();
        for (int i = 0; i <a; i++){
            for (int j = 0; j <b; j++){
                matrix[i][j] = rand.nextInt(10) + 1;

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        int[][] mas = Rotate(matrix);

        for (int i = 0; i<mas.length; i++){
            for (int j =0; j<mas[0].length; j++){
                System.out.print(mas[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static int[][] Rotate(int[][] mas) {

        int a = mas.length;
        int b = mas[0].length;
        int[][] tmp = new int[b][a];

        for (int i = 0; i<a; i++){
            for (int j =0; j<b; j++){
                tmp[j][a - 1- i]= mas[i][j];
            }
        }


        return tmp;
    }




}
