/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Healthcare.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author hecat
 */
 // display the grid of the next appoitment in the Accueil
public class ActuGrid extends JPanel{
protected Wall wall;
protected MeetingCaseInfo buffer;
protected int[] error= new int[5];
 protected ArrayList<Integer> listrdv = new ArrayList<>();
   ActuGrid(Wall wa)
  {
      wall=wa;
      this.setBackground(new Color(146,177,229));

      int i;

      for(i=0;i<5;i++)
      {
          error[i]=0;
      }
      this.setLayout(new GridLayout(5,1,0,0));
      fillist();
      for (i=0;i<listrdv.size();i++)
      {
          buffer=new MeetingCaseInfo(listrdv.get(i));   // fill the grid
          if (error[i]!=0)
          {
              buffer.setBackground(Color.red);
          }
            add(buffer);
      }
      this.setVisible(true);
      this.validate();

  }
    protected void fillist()// fill the list of appoitment rdv
   {
       for(int i=0;i<5;i++)
      {
          int y=new retrieveMySQL().rechercherdvpatient(wall.getID()).get(i).getID();

          listrdv.add(y);
      }
   }

}
