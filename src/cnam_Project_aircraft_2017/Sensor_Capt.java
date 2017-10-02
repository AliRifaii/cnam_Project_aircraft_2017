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
public class Sensor_Capt {
    
    static final int nbport = 350;
    Radar_sensor radar;
    private static final Object key = new Object();
    
    public Sensor_Capt(Radar_sensor radar){
        this.radar = radar;
    }
    
    void traitement(Socket connectionSocket){
        
        String Results; 
        String []s;
        detection c = new detection();
        try{
       
            BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outToClient =new PrintWriter(connectionSocket.getOutputStream()); 

            s = inFromClient.readLine().split("/"); 


                radar.afficher(s[0], s[1], "0", "0", "0", "0", "0", "0", "0", "0","Depart");
                Results = c.calculPosition(Double.parseDouble(s[2]),Double.parseDouble(s[3]),Double.parseDouble(s[4]),0,0,0,0,0);


            while (true){

                outToClient.println(Results);
                outToClient.flush();

                String [] position = inFromClient.readLine().split("/");;
                String [] res = Results.split("/");
                if((position.length >= 4)&&(position[3].equals("end"))){
                    radar.afficher(s[0], s[1], position[0], position[1],position[2], res[0], res[1], res[2], res[3], res[4],"Arrivee");
                    inFromClient.close();
                    outToClient.close();
                    connectionSocket.close();
                }
                else{

                        radar.afficher(s[0], s[1], position[0], position[1],position[2], res[0], res[1], res[2], res[3], res[4],"-");
                        Results = c.calculPosition(Double.parseDouble(position[0]), Double.parseDouble(position[1]),Double.parseDouble(position[2]),Double.parseDouble(res[3]), Double.parseDouble(res[4]));

                }

            }
        }catch(IOException | NumberFormatException e){System.out.println("arret d'execution"); System.exit(0);}
    }
    
    public void start ()throws Exception{
        
        ServerSocket welcomeSocket = new ServerSocket(nbport);

        while (true) {
        Socket connectionSocket = welcomeSocket.accept();
        
        new Thread(() -> {
            try{
                traitement(connectionSocket);
            }
            catch(Exception e){}
        }).start();
        
        }
    }
}
