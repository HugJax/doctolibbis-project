/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Healthcare.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author 931701723
 */

 // input for new appointment.
public class InputJMA extends JFrame
{
    private JTextField jour;
    private JTextField mois;
    private JTextField annee;
    private JLabel j;
    private JLabel m;
    private JLabel a;
    private JLabel t;
    private JComboBox temps;
    private JButton valide;
    private Wall wall;
    private String[] times;
    private int[] date;
    private int time;
    private int idrdv=0;
    private int iddoc;
    private MeetingInfo close=null;
    private String actual;
    private JLabel r;
    private JButton checkdate;
    private JTextField raison;
    private String description;
    public  InputJMA(Wall wa,int  iddocteur)
    {

        date= new int[3];
        this.setSize(600,200);

        iddoc=iddocteur;
        wall=wa;
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        jour= new JTextField (2);
        mois= new JTextField(2);
        annee= new JTextField(4);
        times= new String[] { "0" };
        temps = new JComboBox(times);
        System.out.println("string"+times.length);
        temps.setSelectedIndex(0);
        temps.addActionListener(new Combo());

        raison =new  JTextField(100);


        this.setTitle("Wich Day ?");
        j=new JLabel("Day");
        m=new JLabel("Month");
        a=new JLabel("Years");
        t= new JLabel("Hour");
        r= new JLabel("Reason:");
        this.setLayout(new GridLayout(3,4,0,0));
        checkdate= new JButton("checkdate");
        valide=new JButton ("Confirm");
        checkdate.addActionListener(new CheckDateListener());
        valide.addActionListener(new ConfirmJMA());
        add(j);
        add(m);
        add(a);
        add(t);
        add(jour);
        add(mois);
        add(annee);
        add(temps);
        add(r);
        add(raison);
        add(checkdate);
        add(valide);
        this.validate();
    }
    public  InputJMA(Wall wa,int  iddocteur,int idrd, MeetingInfo cl)
    {
        close=cl;
        date= new int[3];
        this.setSize(600,200);
        iddoc=iddocteur;
        wall=wa;
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        jour= new JTextField (2);
        mois= new JTextField(2);
        annee= new JTextField(4);
        times= new String[] { "0" };
        temps = new JComboBox(times);
         System.out.println("string"+times.length);
        temps.setSelectedIndex(0);
        temps.addActionListener(new Combo());
        raison =new  JTextField(100);
        idrdv=idrd;
        this.setTitle("Wich Day ?");
        j=new JLabel("Day");
        m=new JLabel("Month");
        a=new JLabel("Years");
        t= new JLabel("Hour");
        r= new JLabel("Reason:");
        checkdate= new JButton("checkdate");
        this.setLayout(new GridLayout(3,4,0,0));
        valide=new JButton ("Confirm");
            checkdate.addActionListener(new CheckDateListener());
        valide.addActionListener(new ConfirmJMA());
        add(j);
        add(m);
        add(a);
        add(t);
        add(jour);
        add(mois);
        add(annee);
        add(temps);
        add(r);
        add(raison);
        add(checkdate);
        add(valide);
       this.validate();
    }
    public class Combo  implements ActionListener {// get select item
        public void actionPerformed(ActionEvent e)
        {



        int index;

        index=temps.getSelectedIndex();
        temps.setSelectedIndex(index);
        JComboBox cb = (JComboBox)e.getSource();
        actual = (String)cb.getSelectedItem();
        revalidate();
        }
    }
    private class CheckDateListener implements ActionListener // check available appoitment on this day. get date from jfield.
    {
         public void actionPerformed(ActionEvent e)
         {
               times= new retrieveMySQL().rechercherdvdoctor(iddoc, Integer.parseInt(annee.getText()), Integer.parseInt(mois.getText()), Integer.parseInt(jour.getText()));
        int index;
        JComboBox de= new JComboBox(times);
        DefaultComboBoxModel model=(DefaultComboBoxModel) de.getModel();
        index=temps.getSelectedIndex();
        temps.setModel(model);
        temps.setSelectedIndex(index);
         }
    }

            private class ConfirmJMA implements ActionListener// check and save appoitment
    {
         public void actionPerformed(ActionEvent e)
         {

              if(nullcheck(jour)||nullcheck(mois)||nullcheck(annee)||isnotdigit(jour)||isnotdigit(mois)||isnotdigit(annee))
              {
                  System.out.println("chexk 1");
                 ErrorInput q= new ErrorInput();
              }
              else{
                  date[0]= Integer.parseInt(jour.getText());// a bind

             date[1]= Integer.parseInt(mois.getText());
             date[2]= Integer.parseInt(annee.getText());
              }
              if(date[0]<1||date[0]>30||date[1]<1||date[1]>12)
              {
                  System.out.println("chexk 2");
                 ErrorInput q= new ErrorInput();
              }
            else
           {
              if (idrdv!=0)
              {
                  new changeMySQL().deleterdv(idrdv);
              }
             date[0]= Integer.parseInt(jour.getText());// a bind

             date[1]= Integer.parseInt(mois.getText());
             date[2]= Integer.parseInt(annee.getText());
             time=Integer.parseInt(actual);
             description=raison.getText();
             String test= new retrieveMySQL().retrievedocplace(iddoc);
             System.out.println(iddoc);
             RDV buffer= new RDV(iddoc,wall.getID(),description,Integer.parseInt(actual),date, test);// ajouter le rdv a la bdd// mettre a jour time
             addMySQL tot=new addMySQL();
             tot.addRDV(buffer);

              dispose();
               wall.actual(new MeetingPanel(wall,wall.getID()));
           }
         }
    }
            protected boolean nullcheck(JTextField a)
  {

      return a.getText().isBlank();
  }
  protected boolean isnotdigit(JTextField s)
  {
      boolean verif=false;
      String a=s.getText();
      for(int i=0;i<a.length();i++)
      {
          if(!Character.isDigit(a.charAt(i)))
          {
              verif=true;
          }

          }
      return verif;
  }
}

