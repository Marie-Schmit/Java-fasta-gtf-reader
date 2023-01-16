
import java.awt.Container;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author marie
 */
public class actionPanel extends javax.swing.JPanel {

    /**
     * Creates new form actionPanel
     */
    public actionPanel() {
        initComponents();
                
        //Delete the arrow icon of the internal frame
        Container pane = ((BasicInternalFrameUI) internalFrame.getUI()).getNorthPane();
        pane.remove(0);
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chosenFileLbl = new javax.swing.JLabel();
        newFileBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        internalFrame = new javax.swing.JInternalFrame();
        menuBar = new javax.swing.JMenuBar();
        gtfMenuDisplayText = new javax.swing.JMenu();
        gtfMenuStats = new javax.swing.JMenu();
        menuLongestShortestModel = new javax.swing.JMenuItem();
        menuLongestShortestModels = new javax.swing.JMenuItem();
        menuAverageGeneLength = new javax.swing.JMenuItem();
        gtfMenuAllStats = new javax.swing.JMenuItem();
        gtfMenuExons = new javax.swing.JMenu();
        menuTextExons = new javax.swing.JMenuItem();
        menuGraphExons = new javax.swing.JMenuItem();
        menuExonsAllDisplay = new javax.swing.JMenuItem();
        fastaMenuDisplayText = new javax.swing.JMenu();
        fastaMenuStats = new javax.swing.JMenu();
        menuSequenceLen = new javax.swing.JMenuItem();
        menuGcContent = new javax.swing.JMenuItem();

        chosenFileLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chosenFileLbl.setLabelFor(chosenFileLbl);

        newFileBtn.setText("New file");
        newFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileBtnActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        internalFrame.setBorder(null);
        internalFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        internalFrame.setEnabled(false);
        internalFrame.setFocusable(false);
        internalFrame.setFrameIcon(null);
        internalFrame.setVisible(true);

        menuBar.setBorder(null);

        gtfMenuDisplayText.setText("Display text");
        menuBar.add(gtfMenuDisplayText);

        gtfMenuStats.setText("gtf statistics");

        menuLongestShortestModel.setText("Average number of exons");
        menuLongestShortestModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLongestShortestModelActionPerformed(evt);
            }
        });
        gtfMenuStats.add(menuLongestShortestModel);

        menuLongestShortestModels.setText("Longest shortest genes models");
        gtfMenuStats.add(menuLongestShortestModels);

        menuAverageGeneLength.setText("Average gene length");
        menuAverageGeneLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAverageGeneLengthActionPerformed(evt);
            }
        });
        gtfMenuStats.add(menuAverageGeneLength);

        gtfMenuAllStats.setText("All statistics");
        gtfMenuStats.add(gtfMenuAllStats);

        menuBar.add(gtfMenuStats);

        gtfMenuExons.setText("Exons");

        menuTextExons.setText("Display exons textually");
        gtfMenuExons.add(menuTextExons);

        menuGraphExons.setText("Display exons graphically");
        gtfMenuExons.add(menuGraphExons);

        menuExonsAllDisplay.setText("Display exons textually and graphically");
        gtfMenuExons.add(menuExonsAllDisplay);

        menuBar.add(gtfMenuExons);

        fastaMenuDisplayText.setText("Display text");
        menuBar.add(fastaMenuDisplayText);

        fastaMenuStats.setText("fasta statistics");

        menuSequenceLen.setText("Sequence length");
        fastaMenuStats.add(menuSequenceLen);

        menuGcContent.setText("GC content");
        fastaMenuStats.add(menuGcContent);

        menuBar.add(fastaMenuStats);

        internalFrame.setJMenuBar(menuBar);

        javax.swing.GroupLayout internalFrameLayout = new javax.swing.GroupLayout(internalFrame.getContentPane());
        internalFrame.getContentPane().setLayout(internalFrameLayout);
        internalFrameLayout.setHorizontalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        internalFrameLayout.setVerticalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(internalFrame)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chosenFileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newFileBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(internalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void newFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileBtnActionPerformed
        //Bring the fileChooserPanel back
        this.setVisible(false);
        mainFrame.fileChooserPanel.setVisible(true);   
    }//GEN-LAST:event_newFileBtnActionPerformed

    private void menuLongestShortestModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLongestShortestModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLongestShortestModelActionPerformed

    private void menuAverageGeneLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAverageGeneLengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAverageGeneLengthActionPerformed

    private void displayText(String filename){
        /*
        int i;
        //Display every line of the saved text
        for (i = 0; i<fileChooserPanel.fileContent.size(); i++){
            textArea.setText(fileChooserPanel.fileContent.get(i).toString());
        }
        */
    }
    
    //Display different menu items according to the chosen file
    public static void setMenu(fileChooserPanel fileChooser){
        if(fileChooser.gtfFile){
            gtfMenuExons.setVisible(false);
            gtfMenuStats.setVisible(true);
        }
        else if(fileChooser.fastaFile){
            gtfMenuExons.setVisible(true);
            gtfMenuStats.setVisible(false);
        }
    }
    
    
    //Display information from the previous panel and the chosen file to this panel
    public static void setData(fileChooserPanel fileChooser){
        //Display message of which file was chosen
        chosenFileLbl.setText(fileChooser.fileChosenMessage);
        setMenu(fileChooser);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel chosenFileLbl;
    private javax.swing.JMenu fastaMenuDisplayText;
    private javax.swing.JMenu fastaMenuStats;
    private javax.swing.JMenuItem gtfMenuAllStats;
    private static javax.swing.JMenu gtfMenuDisplayText;
    private javax.swing.JMenu gtfMenuExons;
    private static javax.swing.JMenu gtfMenuStats;
    private javax.swing.JInternalFrame internalFrame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuAverageGeneLength;
    private static javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuExonsAllDisplay;
    private javax.swing.JMenuItem menuGcContent;
    private javax.swing.JMenuItem menuGraphExons;
    private javax.swing.JMenuItem menuLongestShortestModel;
    private javax.swing.JMenuItem menuLongestShortestModels;
    private javax.swing.JMenuItem menuSequenceLen;
    private javax.swing.JMenuItem menuTextExons;
    private javax.swing.JButton newFileBtn;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
