package _03_polymorphs;

import java.awt.Graphics;

public abstract class Polymorph {
    int x;
    int y;
    int width;
    int height;
    
    Polymorph(int x, int y){
   	 this.x = x;
   	 this.y = y;
    }
    
    public int getX() {return x;}
    public void setX(int t) {x = t;}
    
    public int getY() {return y;}
    public void setY(int t) {y = t;}
    
    public int getWidth() {return width;}
    public void setWidth(int t) {width = t;}
    
    public int getHeight() {return height;}
    public void setHeight(int t) {height = t;}
    
    public void update(){
   	 
    }
    
    public abstract void draw(Graphics g);
}
