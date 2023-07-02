/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Healthcare.*;


/**
 *
 * @author 931701723
 */
 // do the same as meeting case button but display use a ovveride to make the previous jframe close when we call the listener
public class MeetingCaseButtonInfo extends MeetingCaseButton
{
    private int idrdv;
    private MeetingInfo d;
            public MeetingCaseButtonInfo(Wall wa, int id)
    {
        super(wa, id);
        idrdv=id;
        linktomeetingdetail.removeAll();
        linktomeetingdetail.setText("Change Appoitment");
        linktomeetingdetail.addActionListener(new AddRDVListener());
        validate();

    }
    public MeetingCaseButtonInfo(Wall wa, int id,MeetingInfo suppmeet)
    {
        super(wa, id,suppmeet);
        d=suppmeet;
        idrdv=id;

        linktomeetingdetail.setText("Change Appoitment");
        linktomeetingdetail.addActionListener(new AddRDVListener());
        validate();

    }


               private class AddRDVListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
             int iddoc=new retrieveMySQL().retrieveIDdoc(idrdv);
            InputJMA q=  new  InputJMA(wall,iddoc,idrdv,d);
         }

    }

}
