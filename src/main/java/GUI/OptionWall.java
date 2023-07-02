/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Kalmuns
 */
 // plan to add image on option.
 // add to use to be able to put component wherever i want.
public class OptionWall extends JPanel
{
    private int idprs;
    private Option option;
    OptionWall(Wall wall,int id)
    {
        idprs=id;
        this.setLayout(new BorderLayout());
        option = new Option(idprs);
        add(option,BorderLayout.CENTER);
        add(new OptionEast(wall),BorderLayout.EAST);

    }

}
