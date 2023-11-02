import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static class Zal {
        public int  [][] seats;

        public String name;
        public Zal(String y){
            this.name =y;
        }
        public void Create (int x, int y){
            this.seats = new int [x][y];
            for (int i =0; i<x; i++){
                for (int j =0;j<y;j++){
                    this.seats[i][j]=1;
                }
            }
        }

        public void Form (){
            Scanner console = new Scanner(System.in);
            System.out.println("Введите расположение мест в следювиде: " );
            System.out.println("0 1 0" );
            System.out.println("1 1 1" );
            System.out.println("1 1 1" );
            System.out.println("1 - есть место" );
            System.out.println("2 - места не существует" );

            int x =seats.length;
            int y = seats[0].length;
            for (int i = 0; i<x; i++){
                for (int j = 0; j<y; j++){
                    seats[i][j] = console.nextInt();
                    if (seats[i][j] == 0){

                    } else{
                        seats[i][j] = 1;
                    }
                }

            }
        }
    }

    public static class Kinotheatr {

        ArrayList<Zal> z = new ArrayList<>();
        public String name;

        public Kinotheatr(String k) {

            this.name = k;

        }

        public void Add (String k, int x, int y){
            Scanner console = new Scanner(System.in);
            Zal zz = new Zal(k);
            //System.out.println("Введите количество рядов и столбцов: " );
            zz.Create(x, y);

            System.out.println("1. Если места расположенны прямоугольно: " );
            System.out.println("2. Если места расположенны иначе: " );
            int yy = console.nextInt();
            if (yy == 2) {
                zz.Form();
            }
            this.z.add(zz);
        }
    }


    public static class Film {
        String name;
        int lng;

        public Film (String name, int lng){
            this.name= name;
            this.lng = lng;
        }
    }

    public static class Rasp {
        public Film film;
       public  Kinotheatr kz;
public int day;
       public Zal z;

       public int bg;

       public int end;
public int[][] mest ;
        public Rasp (Film film, Kinotheatr kz, Zal z, int b, int d){
            this.film = film;
            this.day = d;
            this.kz = kz;
            this.z = z;
            this.bg = b;
            this.end = film.lng + b;
            if (this.end >=24){
                this.end = film.lng -24;
            }
mest = z.seats;


        }
    }





    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Film> film = new ArrayList<>();
        ArrayList<Kinotheatr> kinoth = new ArrayList<>();
        Rasp[] raspisanie = new Rasp[200];
        int razm = 0;

      Film trtr = new Film("Transformers", 1);
      Film dkdk = new Film ("Dark knight", 2);
      Kinotheatr ktkt = new Kinotheatr("CinemaMax");
      Kinotheatr jiji = new Kinotheatr("LostFilm");
      film.add(trtr);
      film.add(dkdk);
      kinoth.add(ktkt);
      kinoth.add(jiji);
      Zal zizi = new Zal("Imax");
      zizi.seats = new int[3][3];
        for (int i =0; i<3; i++){
            for (int j =0;j<3;j++){
               zizi.seats[i][j]=1;
            }
        }
      ktkt.z.add(zizi);
        Zal ziziz = new Zal("3d");
        ziziz.seats = new int[3][3];
        for (int i =0; i<3; i++){
            for (int j =0;j<3;j++){
                ziziz.seats[i][j]=1;
            }
        }
        jiji.z.add(ziziz);


        Zal zizizz = new Zal("4d");
        zizizz.seats = new int[3][3];
        for (int i =0; i<3; i++){
            for (int j =0;j<3;j++){
                zizizz.seats[i][j]=1;
            }
        }
        jiji.z.add(zizizz);
