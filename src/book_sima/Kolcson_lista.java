/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_sima;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tinkd
 */
public class Kolcson_lista {
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
}