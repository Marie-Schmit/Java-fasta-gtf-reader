
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author marie
 */
public class exonsPanel extends javax.swing.JPanel {

    /**
     * Creates new form exonsPanel
     */
    public exonsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        textExons = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        graphicExons = new graphicExons();
        secondFileChooser = new secondFileChooserPanel(this);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        textExons.setViewportView(jTextPane);

        jLayeredPane1.setLayer(textExons, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(textExons, "textual");

        javax.swing.GroupLayout graphicExonsLayout = new javax.swing.GroupLayout(graphicExons);
        graphicExons.setLayout(graphicExonsLayout);
        graphicExonsLayout.setHorizontalGroup(
            graphicExonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );
        graphicExonsLayout.setVerticalGroup(
            graphicExonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(graphicExons, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(graphicExons, "graphical");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(secondFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(secondFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void fileChoiceVisibility(boolean choice) {
        if (choice) {
            secondFileChooser.setVisible(true);
        }
        jLayeredPane1.setVisible(false);
    }

    public void changeCardPanel(String cardName) {
        CardLayout card = (CardLayout) this.jLayeredPane1.getLayout();
        card.show(this.jLayeredPane1, cardName);
    }

    private void textLineExons(int[][] offsetLength, String text){
        jTextPane.setText(text);
        //Creat attribute set to change color
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setForeground(attributes, Color.cyan);
        
        //Apply to some parts of text
        StyledDocument styleDoc = jTextPane.getStyledDocument();
        for(int row = 0; row < offsetLength.length; row++){
            styleDoc.setCharacterAttributes(offsetLength[row][0], offsetLength[row][1], attributes, false);
        }
    }
    
    //Display all the text and set every line to the right color
    public void textExonsSingle(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent){
        //Concat text into a single string
        String text = "";
        
        //Instance of exons
        exons exons = new exons();
        
        //Matrix with start and length coordinates
        int[][] offsetLength = exons.getSingleColoration(gtfContent, fastaContent);
        
        for (int i = 1; i < fastaContent.size(); i++){ //The first line is the sequence indication
            text += fastaContent.get(i).toString(); //Add every line of the file to the text to display
        }
        
        //Put proper colors to the text
        textLineExons(offsetLength, text);
    }
    
    //Display colored lignes for exons
    public void textExonsMultiple(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent){
        exons exons = new exons();
        
        //ArrayList, each Array is a matrix of sequence indexs
        ArrayList<int[][]> indexSequences = new ArrayList<int[][]>();
        indexSequences = exons.getMultipleColoration(gtfContent, fastaContent);
        
        //Count number of line return that are added
        int moreCharacters = 0;
        
        String text = "";
        //Text is the file content
        for (int i = 0; i < fastaContent.size(); i++){ //The first line is the sequence indication
            text += fastaContent.get(i).toString(); //Add every line of the file to the text to display
            text += "\n";
        }        
        
        jTextPane.setText(text);
        //Creat attribute set to change color
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setForeground(attributes, Color.cyan);
        
        //Apply to some parts of text
        StyledDocument styleDoc = jTextPane.getStyledDocument();
        
        //Define each position of color
        for(int seq = 0; seq < indexSequences.size(); seq++){//One matrix of positions per sequence
            //Get the matrix of indexes of the sequence seq
            int[][] offsetLength = indexSequences.get(seq);
        }
    }
    
    //Display colored lines for exons, with distinction between single or multiple lines in fasta file
    public void exonsText(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent){
        //Instance of fastaStatistic: determine if the file comports single or multiple sequences
        fastaStatistics fastaStats = new fastaStatistics();
        
        int numberSequences = fastaStats.numberSequence(fastaContent);
        
        if(numberSequences == 0){
            jTextPane.setText("The fasta file does not have any sequence. Please select another fasta file.");
        }
        else if(numberSequences == 1){
            textExonsSingle(gtfContent, fastaContent);
        }
        else if(numberSequences > 1){
            textExonsMultiple(gtfContent, fastaContent);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public graphicExons graphicExons;
    public javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextPane jTextPane;
    public secondFileChooserPanel secondFileChooser;
    private javax.swing.JScrollPane textExons;
    // End of variables declaration//GEN-END:variables
}
