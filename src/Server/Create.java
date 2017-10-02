/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam_Project_aircraft_2017;

/**
 *
 * @author ALRI
 */

import cnam_Project_aircraft_2017v.Aircraft;
import java.awt.AWTException;
import java.sql.Connection;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class create extends Application {
    
    static HashMap<String,String> CreateDetails;
   
    static Connection conn ;
    @Override
    public void start(Stage primaryStage) throws AWTException {
        
        
        //==============declare variables and components
        CreateDetails=new HashMap<>();
       
        BorderPane root = new BorderPane();
        VBox vbox1=new VBox();
        BorderPane border1=new BorderPane();
        GridPane grid1=new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        HBox hbox1=new HBox();
        ImageView imgview1=new ImageView();
        ImageView imgview2=new ImageView();
        GridPane grid2=new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        Label nolbl=new Label("AirCraft Number");
        Label nomlbl=new Label("AirCraft Name");
        Label depbl=new Label("Departure");
        Label arrlbl=new Label("Arrival");
        Label xlbl=new Label("Position X");
        Label ylbl=new Label("Position Y");
        Label zlbl=new Label("Position Z");
        
        Label error=new Label("");
        error.setId("error");
        nolbl.setId("firstuse");
        nomlbl.setId("firstuse");
        depbl.setId("firstuse");
        arrlbl.setId("firstuse");
        xlbl.setId("firstuse");
        ylbl.setId("firstuse");
        zlbl.setId("firstuse");
        
        TextField notxt=new TextField();
        TextField nomtxt =new TextField();
        TextField deptxt =new TextField();
        TextField arrtxt =new TextField();
        TextField xtxt =new TextField();
        TextField ytxt =new TextField();
        TextField ztxt =new TextField();
        
        notxt.setPrefWidth(200);
        nomtxt.setPrefWidth(200);
        deptxt.setPrefWidth(200);
        arrtxt.setPrefWidth(200);
        xtxt.setPrefWidth(200);
        ytxt.setPrefWidth(200);
        ztxt.setPrefWidth(200);
        
        Button loginbtn=new Button("Login");
        loginbtn.setId("rich-blue");
        loginbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 AirCraft a = new AirCraft(Integer.parseInt(notxt.getText()),
                nomtxt.getText(),deptxt.getText(),arrtxt.getText(),
                Integer.parseInt(xtxt.getText()),Integer.parseInt(ytxt.getText()),
                        Integer.parseInt(ztxt.getText()));
       

 new Thread(() -> {
     try{
         a.start();
        
     }
     catch(Exception e){}
        }).start();
            }
        });
        //==============end declare variables and components
        //================assign items to parents
        root.setCenter(vbox1);
        vbox1.getChildren().add(border1);
        vbox1.getChildren().add(grid1);
        
        border1.setLeft(hbox1);
        border1.setRight(imgview1);
        hbox1.getChildren().add(imgview2);
        hbox1.getChildren().add(grid2);
        
        grid1.add(nolbl, 5, 3);
        grid1.add(nomlbl, 5, 4);
        grid1.add(depbl, 5, 5);
        grid1.add(arrlbl, 5, 6);
        grid1.add(xlbl, 5, 7);
        grid1.add(ylbl, 5, 8);
        grid1.add(zlbl, 5, 9);
        
        grid1.add(notxt, 6, 3);
        grid1.add(nomtxt, 6, 4);
         grid1.add(deptxt, 6, 5);
          grid1.add(arrtxt, 6, 6);
           grid1.add(xtxt, 6, 7);
            grid1.add(ytxt, 6, 8);
             grid1.add(ztxt, 6, 9);
             
        grid1.add(loginbtn, 5, 10);
        grid1.add(error, 6, 10);
        //================end assign items to parents
       
        
        
        Scene scene = new Scene(root, 500, 350);
        String cssURL = this.getClass().getResource("/style/main.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.setTitle("AirCraft");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    public boolean checkUserName(String usertext,String passtext){
        Boolean ResBool=true;
        return ResBool;
    }
}
