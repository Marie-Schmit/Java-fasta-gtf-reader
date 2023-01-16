
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
        
        if(fileChooserPanel.gtfFile){
            System.out.println(fileChooserPanel.gtfFile);
            jMenu1.setVisible(false);
        }
        else if(fileChooserPanel.gtfFile){
            System.out.println(fileChooserPanel.fastaFile);
            jMenu1.setVisible(true);
        }
        
        //Write what is the chosen file
        //chosenFileLbl.setVisible(true);
        //chosenFileLbl.setText(fileChooserPanel.fileName);
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
        menuDisplayText = new javax.swing.JMenu();
        menuStats = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        chosenFileLbl.setLabelFor(chosenFileLbl);
        chosenFileLbl.setText("The actual file is: " + fileChooserPanel.fileName);

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

        menuDisplayText.setText("Display text");
        menuBar.add(menuDisplayText);

        menuStats.setText("Statistics");

        jMenuItem1.setText("jMenuItem1");
        menuStats.add(jMenuItem1);

        menuBar.add(menuStats);

        jMenu1.setText("jMenu1");
        menuBar.add(jMenu1);

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
                        .addComponent(chosenFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(chosenFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileBtnActionPerformed
        //Bring the fileChooserPanel back
        this.setVisible(false);
        mainFrame.fileChooserPanel.setVisible(true);   
    }//GEN-LAST:event_newFileBtnActionPerformed

    private void displayText(String filename){
        int i;
        //Display every line of the saved text
        for (i = 0; i<fileChooserPanel.fileContent.size(); i++){
            textArea.setText(fileChooserPanel.fileContent.get(i).toString());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chosenFileLbl;
    private javax.swing.JInternalFrame internalFrame;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDisplayText;
    private javax.swing.JMenu menuStats;
    private javax.swing.JButton newFileBtn;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
