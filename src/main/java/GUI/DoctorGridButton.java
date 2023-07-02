/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Healthcare.Doc;
import Healthcare.retrieveMySQL;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author hecat
 */
 // Set and made the button available
public class DoctorGridButton extends JPanel
{
    private ArrayList<JButton> docpage;
    private Wall wall;
    private ArrayList<Doc> baba = new ArrayList<>(100);
    private retrieveMySQL tutu = new retrieveMySQL();
    DoctorGridButton(Wall wa,String search)
    {
        this.setLayout(new GridLayout(10,1,0,0));
        wall=wa;
        docpage=new ArrayList<>();
        baba=tutu.rechercheDoc(search);
        int i=0;
        docpagefill();

        this.validate();

    }
    private void docpagefill() // fill doc page
    {
        int i;
        for (i=0;i<baba.size();i++)
        {
            docpage.add(new JButton("Details")); /// Should use a switch but didnt plan to get 10 option.
            if (i==0)
            {
                 docpage.get(i).addActionListener(new DocPageListener0());
            }
            else if (i==1)
            {
                 docpage.get(i).addActionListener(new DocPageListener1());
            }
            else if (i==2)
            {
                docpage.get(i).addActionListener(new DocPageListener2());
            }
            else if (i==3)
            {
                docpage.get(i).addActionListener(new DocPageListener3());
            }
            else if (i==4)
            {
                docpage.get(i).addActionListener(new DocPageListener4());
            }
            else if (i==5)
            {
                docpage.get(i).addActionListener(new DocPageListener5());
            }
            else if (i==6)
            {
                docpage.get(i).addActionListener(new DocPageListener6());
            }
            else if (i==7)
            {
                docpage.get(i).addActionListener(new DocPageListener7());
            }
            else if (i==8)
            {
                docpage.get(i).addActionListener(new DocPageListener8());
            }
            else if (i==9)
            {
                docpage.get(i).addActionListener(new DocPageListener9());
            }
         add(docpage.get(i));


        }
    }
    /// I DIDNT DISCOVER AE event before.
         private class DocPageListener1 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(1).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
           private class DocPageListener2 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(2).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
             private class DocPageListener3 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(3).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
               private class DocPageListener4 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(4).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                 private class DocPageListener5 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(5).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                   private class DocPageListener6 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(6).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                   private class DocPageListener7 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(7).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                       private class DocPageListener8 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(8).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                         private class DocPageListener9 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(9).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
                           private class DocPageListener0 implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           DocFiche  d=new DocFiche(wall,baba.get(0).getIDdoc()); // changer le 3 par l'indice dans la liste, soit i
          // constructeur fiche doc(id)
          wall.actual(d);
         }

    }
}
