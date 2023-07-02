/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JPanel;
import Healthcare.*;
import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author Kalmuns
 */
 // display the review cell was suppose to be created by used by user
public class DocReviewGrid extends JPanel
{
    private int iddoc;
    private Wall wall;
    private ArrayList<Review> comment = new ArrayList<Review>();
    public DocReviewGrid(Wall wa,int id)
    {
        int i=6,y;
        wall=wa;
        iddoc=id;
        comment=new retrieveMySQL().recherchereview(iddoc);
        this.setLayout(new GridLayout(i,1,0,0));
        for(y=0;y<comment.size();y++)
        {
            add(new DocReviewCell(comment.get(y).getIDreview()));// changer le 50 par id review par itération
        }
    }
}
