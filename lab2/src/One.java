import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();


        char[] strMas = str.toCharArray();

        System.out.println("");

        char[] strM = PodStr(strMas);
        for (int i = 0; i < strM.length; i++) {
            System.out.print(strM[i] +"");

        }


    }

    public static char[] PodStr(char[] c) {
        char[] mas = Arrays.copyOfRange(c, 0, c.length );
        int start = 0;
        int end = 0;

        for (int i = 1; i <= mas.length; i++) {
            int count = 0;
            int tmp = 0;

            while (count + i <= mas.length) {
               for (int j = count; j < count+i; j++){
                   for (int z = j+1; z < count+i; z++){
                       if (mas[j]==mas[z]){
                           tmp =1;
                           z = count+i;
                           j = count+i;
                       }
                   }
               }
               if (tmp == 0){
                   start = count;
                   end = count+i;

               }
               tmp =0;
               count++;
            }


        }

        char[] m = Arrays.copyOfRange(mas, start, end);
        return m;
    }
}



