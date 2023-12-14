package com.example.lab5;

import javafx.animation.Timeline;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


import java.util.*;


public class Game {
    private static final int HEIGHT = 600;
    private static final int WIDTH= 600;
    private Player player;
    private static final double SPEED = 3;
    private Map<KeyCode, Boolean> keys = new HashMap<>();
    public Font font = new Font( "file:///C:\\Users\\admin\\Desktop\\javaLabs\\lab5\\src\\main\\java\\com\\example\\lab5\\ac\\fette-unz-fraktur.ttf",30);

    public static List<Enemy> enemies = new ArrayList<>();
private int score =0;

public static Image playerImg = new Image("file:///C:\\Users\\admin\\Desktop\\javaLabs\\lab5\\src\\main\\java\\com\\example\\lab5\\ac\\mage.png");
    public static Image batImg = new Image("file:///C:\\Users\\admin\\Desktop\\javaLabs\\lab5\\src\\main\\java\\com\\example\\lab5\\ac\\bat.png");
    public static Image fireImg = new Image("file:///C:\\Users\\admin\\Desktop\\javaLabs\\lab5\\src\\main\\java\\com\\example\\lab5\\ac\\fire.png");
    public static Image grassImg = new Image("file:///C:\\Users\\admin\\Desktop\\javaLabs\\lab5\\src\\main\\java\\com\\example\\lab5\\ac\\grass.jpg");



    public static void shedule(long time, Runnable r){
        new Thread(() ->{
            try{
                Thread.sleep(time);
                r.run();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
    }).start();}


    Game(Stage stage){
        stage.setTitle("Cool Game");
        Button exit = new Button("Exit");
            StackPane pane = new StackPane();
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            canvas.setFocusTraversable(true);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            pane.getChildren().add(canvas);
        exit.setPrefSize(80, 30);
        pane.getChildren().add(exit);
        pane.setAlignment(exit, Pos.BOTTOM_RIGHT);
        player = new Player(50, 50);

exit.setOnAction(actionEvent -> {
    stage.close();
});

            Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0 / 60), e -> update(gc)));
            loop.setCycleCount(Animation.INDEFINITE);
            loop.play();

            spawnEnemies();
        if (player.getHP()>0) {
            canvas.setOnKeyPressed(e -> keys.put(e.getCode(), true));
            canvas.setOnKeyReleased(e -> keys.put(e.getCode(), false));
                canvas.setOnMousePressed(e -> player.shoot(e.getX(), e.getY()));
            }

            Scene scene = new Scene(pane, WIDTH, HEIGHT);
            stage.setScene(scene);
            stage.show();

    }


private void spawnEnemies() {
    if (player.getHP() > 0) {
        Thread spawner = new Thread(() -> {
            try {

                Random r = new Random();
                double x = r.nextDouble() * WIDTH;
                double y = r.nextDouble() * HEIGHT;
                while (true) {
                    enemies.add(new Enemy(player, x, y));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        spawner.setDaemon(true);
        spawner.start();
    }
}

    private void update(GraphicsContext gc){

       gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(grassImg, 0,0,WIDTH, HEIGHT);

           player.render(gc);
           for (int i = 0; i < enemies.size(); i++) {
               for (int j = 0; j < Player.bullets.size(); j++) {
                   if (enemies.get(i).collided(Player.bullets.get(j).getX(), Player.bullets.get(j).getY(), Enemy.WIDHT, Bullet.WIDHT)) {
                       Player.bullets.remove(j);
                       enemies.remove(i);
                       i++;
                       score++;
                       break;
                   }
               }
           }
           if (player.getHP() > 0) {
               for (int i = 0; i < enemies.size(); i++) {
                   enemies.get(i).render(gc);
               }
               if (keys.getOrDefault(KeyCode.W, false) && player.getY() > 0) {
                   player.move(0, -SPEED);
               }
               if (keys.getOrDefault(KeyCode.S, false) && player.getY() < 550) {
                   player.move(0, SPEED);
               }
               if (keys.getOrDefault(KeyCode.A, false) && player.getX() > 0) {
                   player.move(-SPEED, 0);
               }
               if (keys.getOrDefault(KeyCode.D, false) && player.getX() < 550) {
                   player.move(SPEED, 0);

               }
               gc.setFill(Color.BLACK);
               gc.setFont(font);
               gc.fillText("Score is: " + String.valueOf(score), 50, HEIGHT -50, 50);
           }else{
               gc.setFont(font);
               gc.setFill(Color.BLACK);
               gc.fillText("You Lose", WIDTH - 400, HEIGHT/2 - 30, 500);
               gc.fillText("Score is: " + String.valueOf(score), WIDTH - 400, HEIGHT/2, 500);


           }
        gc.setFill(Color.RED);
        gc.fillRect(player.getX() +10, player.getY(), 40*( player.getHP()/100.0), 2);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(player.getX() +10, player.getY(), 40, 2);


    }
}