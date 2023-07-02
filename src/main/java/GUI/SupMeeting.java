/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Healthcare.*;


/**
 *
 * @author 931701723
 */
 // confirm of deleting an information
 // id override to dispose if their is a jframe doc info before
public class SupMeeting extends JFrame
{
      private JButton ok;
      private JButton cancel;
      private JLabel sure;
      private Wall wall;
      private int idrdv;
      private MeetingInfo meetinginfo=null;
      public SupMeeting(Wall wa,int id)
      {
          wall=wa;
          idrdv=id;
          sure=new JLabel("ARE YOU SURE?");
          setSize(200,80);
          setTitle("confirm");
          setVisible(true);
          this.setAlwaysOnTop(true);
          ok=new JButton("YES");
          cancel=new JButton("Cancel");
          ok.addActionListener(new OkSuppListener());
          cancel.addActionListener(new CancelListener());
          setLayout(new BorderLayout());
          add(sure,BorderLayout.NORTH);
          add(ok,BorderLayout.CENTER);
          add(cancel,BorderLayout.EAST);
          validate();
      }
            public SupMeeting(Wall wa,int id, MeetingInfo fenetre)
      {
          meetinginfo=fenetre;
          wall=wa;
          idrdv=id;
          sure=new JLabel("ARE YOU SURE?");
          setSize(200,80);
          setTitle("confirm");
          setVisible(true);
          this.setAlwaysOnTop(true);
          ok=new JButton("YES");
          cancel=new JButton("Cancel");
          ok.addActionListener(new OkSuppListener());
          cancel.addActionListener(new CancelListener());
          setLayout(new BorderLayout());
          add(sure,BorderLayout.NORTH);
          add(ok,BorderLayout.CENTER);
          add(cancel,BorderLayout.EAST);
          validate();
      }
           private class OkSuppListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            // destroy in bdd
            //

             new changeMySQL().deleterdv(idrdv);
             if (meetinginfo!=null)
                     {
                        meetinginfo.dispose();
                     }

             dispose();
             wall.actual(new MeetingPanel(wall,wall.getID()));
         }

    }
         private class CancelListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
             dispose();
         }

    }
}
