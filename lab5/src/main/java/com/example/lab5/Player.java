package com.example.lab5;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private double p_x, p_y;
    private static final double WIDHT = 60;
    public static List<Bullet> bullets = new ArrayList<>();
    private boolean shooting = false, damage = false;
   private int p_hp =100;
    public Player(double x, double y){
        p_x =x;
        p_y = y;
    }
public void takeDamage(int dmg){
        if(damage){
            return;
        }
        p_hp = p_hp - dmg;
        damage = true;
        Game.shedule(150, ()->damage = false);
}
    public void render (GraphicsContext gc){

        gc.drawImage(Game.playerImg, p_x, p_y, WIDHT, WIDHT);
        for (int i=0; i<bullets.size();i++){
            bullets.get(i).render(gc);
        }
    }
public double getX(){
        return p_x;
}
    public double getY(){
        return p_y;
    }
    public double getHP(){
        return p_hp;
    }
    public void move(double x, double y){
        p_x = p_x + x;
        p_y= p_y+y;
    }

    public void shoot(double x, double y){
        if (shooting){
            return;
        }
        shooting = true;
        Game.shedule(500, ()->shooting = false);
        double angle = Math.atan2(y - p_y, x -p_x );
        Bullet b = new Bullet(angle, p_x, p_y);
        if (p_hp >0) {
            bullets.add(b);
        }
    }
}
