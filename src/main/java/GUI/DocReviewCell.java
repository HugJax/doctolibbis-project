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
 // display the doc review
public class DocReviewCell extends JPanel
{
    private int idreview;
    private Review comment=new Review();
    DocReviewCell(int id)
    {
        this.setBackground(new Color(146,177,229));
        idreview=id;
        comment=new retrieveMySQL().searchreview(idreview);
        this.setLayout(new BorderLayout());
        add(new JLabel("Name: "+new retrieveMySQL().retrievename(comment.getIDperson())),BorderLayout.WEST);
        add(new JLabel("                rate: "+comment.getrate()+"/5"),BorderLayout.CENTER);
        add(new JLabel("Review: "+ comment.getreview()),BorderLayout.SOUTH);
        this.setVisible(true);
        this.validate();
    }
}
