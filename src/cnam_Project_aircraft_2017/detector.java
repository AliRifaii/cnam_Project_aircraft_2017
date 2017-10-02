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
public class detector {
    
    double final_x,final_y,final_z;

    
    String GetPosition( double posx, double posy, double posz, double capt, double alt){
        
        return (modify(posx, posy, posz, capt, alt));
    }
    
    String GetPosition( double final_x,double final_y, double final_z,double posx, double posy, double posz, double capt, double alt){
       this.final_x = final_x;
       this.final_y = final_y;
       this.final_z = final_z;
       return (modify(posx, posy, posz, capt, alt));
    }
     
    String modify(double posx, double posy, double posz, double capt, double alt){
        
       String result = (Math.random()*100) + "/" + (Math.random()*100) + "/" +  (Math.random()*100) + "/" + (Math.random()*100) + "/" + (Math.random()*100) ;

       return result; 
    }
    
}
