/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_sima;

import java.io.Serializable;

/**
 *
 * @author tinkd
 */
public class Book_sima implements Serializable {

    private String cim;
    private String szerzo;
    private String kiado;
    private String kiadasEve;
    private String ISBN;
    private String ID;
    
public Book_sima(String cim, String szerzo, String kiado, String kiadasEve, String ISBN, String ID){
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiado = kiado;
        this.ISBN = ISBN;
        this.cim = cim;
        this.kiadasEve = kiadasEve;
        this.ID = ID;
    }

public Book_sima(){
}
    public void setCim(String cim){
        this.cim = cim;
    }
    
    public void setSzerzo(String szerzo){
        this.szerzo = szerzo;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public void setKiadasEve(String kiadasEve) {
        this.kiadasEve = kiadasEve;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCim() {
        return cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getKiado() {
        return kiado;
    }

    public String getKiadasEve() {
        return kiadasEve;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getID() {
        return ID;
    }
    
    public String toString(){
        
        return "Szerzo: " + szerzo + " Cim: " + cim + " Kiado : " + kiado + " KiadasEve : " + kiadasEve + " ISBN : " + ISBN + " ID : " + ID ;
    }
    
}
