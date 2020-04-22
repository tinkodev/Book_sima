/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_sima;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tinkd
 */
public class Kolcson_lista implements Serializable{
    public List<Kolcsonzes> kolcson;
    
    public Kolcson_lista(){
        kolcson = new ArrayList<Kolcsonzes>();
    } 
    
public void hozzaad(Kolcsonzes kivett){
        kolcson.add(kivett);
    }
 public Boolean torol(String ID){
        for(Kolcsonzes kivett : kolcson){
            if(kivett.getID().equals(ID)){
                kolcson.remove(kivett);
            return true;
            }       
        }
        return false;
    }
 public void Listazas(){
        for(Kolcsonzes kivett : kolcson)  
        System.out.println(kivett.toString());
    }
 public Boolean Mentes(){
     
try{
            FileOutputStream file = new FileOutputStream("kolcson.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(kolcson);
            
            out.close();
            file.close();
            
        //    return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    }
 public Boolean KolcsonListaBetoltes(){
        try{
            FileInputStream file = new FileInputStream("kolcson.txt");
            ObjectInputStream out2 = new ObjectInputStream(file);
            kolcson = (List<Kolcsonzes>) out2.readObject();
            for(Kolcsonzes kolcs : kolcson){
            System.out.println(kolcs.konvy.getCim());
            System.out.println(kolcs.user.getNev()); 
            } 
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
 
        }
 public int meret(){
    return kolcson.size();
    }
 public void removeSelectedFromTable(JTable from)
{
    int[] rows = from.getSelectedRows();
    TableModel tm= from.getModel();

    while(rows.length>0)
    {
        ((DefaultTableModel)tm).removeRow(from.convertRowIndexToModel(rows[0]));

        rows = from.getSelectedRows();
    }
    from.clearSelection();
}
 public  Kolcsonzes keres(String ID){
        for(Kolcsonzes kolcs : kolcson){
            if(kolcs.getID().equals(ID))
                return kolcs;  
        }
        return null;
    }
}