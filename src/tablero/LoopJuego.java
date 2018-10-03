/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer {
private GraphicsContext gc;
private Carro carro;
private Image fondo;
private Image gatito;
private int noGatito=0;   
private int Contador=0;
private Image ovni;
public LoopJuego(GraphicsContext gc) {
        this.gc = gc;
        this.carro = new Carro(0,200);
        this.fondo=new Image("Images/fondo.png");
        this.gatito=new Image("Images/cats.gif");
        this.ovni=new Image("Images/ufo_1.png");
}

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
  
@Override
    public void handle(long now) {
       
        
        gc.clearRect(0, 0, 1024, 512);
        gc.drawImage(fondo,0, 0);
        gc.setFill(Color.CHOCOLATE);
        gc.drawImage(this.gatito,132*(this.noGatito%6),0,132,80,this.carro.getX(),0,132,80);
        gc.drawImage(this.ovni,640,40);
        gc.strokeRect(640,40,40,40);
        gc.strokeRect(this.carro.getX()+15,20,100,55);
        this.carro.Mover();
        if((this.Contador%3)==0){
        this.noGatito+=1;
    }
        Shape sGatito=new Rectangle(this.carro.getX()+15,20,100,55);
    Shape sUfo=new Rectangle(640,40,40,40);
    Shape interseccion =SVGPath.intersect(sGatito,sUfo);    
    if(interseccion.getBoundsInLocal().getWidth()!=-1){
        stop();
    }
    
    Contador+=1;
    
    if(this.carro.getX()>1024){
        this.carro.setX(0);
    }
}
}