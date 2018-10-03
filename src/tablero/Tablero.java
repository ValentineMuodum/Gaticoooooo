/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class Tablero extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

Pane panel=new Pane();
Canvas canvas=new Canvas(1024,512);        
GraphicsContext gc=canvas.getGraphicsContext2D();



panel.getChildren().add(canvas);
Scene scene=new Scene(panel,1024,512,Color.DEEPSKYBLUE);

primaryStage.setTitle("Ejemplo Canvas");
primaryStage.setScene(scene);
primaryStage.show();
    /*gc.setFill(Color.CHOCOLATE); 
    gc.fillRect(30, 30, 80, 80);
   gc.setFill(Color.DARKKHAKI);
    gc.fillOval(30, 30, 80, 80);
    gc.strokeLine(0, 0, 300, 300);
double xpoints[]={10,20,30};
double ypoints[]={30,15,30};
gc.strokePolygon(xpoints, ypoints, xpoints.length);
*/
LoopJuego loopjuego=new LoopJuego(gc);
loopjuego.start();


    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
