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
//import javax.lang.model.element.Element;
//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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


/**
 *
 * @author Exodia
 */
public class Felhasznalo_lista implements  Serializable{
    public List<Felhasznalo> userList;
    
    public Felhasznalo_lista(){
        userList = new ArrayList<Felhasznalo>();
    }
    
     public Felhasznalo keres(String ID){
         
             for(Felhasznalo user : userList){
            if(user.getID().equals(ID))
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
     
      public int meret(){
    return userList.size();
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
     public Boolean userListMentesXML(){
        try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = (Document) docBuilder.newDocument();
        
	Element rootElement = doc.createElement("UserLista");
        doc.appendChild(rootElement);
        
        for(Felhasznalo u : userList){
                Element user = doc.createElement("ID");
                rootElement.appendChild(user);
                user.setAttribute("id", u.getCNP());
                
                Element name = doc.createElement("Nev");
                name.appendChild(doc.createTextNode(u.getNev()));
                user.appendChild(name);
                
                 Element ujelszo = doc.createElement("Jelszo");
                 name.appendChild(doc.createTextNode(u.getJelszo()));
                 user.appendChild(ujelszo);
                 
                 Element uCNP = doc.createElement("CNP");
                 name.appendChild(doc.createTextNode(u.getCNP()));
                 user.appendChild(uCNP);
                
            }
         // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("userLista.xml"));
        
        transformer.transform(source, result);
 
        System.out.println("File saved!");
        return true;
        
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
            userList = (List<Felhasznalo>) out2.readObject();
            for(Felhasznalo user : userList){
             System.out.println(user);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    } 
    public List userListBetoltesXML(){
        try{
            File fXmlFile = new File("userLista.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
	
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("User");
                     
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                
                Felhasznalo k = new Felhasznalo();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                   k.setID(eElement.getAttribute("id"));
                   k.setNev(eElement.getElementsByTagName("Nev").item(0).getTextContent());
                   k.setJelszo(eElement.getElementsByTagName("Jelszo").item(0).getTextContent());
                   k.setCNP(eElement.getElementsByTagName("CNP").item(0).getTextContent());
                   userList.add(k);
                }
            }
                return userList;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    } 

    
}
