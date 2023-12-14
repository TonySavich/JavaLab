package com.example.lab5;

import javafx.scene.canvas.GraphicsContext;

public class Bullet {
    private double p_angle, p_x, p_y;
    public static final double WIDHT = 20;
    private static final double SPEED = 6;

    public Bullet(double angle,double x,double y){
        p_x =x;
        p_y = y;
        p_angle  = angle;
    }
public double getX(){
        return p_x;
}

    public double getY(){
        return p_y;
    }
    public void render(GraphicsContext gc){
        gc.drawImage(Game.fireImg, p_x, p_y, WIDHT, WIDHT);
        p_x = p_x + Math.cos(p_angle) * SPEED;
        p_y = p_y + Math.sin(p_angle) * SPEED;
    }

}
