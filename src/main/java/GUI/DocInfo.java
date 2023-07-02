/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.*;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author Kalmuns
 */
 // display all doc info
public class DocInfo extends JPanel
{
    private JLabel name;
    private JLabel spe;
    private JLabel place;
    private JLabel price;
    private JLabel mail;
    private JLabel phone;
    private JLabel note;
    private JLabel formation;
    private JLabel experience;
    private int iddoc;
    private Doc doc = new Doc();
   // private retrieveMySQL baba = new retrieveMySQL();

    DocInfo(int id)
    {
       iddoc=id;
       this.setBackground(new Color(146,177,229));
       doc=new retrieveMySQL().retrieveDoc(iddoc);
       name=new JLabel("Name: "+new retrieveMySQL().retrievedoc(iddoc));// fill here with bdd
       spe=new JLabel("Specialisation: "+doc.getspe());
       place=new JLabel("Location: "+doc.getplace());
       price=new JLabel("Price= "+doc.getprix());
       mail=new JLabel("E-Mail adress: "+doc.getpmail());
       phone=new JLabel("Phone: +44"+doc.getptel());
       note=new JLabel("Rate: "+new retrieveMySQL().retrievedocrate(iddoc));
       formation=new JLabel("Formation: "+doc.getformation());
       experience=new JLabel("Experience: "+doc.getexp());
       this.setLayout(new GridLayout(9,1,0,0));
       add(name);
       add(spe);
       add(place);
       add(price);
       add(mail);
       add(phone);
       add(note);
       add(formation);
       add(experience);
       this.setVisible(true);
       this.validate();
    }
}
