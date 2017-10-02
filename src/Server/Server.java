 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam_Project_aircraft_2017;

/**
 *
 * @author ALRI
 */
import cnam_Project_aircraft_2017.Radar_sensor;
import avion_accov.Sensor_Capt;

public class Server {
   
    public static void main(String args[]) throws Exception{
        Radar_sensor first_radar = new Radar_sensor();
        Sensor_Capt first_test = new Sensor_Capt(first_radar);
         first_test.start();
    }
    
    
}
