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

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;

public class Aircraft{
    double final_x,final_y,final_z;
    double capt,alt;
    double accl_vx,accl_vy,accl_vz;
    double posx,posy,posz;
    static final int TimeRange = 1500;
    static final String host= "localhost";
    static final int nbport = 500;
    static final int minimum_v = 150;
    int id; //numero du vol
    String name;
    String departure,arrival;
   
    
    public aircraft(int id,String name,String departure,String arrival, double final_x,double final_y,double final_z){
        this.id =id;
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.final_x = final_x;
        this.final_y = final_y;
        this.final_z = final_z;
        posx = 0;
        posy = 0;
        posz = 0;
        accl_vx = 0;
        accl_vy = 0;
        accl_vz = 0;
        capt = 0;
        alt = 0;
        
    }
    
    int modify(double accl_vx,double accl_vy,double accl_vz,double capt,double alt){
        this.accl_vx = accl_vx;
        this.accl_vy = accl_vy;
        this.accl_vz = accl_vz;
        this.capt = capt;
        this.alt = alt;
    
        
        double cosinus, sinus, tang;
        double dep_x, dep_y, dep_z;

        cosinus = Math.cos(capt * 2 * Math.PI / 360);
        sinus = Math.sin(capt * 2 * Math.PI / 360);
        tang = Math.tan(capt * 2 * Math.PI/360);

        
        dep_x = cosinus * accl_vx * 10 / minimum_v;
        dep_y = sinus * accl_vy * 10 / minimum_v;
        dep_z = tang * accl_vz * 10/ minimum_v;

        if ((dep_x > 0) && (dep_x < 1)) dep_x = 1;
        if ((dep_x < 0) && (dep_x > -1)) dep_x = -1;

        if ((dep_y > 0) && (dep_y < 1)) dep_y = 1;
        if ((dep_y < 0) && (dep_y > -1)) dep_y = -1;
        
        if ((dep_z > 0) && (dep_z < 1)) dep_z = 1;
        if ((dep_z < 0) && (dep_z > -1)) dep_z = -1;

        //printf(" x : %f y : %f\n", dep_x, dep_y);

        posx = posx + (int) dep_x;
        posy = posy + (int) dep_y;
        posz = posz + (int) dep_z;
       
        
        if((posx == final_x) && (posy == final_y) && (posz == final_z) ){
            //arrival a destination
            return -1;
        }
        return 0;
    }
    
    void analyse(Socket clientSocket){
        try{
            BufferedReader inFromSaca;
            try (PrintWriter outToSaca = new PrintWriter(clientSocket.getOutputStream())) {
                inFromSaca = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToSaca.println(id + "/" + name + "/" + final_x + "/" + final_y + "/" + final_z ); //evoie id/name/arrival
                outToSaca.flush();
                while(true){
                    String [] s = inFromSaca.readLine().split("/"); //vitesse/capt/alt
                    int res = modify(Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]),Double.parseDouble(s[3]),Double.parseDouble(s[4]));
                    if(res == -1){
                        outToSaca.println(posx + "/" + posy + "/" + posz + "/end");
                        outToSaca.flush();
                        break;
                    }
                    sleep(TimeRange);
                    
                    outToSaca.println(posx + "/" + posy + "/" + posz);
                    outToSaca.flush();
                }
            }
            inFromSaca.close();
        }catch(IOException | NumberFormatException | InterruptedException e){System.out.println("arret d'execution"); System.exit(0);}
    }
    
    public void start ()throws Exception{
        
        try (Socket clientSocket = new Socket(host,nbport)) {
            analyse(clientSocket);
        }
   
    }   
    public void Destroy ()throws Exception{
        
        try (Socket clientSocket = new Socket(host,nbport)) {
            clientSocket.close();
        }
   
    }   
}
