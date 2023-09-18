
import java.util.Scanner;

public class Three
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int x_start = 0;
        int y_start = 0;
        int step_count = 0;
        int min = 0;

        while (true){
            String word = in.next();

            if (word.equalsIgnoreCase("стоп")){
                break;
            }

            step_count = in.nextInt();
            if (word.equalsIgnoreCase("запад")){
                x_start = x_start - step_count;
            }

            if (word.equalsIgnoreCase("восток")){
                x_start = x_start + step_count;
            }
            if (word.equalsIgnoreCase("север")){
                y_start = y_start + step_count;
            }
            if (word.equalsIgnoreCase("юг")){
                y_start = y_start - step_count;
            }

            if (x== x_start & y == y_start){

            } else{
                min++;
            }

        }
        System.out.println(min);

    }
}
