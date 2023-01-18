/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marie
 */
public class secondFileChooserPanel extends fileChooserPanel{
    //Constructor
    public secondFileChooserPanel(exonsPanel exonsPane, super.FileClass firstFile) {
        super(); //Call constructor of class parent
        this.exonsPanel = exonsPane;
    }
    
    //Add variables linked to exon table
    exonsPanel exonsPanel;
    
    //Change text of the label
}
