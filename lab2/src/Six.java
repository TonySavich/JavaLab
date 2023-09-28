import java.util.Random;

public class Six {

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


        System.out.println(Sum(matrix));

    }

    public static int Sum(int[][] mas) {
       int sum =0;

       int a = mas.length;
       int b = mas[0].length ;
        for (int i = 0; i <a; i++){
            for (int j = 0; j <b; j++){
                sum = sum +mas[i][j];
            }
        }
       return sum;
    }

}
