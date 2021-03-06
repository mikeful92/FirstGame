/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Mike
 */
public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        
        //velX = r.nextInt(5) + 1;
        //velY = r.nextInt(5) + 1;
        
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, 32,32);
    }
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp( x, 0, Game.WIDTH-37);
        y = Game.clamp( y, 0, Game.HEIGHT-60);
        
        //handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
        
        collision();
                
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler. object. get(i);
            
            if(tempObject.getID() == ID. BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        if(id== ID.Player) g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }
    
    
    
}
