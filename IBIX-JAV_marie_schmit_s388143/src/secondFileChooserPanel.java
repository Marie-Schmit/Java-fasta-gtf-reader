
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
    /*
    public secondFileChooserPanel(exonsPanel exonsPane, boolean[] firstType, String firstName) {
        super(); //Call constructor of class parent
        this.exonsPanel = exonsPane;
        this.firstFileName = firstName;
        this.firstFileTypes = firstType;

        //Modify some components
        reInitComponents();
    }
    */

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
        //Open actionpanel and display results panel        
        mainFrame.displayResultsPane.setVisible(true);
        mainFrame.actionPanel.setVisible(true);
        mainFrame.displayResultsPane.setVisible(true);

        //Check type of the file
        checkFileType(firstFileTypes, gtfFile, fastaFile);

        this.setVisible(false);

    }

    //Check second choosen file type: should be a fasta file
    public void checkFileType(boolean[] firstType, boolean gtf, boolean fasta) {
        if (firstType[0] && gtf) { //First and second files selected are gtf
            waitMessage.setText("Please chose another file, format should be fasta.");
            waitMessage.setVisible(true);
        } else if (firstType[1] && fasta) {//Both files are fasta
            waitMessage.setText("Please chose another file, format should be fasta.");
            waitMessage.setVisible(true);
        } else {
            exonsPanel.jLayeredPane1.setVisible(true);
            //Change the card panel according to the selected type pof display
            //Set right card panel
            if(textual) { //Show text
                System.out.println("textual");
                exonsPanel.changeCardPanel("textual");
            } else { //Show graphic
                System.out.println("graphical");
                exonsPanel.changeCardPanel("graphical");
            }
        }
    }

    //Set value of textual (true if text has to be shown)
    public void setTextual(boolean textual) {
        this.textual = textual;
    }
}
