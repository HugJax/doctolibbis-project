/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import Healthcare.*;
import java.awt.Color;


/**
 *
 * @author Kalmuns
 */
public class MeetingCase extends JPanel// Regroup different JPanel and is implant a cell in Meeting grid
{
    private Wall wall;
    private int idrdv;

    public MeetingCase(Wall wa, int id)
    {
        this.setBackground(new Color(146,177,229));
        wall=wa;
        idrdv=id;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        add(new MeetingCaseInfo(idrdv),BorderLayout.CENTER);
        add(new MeetingCaseButton(wa,idrdv),BorderLayout.SOUTH);
        validate();
    }

}

