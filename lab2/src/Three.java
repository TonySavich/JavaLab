import java.util.Random;

public class Three {


    public static void main(String[] args) {
        int a = 10;

        int [] mas = new int[a];
        Random rand = new Random();
        for (int i = 0; i <a; i++){

            int k = rand.nextInt(2);
            if (k == 1) {
                mas[i] = rand.nextInt(10) + 1;
            }
            else{
                mas[i] = -(rand.nextInt(10) + 1);
            }
                System.out.print(mas[i] + " ");
            }


        System.out.println("");
        System.out.println("");

int[] masTwo = PodSum(mas);
int tmp =0;
for(int i =0; i < masTwo.length; i++){
    System.out.print(masTwo[i] + " ");
    tmp = tmp + masTwo[i];
}
        System.out.println("");
        System.out.println("Max sum is " + tmp);

    }

    public static int[] PodSum(int[] mas) {
        int max =-99999;
        int ii = 0;
        int jj = 0;
for (int i =0; i<mas.length;i++){
    int tmp = mas[i];
    if (tmp>max){
        max = tmp;
        ii = i;
        jj =i;
    }
    for (int j =i+1; j<mas.length;j++){
tmp = tmp + mas[j];
        if (tmp>max){
            max = tmp;
            ii = i;
            jj = j;
        }
    }
}

int[] dop = new int[jj-ii+1];
for (int i = ii; i <= jj; i++){
    dop[i-ii]= mas[i];
}
return dop;
    }



}
