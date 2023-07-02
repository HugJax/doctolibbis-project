/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import guiv0.pkg1.Wall;
import javax.swing.*;
import java.awt.event.*;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author Kalmuns
 */
 // Leadin User
public class Menu extends JPanel
{
    private JButton accueil;
    private JButton meeting;
    private JButton doctorlist;
    private JButton option;
    protected int id=0;
    protected Wall wall;
    public Menu(Wall wa)
    {
        this.setBackground(new Color(146,177,229));
            accueil=new JButton ("Accueil");
            meeting=new JButton ("Appointment");
            doctorlist= new JButton("Doctors");
            option=new JButton ("Option");
            accueil.addActionListener(new AccueilListener());
            meeting.addActionListener(new MeetingListener());
            doctorlist.addActionListener(new DoctorListListener());
            option.addActionListener(new OptionListener());
            add(accueil);
            add (meeting);
            add(doctorlist);
            add(option);
            wall= wa  ;
            setVisible(true);
            setEnabled(true);
            this.validate();

    }
    private class AccueilListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           wall.actual(new Accueil(wall));
         }

    }
    private class MeetingListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           wall.actual(new MeetingPanel(wall,wall.getID()));
        }

    }
    private class DoctorListListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new Doctors(wall));
        }
    }
     private class OptionListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           wall.actual(new OptionWall(wall,wall.getID()));
         }

    }
}


