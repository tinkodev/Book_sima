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
public class Kolcsonzes {
    String ID;
    String Datum;
    Book_sima konvy;
    Felhasznalo user;

    public String getID() {
        return ID;
    }
  
    public void toString(Book_sima konyv,Felhasznalo user){
     System.out.println(konyv);
     System.out.println(user); 
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public Book_sima getKonvy() {
        return konvy;
    }

    public void setKonvy(Book_sima konvy) {
        this.konvy = konvy;
    }

    public Felhasznalo getUser() {
        return user;
    }

    public void setUser(Felhasznalo user) {
        this.user = user;
    }
}

