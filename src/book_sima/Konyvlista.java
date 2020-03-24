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
//import javax.lang.model.element.Element;
//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

 
import org.w3c.dom.Attr;
//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


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
     
try{
            FileOutputStream file = new FileOutputStream("konyvek.txt");
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
 public Boolean konyvListaMentesXML(){
    try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = (Document) docBuilder.newDocument();
        
	Element rootElement = doc.createElement("KonyvLista");
        doc.appendChild(rootElement);
        
        //most vegigmegyunk a listan
	for(Book_sima book: konyvek){
            Element konyv = doc.createElement("Konyv");
            rootElement.appendChild(konyv);
            Attr attr = doc.createAttribute("id");
            
            attr.setValue(book.getID());
            konyv.setAttributeNode(attr);
            
            Element konyvCim = doc.createElement("Cim");
            konyvCim.appendChild(doc.createTextNode(book.getCim()));
            konyv.appendChild(konyvCim);
                
            Element konyvSzerzo = doc.createElement("Szerzo");
            konyvSzerzo.appendChild(doc.createTextNode(book.getSzerzo()));
            konyv.appendChild(konyvSzerzo);
                
            //kiado element
            Element konyvKiado = doc.createElement("Kiado");
            konyvKiado.appendChild(doc.createTextNode(book.getKiado()));
            konyv.appendChild(konyvKiado);
            
            //ISBN element
            Element konyvISBN = doc.createElement("ISBN");
            String i = book.getISBN();
            konyvISBN.appendChild(doc.createTextNode(i.toString()));
            konyv.appendChild(konyvISBN);
            
            //kiadasEve element
            Element konyvKiadasEve = doc.createElement("KiadasEve");
            konyvKiadasEve.appendChild(doc.createTextNode( ((String)book.getKiadasEve()).toString()));
            konyv.appendChild(konyvKiadasEve);
        }
        
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("konyvLista.xml"));
        
        transformer.transform(source, result);
 
        System.out.println("File saved!");
        return true;


    }catch(Exception e){
        e.printStackTrace();
    }
    return false;
}
    public Boolean konyvListaBetoltes(){
        try{
            FileInputStream file = new FileInputStream("konyvek.txt");
            ObjectInputStream out2 = new ObjectInputStream(file);
            List<Book_sima> ujLista = new ArrayList<Book_sima>();
            ujLista = (List<Book_sima>) out2.readObject();
            for(Book_sima book : ujLista){
            System.out.println(book);
            } 
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
 
        }
    }

        

