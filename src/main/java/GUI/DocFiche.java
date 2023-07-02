/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author Kalmuns
 */
 // Regroup Doctor panel for doctor description
public class DocFiche extends JPanel
{

    private int iddoc;
    private Wall wall;
    public DocFiche (Wall wa, int id)
    {
        this.setBackground(new Color(146,177,229));
        wall=wa;
        iddoc=id;
        this.setLayout(new BorderLayout());
        add(new DocInfoEast(wall,iddoc),BorderLayout.EAST);// regroup panel with book an appointment button
        add(new DocInfo(iddoc),BorderLayout.CENTER);// display info
        add(new DocReviewGrid(wall,iddoc),BorderLayout.SOUTH);     // display commentary
    }
}
