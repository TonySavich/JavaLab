import java.util.Scanner;

public class Four
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count_road = in.nextInt();
        int count_road2 = count_road;

        int maxR = 0;
        int maxH = 0;


        while (count_road > 0){
            int count_tunnel = in.nextInt();
            int tmp = 1000;

            while (count_tunnel > 0){
                int heightB = in.nextInt();
                if (heightB < tmp){
                    tmp = heightB;
                }
                count_tunnel = count_tunnel - 1;
            }

            if (maxH < tmp){
                maxH = tmp;
                maxR = count_road2 - count_road + 1;
            }

            count_road--;
        }
        System.out.println("\n");
        System.out.print(maxR + " " + maxH);
    }
}
