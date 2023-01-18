
import java.awt.CardLayout;

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

        //When creating, only panel choose file should be visible
        secondFileChoose.setVisible(true);

        //Set text of opening
        exonsMainLabel.setText("Please chose a second file, a gtf or fasta for the same genome.");
    }

    //If the display is a text
    private boolean textual;

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
        graphicExons = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        secondFileChoose = new fileChooserPanel(this);
        exonsMainLabel = new java.awt.Label();
        changeFileBtn = new javax.swing.JButton();
        displayExons = new java.awt.Button();

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        textExons.setViewportView(jTextPane);

        jLayeredPane1.setLayer(textExons, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(textExons, "textual");

        graphicExons.setBackground(new java.awt.Color(204, 0, 204));

        label1.setText("graphic");

        javax.swing.GroupLayout graphicExonsLayout = new javax.swing.GroupLayout(graphicExons);
        graphicExons.setLayout(graphicExonsLayout);
        graphicExonsLayout.setHorizontalGroup(
            graphicExonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        graphicExonsLayout.setVerticalGroup(
            graphicExonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(graphicExons, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(graphicExons, "graphical");

        exonsMainLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        changeFileBtn.setText("Change file");
        changeFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFileBtnActionPerformed(evt);
            }
        });

        displayExons.setLabel("Display exons");
        displayExons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayExonsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exonsMainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayExons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeFileBtn)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(secondFileChoose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exonsMainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(displayExons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeFileBtn)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(secondFileChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 61, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFileBtnActionPerformed
        //Go back to panel choice of second file
        secondFileChoose.setVisible(true);
        //Not allow to see graphical or textual panels
        jLayeredPane1.setVisible(true);
    }//GEN-LAST:event_changeFileBtnActionPerformed

    private void displayExonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayExonsActionPerformed
        //Check file type
        checkFileType(mainFrame.fileChooserPanel.getFileTypes(), secondFileChoose.getFileTypes());
        //Allow to see graphical or textual panels
        jLayeredPane1.setVisible(true);
        //Set right card panel
        if(textual)
            changeCardPanel("textual");
        else
            changeCardPanel("graphical");
    }//GEN-LAST:event_displayExonsActionPerformed

    //Set the type of displayed required
    public void setTextualDisplay(boolean textual) {
        this.textual = textual;
    }

    //Check second choosen file type: should be a fasta file
    private void checkFileType(boolean[] firstType, boolean[] secondType) {
        if (firstType[0] && secondType[0]) { //First and second files selected are gtf
            exonsMainLabel.setText("Please chose another file, format should be fasta.");
            secondFileChoose.setVisible(true);
        } else if (firstType[1] && secondType[1]) {//Both files are fasta
            exonsMainLabel.setText("Please chose another file, format should be fasta.");
            secondFileChoose.setVisible(true);
        }
    }

    public void fileChoiceVisibility(boolean choice) {
        if (choice) {
            secondFileChoose.setVisible(true);
        }
        jLayeredPane1.setVisible(false);
    }
    
    public void changeCardPanel(String cardName){
        CardLayout card = (CardLayout)this.jLayeredPane1.getLayout();
        card.show(this.jLayeredPane1, cardName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeFileBtn;
    private java.awt.Button displayExons;
    private java.awt.Label exonsMainLabel;
    private javax.swing.JPanel graphicExons;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextPane jTextPane;
    private java.awt.Label label1;
    private fileChooserPanel secondFileChoose;
    private javax.swing.JScrollPane textExons;
    // End of variables declaration//GEN-END:variables
}
