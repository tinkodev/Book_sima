/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_sima;

/**
 *
 * @author tinkd
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Exodia
 */
public class Felhasznalo_lista implements  Serializable{
    private List<Felhasznalo> userList;
    
    public Felhasznalo_lista(){
        userList = new ArrayList<Felhasznalo>();
    }
    
     public Felhasznalo keres(String ID){
         
             for(Felhasznalo user : userList){
            if(user.getCNP().equals(ID))
                return user;
            
        }
        return null;
    }
     public void hozzaad(Felhasznalo user){
        userList.add(user);
    }
     public Boolean torol(String ID){
        for(Felhasznalo user : userList){
            if(user.getCNP().equals(ID)){
                userList.remove(user);
            return true;
        }
        }
        return false;
     }
     
     public Boolean modosit(String CNP, Felhasznalo user){
         for(Felhasznalo u: userList){
             if(u.getCNP().equals(CNP) ){
                 u.setNev(user.getNev());
                 u.setElerhetoseg(user.getElerhetoseg());
                 return true;
             }
         }
         return false;
     }
     public void kiListaz(){
        for(Felhasznalo user : userList)
            
        System.out.println(user.toString());
     }
     public Boolean userListMentese(){
        String filename = "users.txt";
        //Konyv object = konyvek.get(0);
        
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(userList);
            
            out.close();
            file.close();
        //    return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    }
    public Boolean userListBetoltese(){
        String filename = "users.txt";
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream out2 = new ObjectInputStream(file);
            //ObjectOutputStream out = new ObjectOutputStream(file);
            List<Felhasznalo> ujLista = new ArrayList<Felhasznalo>();
            ujLista = (List<Felhasznalo>) out2.readObject();
            System.out.println("Sikeres beovasas");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    } 
    
}
