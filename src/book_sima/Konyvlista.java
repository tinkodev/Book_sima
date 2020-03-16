/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_sima;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Konyvlista implements  Serializable{
    
    private List<Book_sima> konyvek; 
    
    public Konyvlista(){
        konyvek = new ArrayList<Book_sima>();
    }
    public  Book_sima keres(String ID){
        for(Book_sima konyv : konyvek){
            if(konyv.getID().equals(ID))
                return konyv;
            
        }
        return null;
    }
    
    public void hozzaad(Book_sima konyv){
        konyvek.add(konyv);
    }
    public Boolean torol(String ID){
        for(Book_sima konyv : konyvek){
            if(konyv.getID().equals(ID)){
                konyvek.remove(konyv);
            return true;
            }
                
        }
        return false;
    }
    
    public Boolean modositas(String Id, Book_sima konyv){
        for(Book_sima konyvElem : konyvek){
            if(konyvElem.getID().equals(Id) ){
                konyvElem.setCim(konyv.getCim());
                konyvElem.setISBN(konyv.getISBN());
                konyvElem.setKiadasEve(konyv.getKiadasEve());
                konyvElem.setKiado(konyv.getKiado());
                konyv.setSzerzo(konyv.getSzerzo());
                return true;
            }

        }
        return false;
    }
    
   
  public void Listazas(){
        for(Book_sima konyv : konyvek)
            
        System.out.println(konyv.toString()+ " Kiado: " + konyv.getKiado()+ " Kiadas eve: " + konyv.getKiadasEve() + " ISBN: " + konyv.getISBN());
    }

 public Boolean Mentes(){
        String filename = "konyvek.txt";  
try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(konyvek);
            
            out.close();
            file.close();
        //    return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    }
    public Boolean konyvListaBetoltes(){
        String filename = "konyvek.txt";
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream out2 = new ObjectInputStream(file);
            List<Book_sima> ujLista = new ArrayList<Book_sima>();
            ujLista = (List<Book_sima>) out2.readObject();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    } 
        
}
