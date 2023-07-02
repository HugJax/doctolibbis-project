/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//import guiv0.pkg1.Wall;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author 931701723
 */
 // here to display image
public class ImagePanel extends JPanel
{
    ImagePanel(String a)
    {
        this.setBackground(new Color(146,177,229));
        ImageIcon arn = new ImageIcon(a);
         if(arn==null)
        {
            System.out.println("image at "+   "not found");
        }
         else
         {
             JLabel arnold = new JLabel(arn);
             add(arnold);
             setVisible(true);
             this.validate();

         }

    }

}

