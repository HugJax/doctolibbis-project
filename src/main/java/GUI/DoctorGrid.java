/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import Healthcare.*;

/**
 *
 * @author 931701723
 */
 // DIsplay the doctor grid and fill it .
public class DoctorGrid extends JPanel
{
    private Wall wall;
    private ArrayList<Integer> iddoc;
    private ArrayList<JLabel> docname;
    private ArrayList<JLabel> description;
    private ArrayList<JLabel> notation;
    private ArrayList<JLabel> specialisation;
    private ArrayList<JButton> docpage;
    private ArrayList<Doc> baba = new ArrayList<>(100);
    private retrieveMySQL tutu = new retrieveMySQL();

    private int result;
    private int boucle;

    DoctorGrid(Wall wa,String search)
    {
        wall=wa;
        int i=0;
        iddoc=new ArrayList<>();
        docname=new ArrayList<>();
        specialisation=new ArrayList<>();
        description=new ArrayList<>();
        docpage=new ArrayList<>();
        notation=new ArrayList<>();
        baba=tutu.rechercheDoc(search);

        docnamefill();
        specialisationfill();
        descriptionfill();
        notationfill();
        docpagefill();
        this.setLayout(new GridLayout(baba.size(),5,0,0));
        for(i=0;i<baba.size();i++)
        {
            add(docname.get(i));
            add(specialisation.get(i));
            add(description.get(i));
            add(notation.get(i));
            add(docpage.get(i));
        }
        this.setVisible(true);
        this.validate();

    }

    private void docnamefill()
    {

        int i;
        for (i=0;i<baba.size();i++)
        {
          docname.add(new JLabel(baba.get(i).getfname()+" "+baba.get(i).getlname()));
          System.out.println("IDdoc="+baba.get(i).getIDdoc());
        }

    }
    private void specialisationfill()
    {
        int i;
                for (i=0;i<baba.size();i++)
        {
          specialisation.add(new JLabel(baba.get(i).getspe()));
        }
    }
    private void descriptionfill()
    {
        int i;
                for (i=0;i<baba.size();i++)
        {
          description.add(new JLabel(baba.get(i).getplace()));
        }
    }
        private void notationfill()
    {
        int i;
                for (i=0;i<baba.size();i++)
        {
          notation.add(new JLabel(tutu.retrievedocrate(baba.get(i).getIDdoc())+"/5"));// remplacer 5 par get note par bdd
        }
    }
    private void docpagefill()
    {
        int i;
        for (i=0;i<baba.size();i++)
        {
            docpage.add(new JButton("Details"));
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
