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

public class Radar_sensor{
    
    int WIDTH = 1500, HEIGHT = 625;
    
    private static final Object key = new Object();
    ArrayList<String>listAircraft = new ArrayList<>();
    //ArrayList<ArrayList<String>> listAircraft = new ArrayList<>();
    String[] information = {"id","name","pos_x","pos_y","pos_z","cap","accl_vx","accl_vy","accl_vz","alt","important_notice"};
    String[][] t = new String [10][information.length];
    JTable table;
    JFrame frame;
    JPanel panel;
    JButton close;
    
    int index = 0;
    
    public Radar_sensor(){
        frame = new JFrame ("Radar");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       
        close= new JButton ("close");
        close.addActionListener((ActionEvent e) -> {
           System.exit(0);
        });
      
        table = new JTable(t,information);
        table.setBackground(Color.WHITE);
        table.setRowHeight(25);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(850,273));
        panel = new JPanel();
        panel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
        panel.setBackground (Color.white);
        panel.add(pane);
        panel.add(close);
        frame.getContentPane().add (panel);
        frame.pack(); 
        frame.setVisible(true);
       
      /*  for(int i=0;i<information.length;i++){
            table.setValueAt(information[i], 0, i);
        }*/
    }
    
    
    void WriteResult(String id,String name,String pos_x,String pos_y,String pos_z,String accl_vx,String accl_vy,String accl_vz,String cap,String alt,String important_notice){
        synchronized (key) {
            boolean found =false;
            for (int i=0;i<listAircraft.size();i++){
                if(listAircraft.get(i).equals(id)){
                   /* listAircraft.get(i).add(1, name);
                    listAircraft.get(i).add(2, pos_x);
                    listAircraft.get(i).add(3, pos_y);
                    listAircraft.get(i).add(4, pos_z);
                    listAircraft.get(i).add(5, cap);
                    listAircraft.get(i).add(6, accl_vx);
                    listAircraft.get(i).add(7, accl_vy);
                    listAircraft.get(i).add(8, accl_vz);
                    listAircraft.get(i).add(9, alt);
                    listAircraft.get(i).add(10, important_notice);*/
                    
                    table.setValueAt(name, i, 1);
                    table.setValueAt(pos_x, i, 2);
                    table.setValueAt(pos_y, i, 3);
                    table.setValueAt(pos_z, i, 4);
                    table.setValueAt(cap, i, 5);
                    table.setValueAt(accl_vx, i, 6);
                    table.setValueAt(accl_vy, i, 7);
                    table.setValueAt(accl_vz, i, 8);
                    table.setValueAt(alt, i, 9);
                    table.setValueAt(important_notice, i, 10);
      
                    found=true;
                    break;
                }
            }
            if(found ==false){
                listAircraft.add(id);
                table.setValueAt(id, index, 0);
                table.setValueAt(name, index, 1);
                table.setValueAt(pos_x, index, 2);
                table.setValueAt(pos_y, index, 3);
                table.setValueAt(pos_z, index, 4);
                table.setValueAt(cap, index, 5);
                table.setValueAt(accl_vx, index, 6);
                table.setValueAt(accl_vy, index, 7);
                table.setValueAt(accl_vz, index, 8);
                table.setValueAt(alt, index, 9);
                table.setValueAt(important_notice, index, 10);
                index++;
                /*ArrayList <String> a = new ArrayList<>();
                a.add(id);
                a.add(name);
                a.add(pos_x);
                a.add(pos_y);
                a.add(pos_z);
                a.add(cap);
                a.add(accl_vx);
                a.add(accl_vy);
                a.add(accl_vz);
                a.add(alt);
                a.add(important_notice);

                listAircraft.add(a);*/
            }

          /* for(int i=0;i<listAircraft.size();i++){
               for(int j=0;j<information.length;j++){
                   System.out.println(information[j] + " : " + listAircraft.get(i).get(j));
               }
               System.out.println("------------------------------------------");
           }
            System.out.println();
            System.out.println();*/
        }
    }
}
