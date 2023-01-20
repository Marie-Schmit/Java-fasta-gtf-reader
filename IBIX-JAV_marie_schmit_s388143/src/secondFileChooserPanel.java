
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

    //Add variables linked to exon table
    private exonsPanel exonsPanel;
    private boolean[] firstFileTypes;
    private boolean textual; //Is the selected display textual or graphical
    private ArrayList<StringBuffer> firstFileContent;

    //Data related to first chosen file
    public String firstFileName; //Name of the selected file
    public String firstFileChosenMessage; //Message to display in actionFrame, indicating the name of the chosen file

    
    public void setVariable(boolean[] firstType, String firstName, ArrayList<StringBuffer> content) {
        //Set variables with first selected file information
        this.firstFileName = firstName;
        this.firstFileTypes = firstType;
        this.firstFileContent = content;

        //Modify the design of some components
        reInitComponents();
    }    
    
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

        if (rightFormat) {
            //Open actionpanel and display results panel        
            mainFrame.displayResultsPane.setVisible(true);
            mainFrame.actionPanel.setVisible(true);
            mainFrame.displayResultsPane.setVisible(true);

            //This chooser disappears 
            this.setVisible(false);
        } else {
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
            waitMessage.setText("Please chose another file, format should be gtf.");
            return false; //File does not have the right format
        } else {
            //Panels to display text or graphics are visible
            exonsPanel.jLayeredPane1.setVisible(true);
            //Change the card panel according to the selected type pof display
            //Set right card panel
            if (textual) { //Show text
                textualDisplay();
            } else { //Show graphic
                graphicalDisplay();
            }
            return true; //File has the right format
        }
    }

    //Display text with colors for exons, taking into account the type of the first and second files
    private void textualDisplay() {
        exonsPanel.changeCardPanel("textual");
        //Display text exon with propoer colors
        if (gtfFile) //If second chosen file is gtf, first is fasta
        {
            exonsPanel.exonsText(fileContent, firstFileContent);
        } else if (fastaFile)//If second chosen file is fasta, first is gtf
        {
            exonsPanel.exonsText(firstFileContent, fileContent);
        }
    }

    //Set value of textual (true if text has to be shown)
    public void setTextual(boolean textual) {
        this.textual = textual;
    }
    
    //Display graphic for exons representaton
    private void graphicalDisplay(){
        exonsPanel.changeCardPanel("graphical");        
        //Display text exon with propoer colors
        if (gtfFile) //If second chosen file is gtf, first is fasta
        {
            singleGraphicalDisplay(fileContent, firstFileContent);
            
        } else//If second chosen file is fasta, first is gtf
        {
            //Set rectangles coordinates
            singleGraphicalDisplay(firstFileContent, fileContent);
        }
    }
    
    //Graphical display with graphicExons only for single sequence
    private void singleGraphicalDisplay(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent){
        //Only single sequence fasta can be converted to graphic
        
            //Instance of fastaStatistic: determine if the file comports single or multiple sequences
            fastaStatistics fastaStats = new fastaStatistics();
            //Instance of exons
            exons exons = new exons();
            int numberSequences = fastaStats.numberSequence(fastaContent);

            if(numberSequences == 0){
                waitMessage.setText("The fasta file does not have any sequence. Please select another fasta file.");
            }
            else if(numberSequences == 1){
                try{
                //Set rectangles coordinates
                int[][] coordinates = exons.getSingleColoration(gtfContent, fastaContent);
                //Set line coordinates
                String[] annotation = exons.parseAnnotation(fastaContent);
                exonsPanel.graphicExons.setAnnotation(annotation);
                //Set coordinates of rectangle
                exonsPanel.graphicExons.setCoordinates(coordinates);
                //Repaint panel
                exonsPanel.graphicExons.repaint();
                }
                catch(java.lang.OutOfMemoryError ex){
                    waitMessage.setText("Your file is too large to be processed.");
                }
            }
            else if(numberSequences > 1){
                waitMessage.setText("Please choose a fasta file with single sequence for graphical representation");
                System.out.println("Please choose a fasta file with single sequence for graphical representation");
            }
    }
}
