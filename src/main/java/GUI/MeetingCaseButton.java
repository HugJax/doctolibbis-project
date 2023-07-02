/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import guiv0.pkg1.MeetingCase;
import java.awt.BorderLayout;
import static java.awt.Color.red;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import Healthcare.*;


/**
 *
 * @author 931701723
 */
public class MeetingCaseButton extends JPanel //Regroup the button used in a cell of MeetinPanel.
// Part of MeetingCase
{
    protected JButton linktomeetingdetail;
    protected JButton suppmeeting;
    protected int idrdv;
    protected Wall wall;
    protected MeetingInfo ablesupp=null;
    MeetingCaseButton(Wall wa,int id,MeetingInfo ablesup)
    {
        ablesupp=ablesup;
        idrdv=id;
        wall=wa;
        linktomeetingdetail=new JButton("more info");
        suppmeeting =new JButton("Delete");
        suppmeeting.setBackground(red);
        suppmeeting.addActionListener(new SuppMeeting());

        this.setLayout(new BorderLayout());
        add(linktomeetingdetail,BorderLayout.CENTER);
        add(suppmeeting,BorderLayout.EAST);
        validate();
    }
       MeetingCaseButton(Wall wa,int id)
    {

        idrdv=id;
        wall=wa;
        linktomeetingdetail=new JButton("more info");
        suppmeeting =new JButton("Delete");
        suppmeeting.setBackground(red);
        suppmeeting.addActionListener(new SuppMeeting());
        linktomeetingdetail.addActionListener(new Linkmeetingdetail());
        this.setLayout(new BorderLayout());
        add(linktomeetingdetail,BorderLayout.CENTER);
        add(suppmeeting,BorderLayout.EAST);
        validate();
    }


    private class Linkmeetingdetail implements ActionListener // get display info of the meetign of this id
    {
            public void actionPerformed(ActionEvent e)
        {
           MeetingInfo buffer= new MeetingInfo(wall,idrdv);
        }
    }
    private class SuppMeeting implements ActionListener// display delete JFrame
    {
            public void actionPerformed(ActionEvent e)
            {
                if (ablesupp==null)
                        {
                            SupMeeting buffer=new SupMeeting(wall,idrdv);
                        }
                else
                {
                    SupMeeting buffer=new SupMeeting(wall,idrdv,ablesupp);
                }

            }
    }
}
