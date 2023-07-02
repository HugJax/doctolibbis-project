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
 * @author 931701723
 */
 // display in
public class MeetingInfo extends JFrame
{
    private JLabel patient;// fill auto pour jlabel
    private JLabel motive;
    private JLabel date;
    private JLabel hour;
    private JLabel lieu;
    private JLabel docname;
    private JLabel docspe;
    private JButton suppmeeting;
    private JButton changemeeting;
    private int idrdv;
    private Wall wall;
    private retrieveMySQL trouve = new retrieveMySQL();
    MeetingInfo(Wall wa, int id)
    {
        this.setBackground(new Color(146,177,229));
        System.out.println("appointment info");
        wall=wa;
        idrdv=id;
        this.setSize(270,400);
        setVisible(true);
        //patient=new JLabel("Patient:");
        motive=new JLabel("Reason: "+trouve.rechercherdv(idrdv).getreason());
        date=new JLabel("Date: "+trouve.rechercherdv(idrdv).getday()+" "+trouve.rechercherdv(idrdv).getmonth()+" "+trouve.rechercherdv(idrdv).getyear());
        hour=new JLabel("Time: "+trouve.rechercherdv(idrdv).gettime());
        lieu=new JLabel("Place: "+trouve.rechercherdv(idrdv).getplace());
        docname=new JLabel("Doctor: "+trouve.retrievedoc(trouve.retrieveIDdoc(idrdv)));
        this.setLayout(new GridLayout(8,1,0,0));
        add(docname);
        add(lieu);
        add(date);
        add(hour);
        add(motive);
        add(new MeetingCaseButtonInfo(wall,idrdv,this));//add the button for change appoitment
        validate();
    }
    public void close()
    {
        this.dispose(); // is used by meeting case button to close this frame
    }
}
