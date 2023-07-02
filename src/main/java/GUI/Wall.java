/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Healthcare.*;
import javax.imageio.*;
import java.io.*;


/**
 *
 * @author Kalmuns
 */
 /// Main Panel. contain every other panel when we need too. also give id everywhere
public class Wall extends JPanel
{
    public ArrayList<JPanel> panneaux;
    private int menu;
    private int tmenu=0;
    private int[] idpersonne;
    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hecat\\Documents\\Cours\\Programming\\Projet\\Healthcare\\src\\main\\java\\GUI\\login.png");
    public Wall()
            {
                this.setBackground(new Color(59,93,170));

                idpersonne = new int [1];
                idpersonne[0]=2;
                this.setLayout(new BorderLayout());
               // add(new ContentPanel());
                JPanel buffer= new Logpage(this,idpersonne);
                System.out.println(idpersonne[0]);
                add(buffer,BorderLayout.CENTER);

                    this.validate();
                  setVisible(true);
            }

     public void rset()
    {
         int i;
            for (i=0;i<this.getComponentCount();i++)
            {
                getComponent(i).setVisible(false);
                getComponent(i).setEnabled(false);
            }

    }
     public void act(int i)
     {
         this.getComponent(i).setVisible(true);
         this.getComponent(i).setEnabled(true);
     }
     public void setmenu()
     {
         tmenu=0;
         this.rset();
         this.add(new Menu(this),BorderLayout.NORTH);
         this.revalidate();
     }
     public void setmenudoc()
     {
         this.rset();
         tmenu=1;
         this.add(new MenuDoc(this),BorderLayout.NORTH);
         this.revalidate();
     }
     public void actual(JPanel s)
     {
         if(tmenu==0)
         {
          setmenu();
         }
         else
         {
             setmenudoc();
         }

         this.remove(0);
         System.out.println("add ok");

         add(s,BorderLayout.CENTER, 0);
  System.out.println(this.getComponentCount()+" count in actual");
         act(0);

         this.revalidate();
     }
     public int getID()
     {
         return idpersonne[0];
     }
     public int[] getlog()
     {
         return idpersonne;
     }

//    }
}
