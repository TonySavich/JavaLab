import java.util.Scanner;

public class Five
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (Twice(a) == true){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }



    static boolean Twice ( int a){
        if (Sum(a) == true & Mult(a) == true){
            return true;
        }
        else {
            return false;
        }
    }

    static boolean Sum ( int a){
        int b = (a% 10) + (a/100) + ((a/10)%10);
        if (b% 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    static boolean Mult (int a){
        int b = (a% 10) * (a/100) * ((a/10)%10);
        if (b% 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
