
import java.util.Scanner;


public class Two
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int a = 0;
        int b = -1;
        while (count > 0){
            int c = in.nextInt();
            b = -b;
            a = a + b*c;
            count = count -1;
        }
        System.out.println(a);
    }
}



