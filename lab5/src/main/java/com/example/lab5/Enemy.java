package com.example.lab5;

import javafx.scene.canvas.GraphicsContext;

public class Enemy {
    private double p_x, p_y;
    public static final double WIDHT = 50;
    private Player p_player;
    private static final  double SPEED = 3.5;
    public Enemy(Player p, double x, double y){
        p_player =p;
        p_x = x;
        p_y =y;
    }
private boolean checkCollision(){
    for (int i = 0; i< Game.enemies.size(); i++){
        Enemy e = Game.enemies.get(i);
        if (e != this){
if(e.collided(p_x, p_y, WIDHT, WIDHT)){
    return  true;
}
        }
    }
    return false;
}

public boolean collided(double x, double y, double w1, double w2){
        if (Math.sqrt(Math.pow(p_x + w1/2 - x - w2/2, 2)  + Math.pow(p_y + w1/2 - y - w2/2, 2)) <=w1/2 + w2/2){
            return true;
    }
    return false;
}
    public void render(GraphicsContext gc){
        gc.drawImage(Game.batImg, p_x, p_y, WIDHT, WIDHT);
            double distance = Math.sqrt(Math.pow(p_x - p_player.getX(), 2) + Math.pow(p_y - p_player.getY(), 2));
            if (distance <= 40) {
                p_player.takeDamage(5);
            } else {
                double angle = Math.atan2(p_player.getY() - p_y, p_player.getX() - p_x);
                p_x = p_x + Math.cos(angle) * SPEED;
                if (checkCollision()) {
                    p_x = p_x - Math.cos(angle) * SPEED;
                }
                p_y = p_y + Math.sin(angle) * SPEED;
                if (checkCollision()) {
                    p_y = p_y - Math.sin(angle) * SPEED;
                }

        }
        }

}
