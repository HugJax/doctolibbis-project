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

/**
 *
 * @author hecat
 */
 /// not use ANYMORE
 // were here to display in the Accueil the lastest change.
 //didnt got time to implement.
public class ChangeGrid extends ActuGrid
{
    ChangeGrid(Wall wa)
    {

        super(wa);

    }
    protected void fillist()
    {
        ArrayList<RDV> y = new ArrayList<RDV>();
        ArrayList<RDV> test1 = new ArrayList<RDV>();
        ArrayList<RDV> test2= new ArrayList<RDV>();
        test1=(new retrieveMySQL().rdvModif(wall.getID()));
        test2=new retrieveMySQL().rdvSup(wall.getID());
        int i=0;
        do
      {

          y.add(new retrieveMySQL().rdvModif(wall.getID()).get(i));
          y.add(new retrieveMySQL().rdvSup(wall.getID()).get(i));
          new RDV().tricroissant(y);
          int a=0;
          do {

              listrdv.add(y.get(a).getID());
              System.out.println("id rdv dans la liste: "+y.get(a).getID());
              if(y.get(a).getplace()==null)
              {
                  error[a]=1;
              }
          a+=1;
          } while (a<5 && a<y.size());

        i++;
      } while(i<5 && i<(test1.size()+test2.size()));
    }
}
