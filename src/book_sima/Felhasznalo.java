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
public class Felhasznalo implements Serializable{
    private String nev;
    Kontakt elerhetoseg;
    private String jelszo;
    private String CNP;
    private String ID;
    
    public Felhasznalo(){
        
    }
    
    public Felhasznalo(String nev, Kontakt elerhetoseg, String CNP,String ID){
        this.nev = nev;
        this.elerhetoseg = elerhetoseg;
        this.CNP = CNP;
        this.ID = ID;
    }
    @Override
    public String toString(){
        return "Nev: " + nev +  " Address: " +  " CNP: " + CNP + " ID: " + ID;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Kontakt getElerhetoseg() {
        return elerhetoseg;
    }

    public void setElerhetoseg(Kontakt elerhetoseg) {
        this.elerhetoseg = elerhetoseg;
    }

    public String getJelszo() {
        return jelszo;
    }
    public String getID(){
    return ID;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
     public void setID(String ID) {
        this.ID = ID;
    
    
}
}