raspisanie[razm] = new Rasp(trtr, ktkt, zizi, 12 , 3);
razm++;
        raspisanie[razm] = new Rasp(dkdk, ktkt, zizi, 10 , 4);
        razm++;
        raspisanie[razm] = new Rasp(trtr, jiji, ziziz, 14 , 7);
        razm++;
        raspisanie[razm] = new Rasp(dkdk, jiji, zizizz, 19 , 3);
        razm++;


        String y;
        int x;
        while (true) {
            System.out.println("1. Администратор");
            System.out.println("2. Пользователь");
            System.out.println("3. Выйти");
            x = console.nextInt();



            if (x == 1) {
                while (true) {
                    System.out.println("(Все изменения желательно потом добавить в расписание)");
                    System.out.println("1. Добавить фильм");
                    System.out.println("2. Добавить кинотеатр");
                    System.out.println("3. Добавить зал");
                    System.out.println("4. Изменить расписание");
                    System.out.println("5. Выйти");

                    x = console.nextInt();
                    if (x == 1) {
                        System.out.println("Введите название: ");
                        y = console.next();
                        System.out.println("Введите продолжительность (в часах): ");
                        x = console.nextInt();
                        Film ff = new Film(y, x);
                        film.add(ff);

                    } else if (x == 2) {
                        System.out.println("Введите название кинотеатра: ");
                        y = console.next();

                        Kinotheatr f = new Kinotheatr(y);
                        kinoth.add(f);
                        System.out.println("1.Добавить зал: ");
                        System.out.println("2.Закончить: ");
                        x = console.nextInt();
                        while (x == 1) {
                            System.out.println("Введите название, число рядов и столбцов: ");
                            y = console.next();
                            x = console.nextInt();
                            int ui = console.nextInt();
                            f.Add(y, x, ui);
                            System.out.println("Добавить еще зал?: ");
                            System.out.println("1. Да: ");
                            System.out.println("2. Нет: ");
                            x = console.nextInt();
                        }
                    } else if (x == 3) {
                        System.out.println("Выберите кинотеатр, для которого хотите добавить зал: ");
                        for (int i = 0; i < kinoth.size(); i++) {
                            System.out.println((i + 1) + ". " + kinoth.get(i).name);
                        }
                        x = console.nextInt();
                        int jj = x - 1;
                        do {
                            System.out.println("Введите название, число рядов и столбцов: ");
                            y = console.next();
                            x = console.nextInt();
                            int ui = console.nextInt();
                            kinoth.get(jj).Add(y, x, ui);
                            System.out.println("Добавить еще зал?: ");
                            System.out.println("1. Да: ");
                            System.out.println("2. Нет: ");
                            x = console.nextInt();

                        } while (x == 1);

                    } else if (x == 4) {

                        do {

                            System.out.println("Выберите кинотеатр: ");
                            for (int i = 0; i < kinoth.size(); i++) {
                                System.out.println((i + 1) + ". " + kinoth.get(i).name);
                            }
                            int ui = console.nextInt();
                            Kinotheatr kkk = kinoth.get(ui-1);
                            System.out.println("Выберите зал: ");
                            for (int i = 0; i < kinoth.get(ui - 1).z.size(); i++) {
                                System.out.println((i + 1) + ". " + kinoth.get(ui - 1).z.get(i).name);
                            }
                            int uii = console.nextInt();
Zal zzz = kinoth.get(ui - 1).z.get(uii - 1);
                            System.out.println("Выберите фильм: ");
                            for (int i = 0; i < film.size(); i++) {
                                System.out.println((i + 1) + ". " + film.get(i).name);
                            }
                            int uiii = console.nextInt();
Film fff = film.get(uiii-1);

                            System.out.println("Выберите день и время: ");
                            int day = console.nextInt();
                            int time = console.nextInt();
                            raspisanie[razm] = new Rasp(fff, kkk, zzz, time, day);
                            razm++;
                            System.out.println("1. Добавить еще изменение: ");
                            System.out.println("2. Закончить: ");
                            x = console.nextInt();
                        } while (x == 1);
                    } else if (x == 5) {
                        break;
                    }

                }
            }else if (x ==2){

while (true) {

    System.out.println("1. Выбрать фильм");
    System.out.println("2. Выбрать кинотеатр");
    System.out.println("3. Выйти");
    x = console.nextInt();
    if (x == 1){
        for (int i = 0; i < film.size(); i++) {
            System.out.println((i + 1) + ". " + film.get(i).name);
        }
        x = console.nextInt();
        System.out.println("Выберите кинотеатр и зал, в котором показывают фильм");
        for (int i = 0; i < razm; i++) {
            if (film.get(x-1) == raspisanie[i].film) {
                System.out.println((i + 1) + ". " + raspisanie[i].kz.name + " " + raspisanie[i].z.name + " " + raspisanie[i].day + " ноября время "+ raspisanie[i].bg + "-"+raspisanie[i].end);
            }
        }
        x = console.nextInt();
        System.out.println("Выберете место в зале (ряд, столбец)");
        System.out.println("(Например, 1 2)");
        System.out.println("1 - место свободно");
        System.out.println("2 - место занято");
        System.out.println("0 - отсутствует");

        for (int i = 0; i <raspisanie[x-1].z.seats.length; i++){
            for (int j =0; j < raspisanie[x-1].z.seats[0].length;j++){
                System.out.print(raspisanie[x-1].z.seats[i][j]+ " ");
            }
            System.out.println();
        }
int k = console.nextInt();
        int p = console.nextInt();
        if (raspisanie[x-1].z.seats[k-1][p-1]==1){
            raspisanie[x-1].z.seats[k-1][p-1] = 2;
            System.out.println("Вы успешно купили место");
        } else {
            System.out.println("Место недоступно");
        }

    }
    else if (x == 2){
        System.out.println("Выберите кинотеатр: ");
        for (int i = 0; i < kinoth.size(); i++) {
            System.out.println((i + 1) + ". " + kinoth.get(i).name);
        }
        x = console.nextInt();

        System.out.println("Выберете сеанс : ");


        for (int i = 0; i < razm; i++) {
            if (kinoth.get(x-1) == raspisanie[i].kz) {
                System.out.println((i + 1) + ". " + raspisanie[i].film.name + " " + raspisanie[i].z.name + " " + raspisanie[i].day + " ноября время "+ raspisanie[i].bg + "-"+raspisanie[i].end);
            }
        }

        x = console.nextInt();
        System.out.println("Выберете место в зале (ряд, столбец)");
        System.out.println("(Например, 1 2)");
        System.out.println("1 - место свободно");
        System.out.println("2 - место занято");
        System.out.println("0 - отсутствует");

        for (int i = 0; i <raspisanie[x-1].z.seats.length; i++){
            for (int j =0; j < raspisanie[x-1].z.seats[0].length;j++){
                System.out.print(raspisanie[x-1].z.seats[i][j]+ " ");
            }
            System.out.println();
        }
        int k = console.nextInt();
        int p = console.nextInt();
        if (raspisanie[x-1].z.seats[k-1][p-1]==1){
            raspisanie[x-1].z.seats[k-1][p-1] = 2;
            System.out.println("Вы успешно купили место");
        } else {
            System.out.println("Место недоступно");
        }





    } else if (x == 3){
        break;
    }

}
            }
            else if (x==3){
                break;
            }
        }
    }
}