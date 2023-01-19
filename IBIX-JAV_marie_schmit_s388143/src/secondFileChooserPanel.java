
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author marie
 */
public class secondFileChooserPanel extends fileChooserPanel {

    //Constructor
    public secondFileChooserPanel(exonsPanel exonsPane) {
        super(); //Call constructor of class parent
        //Access to some elements of exon panel
        this.exonsPanel = exonsPane;
    }

    //Override constructor
    public secondFileChooserPanel() {
        super();
    }
    
    public void setVariable(boolean[] firstType, String firstName) {
        //Set variables with first selected file information
        this.firstFileName = firstName;
        this.firstFileTypes = firstType;

        //Modify the design of some components
        reInitComponents();
    }

    //Add variables linked to exon table
    exonsPanel exonsPanel;
    boolean[] firstFileTypes;
    private boolean textual; //Is the selected display textual or graphical

    //Data related to first chosen file
    public String firstFileName; //Name of the selected file
    public String firstFileChosenMessage; //Message to display in actionFrame, indicating the name of the chosen file

    //Change some components of the panel
    private void reInitComponents() {
        //Set message displayed to user according to the first chosen file
        if (firstFileTypes[0]) {
            textLbl.setText("Please select a fasta file");
        } else if (firstFileTypes[1]) {
            textLbl.setText("Please select a gtf file");
        }

        //Add previous filename
        waitMessage.setText("The previous selected file is: " + firstFileName);
        waitMessage.setVisible(true);
    }

    //Overrid confirm function
    public void confirm() {
        boolean rightFormat;
        rightFormat = checkFileType(firstFileTypes, gtfFile, fastaFile); //Check the type of the file
        
        if(rightFormat){
            //Open actionpanel and display results panel        
            mainFrame.displayResultsPane.setVisible(true);
            mainFrame.actionPanel.setVisible(true);
            mainFrame.displayResultsPane.setVisible(true);
            
            //This chooser disappears 
            this.setVisible(false);
        }
        else{
            waitMessage.setVisible(true);
        }
    }

    //Check second choosen file type: should be a fasta file
    //Returns true if the file has the right format
    public boolean checkFileType(boolean[] firstType, boolean gtf, boolean fasta) {
        if (firstType[0] && gtf) { //First and second files selected are gtf
            waitMessage.setText("Please chose another file, format should be fasta.");
            return false; //File does not have the right format
        } else if (firstType[1] && fasta) {//Both files are fasta
            waitMessage.setText("Please chose another file, format should be fasta.");
            return false; //File does not have the right format
        } else {
            //Panels to display text or graphics are visible
            exonsPanel.jLayeredPane1.setVisible(true);
            //Change the card panel according to the selected type pof display
            //Set right card panel
            if(textual) { //Show text
                exonsPanel.changeCardPanel("textual");
                
                //New instance of class exons
                exons exons = new exons();
                //Display text exon with propoer colors
                exons.getExons(this.fileContent);
            } else { //Show graphic
                exonsPanel.changeCardPanel("graphical");
            }
            return true; //File has the right format
        }
    }

    //Set value of textual (true if text has to be shown)
    public void setTextual(boolean textual) {
        this.textual = textual;
    }
}
