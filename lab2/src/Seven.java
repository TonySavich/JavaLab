import java.util.Random;

public class Seven {

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
int[] mas = MaxEl(matrix);
for (int i = 0; i< mas.length; i++){
    System.out.print(mas[i] + " ");
}

    }

    public static int[] MaxEl(int[][] mas) {

        int a = mas.length;
        int b = mas[0].length;
        int[] tmp = new int[a];

        for (int i = 0; i<a; i++){
            int max = -9999;
            for (int j =0; j<b; j++){
if (max < mas[i][j]){
    max = mas[i][j];
}

            }
            tmp[i] = max;
        }


        return tmp;
    }
}
