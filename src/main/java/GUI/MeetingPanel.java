/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//import guiv0.pkg1.Wall;
import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author Kalmuns
 */
 // regroup All Meeting panel
public class MeetingPanel extends JPanel
{
    private Wall wall;

    private int iD;
    ArrayList<RDV> listrdv = new ArrayList<>(100);
    retrieveMySQL trouve = new retrieveMySQL();
    List<JPanel> panelList = new ArrayList<JPanel>();

    public MeetingPanel(Wall wa,int id)
    {
        iD=id;
        this.setBackground(new Color(146,177,229));
        int i;
        wall=wa;

        listrdv=trouve.rechercherdvpatient(iD);
        for(i=0;i<listrdv.size();i++)
        {
            panelList.add(new MeetingCase(wa,listrdv.get(i).getID()));
        }
        setLayout(new GridLayout(10,2,0,0));
        for(i=0;i<listrdv.size();i++)
        {
           add(panelList.get(i));

        }

        setVisible(true);
        setEnabled(true);
        this.validate();
        System.out.println("meeting panel constructor");
    }


}
