/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Healthcare.*;
import java.awt.Color;


/**
 *
 * @author Kalmuns
 */
 // display info ine meeting case
public class MeetingCaseInfo extends JPanel
{
     private JLabel lieux;
    private JLabel doc;
    private JLabel date;
    private int idrdv;//
    private RDV rdv = new RDV();
    private retrieveMySQL trouve = new retrieveMySQL();
    MeetingCaseInfo(int iD)
    {

        idrdv=iD;
        this.setBackground(new Color(146,177,229));
        System.out.println("cecie est l'id du rdv: "+idrdv);
        lieux=new JLabel("place: "+trouve.rechercherdv(iD).getplace());// recup info via idrdv
        doc=new JLabel("doc: "+trouve.retrievedoc(trouve.retrieveIDdoc(iD)));
        date=new JLabel("date: "+trouve.rechercherdv(iD).getday()+" "+trouve.rechercherdv(iD).getmonth()+" "+trouve.rechercherdv(iD).getyear());
        add(doc);
        add(lieux);
        add(date);

        this.setVisible(true);
        this.validate();
    }
}
