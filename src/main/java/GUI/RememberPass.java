/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author 931701723
 */
 // fill jtextfield in login
public class RememberPass extends JPanel
{
    private JLabel text;
    private JCheckBox check;
    private int[] test;

    RememberPass(int[] t)
    {
        test=t;
        text=new JLabel("Remember my password ");
        check =new JCheckBox ();
        check.addItemListener(new CheckBoxListener());
        add(check);
        this.validate();
    }
       private class CheckBoxListener implements ItemListener

   {
      public void itemStateChanged(ItemEvent e)
      {

            if (check.isSelected())
            {
                System.out.println("test pour voir si ca marche");
               test[0]=1;
            }
            else
            {
                System.out.println("test pour voir si ca marche");
               test[0]=2;
            }
      }
       }

}
