import java.util.Scanner;

public class One
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int count = 0;

        while (a > 1){
            if (a%2 == 0){
                a = a/2;
            }
            else {
                a = 3*a + 1;
            }
            count = count + 1;
        }
        System.out.println(count);
    }
}




