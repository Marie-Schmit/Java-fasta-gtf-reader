
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author marie
 */
public class displayResultsPane extends javax.swing.JPanel {

    /**
     * Creates new form displayResultsPane
     */
    
    //Present page
    private int presentPage;
    //Maximum number of pages
    private int maxPages;
    
    /*
    static String columns[] = {"Sequence name", "Source", "Feature", "Start", "End", "Score", "Strand", "Frame", "Attribute"};
    private static DefaultTableModel tableModel = new DefaultTableModel(columns,0);
    /*
    /*
        //Set columns of default table
        String columns[] = {"Sequence name", "Source", "Feature", "Start", "End", "Score", "Strand", "Frame", "Attribute"};
        //Initialisation of default table model for gtf files
        tableModel = new DefaultTableModel(columns,0);
        System.out.println(tableModel == null);
    */
    
    public displayResultsPane() {
        presentPage = 0;
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

        tabPanel = new javax.swing.JPanel();
        gtfTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textPanel = new javax.swing.JPanel();
        textArea = new java.awt.TextArea();
        nextBtn = new javax.swing.JButton();
        previousBtn = new javax.swing.JButton();
        pageNumberLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        goToPageField = new javax.swing.JTextField();
        goBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(900, 400));
        setLayout(new java.awt.CardLayout());

        gtfTable.setFocusable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(

            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sequence name", "Source", "Feature", "Start", "End", "Score", "Strand", "Frame", "Attribute"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gtfTable.setViewportView(jTable1);

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gtfTable, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gtfTable, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );

        add(tabPanel, "tableCard");

        textArea.setBackground(new java.awt.Color(240, 240, 240));

        nextBtn.setText("Next page");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        previousBtn.setText("Previous page");
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Go to page: ");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        goBtn.setText("Go");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pageNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToPageField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(previousBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextBtn)
                .addContainerGap())
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn)
                    .addComponent(previousBtn)
                    .addComponent(pageNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(goToPageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBtn)))
        );

        add(textPanel, "textCard");
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        //Increment present page number
        presentPage++;
        
        //Display text on text area, presentPage
        displayText(mainFrame.fileChooserPanel.getFileContent(), presentPage);
        
        //Buttons visibility
        nextPreviousBtnVisible();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        //Decremente present page number
        presentPage--;       
        
        //Display text on text area, presentPage
        displayText(mainFrame.fileChooserPanel.getFileContent(), presentPage);
        
        //Change buttons visibility
        nextPreviousBtnVisible();
    }//GEN-LAST:event_previousBtnActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        int pageNumber = Integer.parseInt(goToPageField.getText()); //Desired page
        
        //If entered page does not correspond
        if((pageNumber < 0) || (pageNumber > maxPages)){
            displayText("Number of pages must be contained between 0 and " + maxPages + ". Please retry.");
        }
        else{
            //New current page
            presentPage = Integer.parseInt(goToPageField.getText());

            //Change buttons visibility
            nextPreviousBtnVisible();

            //Display text
            displayText(mainFrame.fileChooserPanel.getFileContent(), presentPage);
        }
    }//GEN-LAST:event_goBtnActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorAdded

    //Switch panels
    public void switchLastPanel(String cardName) {
        //Make this panel visible
        this.setVisible(true);
        //Define a card layout
        this.setLayout(new java.awt.CardLayout());
        CardLayout card = (CardLayout) (this.getLayout());
        card.show(this, cardName);
    }

    //Display text stored in StringBuffer, in an ArrayList in text area, one page at a time
    public void displayText(ArrayList<StringBuffer> textContent, int pageNumber) {
        int startLine;
        int endLine;
        
        maxPages = maxNumberPages(textContent);
        
        //Set page number
        pageNumberLbl.setText("Page " + pageNumber + "/" + maxPages);
        
        //Reset text area
        textArea.setText(null);
        
        //Set end and start lines for ta page
        startLine = 1000*pageNumber;
        endLine = startLine + 1000;
        
        //End line cannot be higher than maximum number of lines
        if(endLine >= textContent.size()) endLine = textContent.size();
        
        //Display lines in this interval
        displayPage(textContent, startLine, endLine);     
    }
    
    //Override displayText method, to display strings
    public void displayText(String textContent) {
        //Reset text area
        textArea.setText(null);
        
        //Add new string to text area
        textArea.append(textContent);
    }
    
    
    //Display lines in table, for gtf file
    public void displayTable(String[] row){
        int i;
        
        //Set default table of jTable1
        DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
        
        //String[] row = {"chr1", "HAVANA", "gene", "11869", "14409", ".","+", ".","gene_id ENSG00000290825.1; gene_type lncRNA; gene_name DDX11L2; level 2; tag overlaps_pseudogene"};
        tableModel.addRow(row);

        //Resize col 9 of table
        setTableSize(jTable1, 8);
    }
    
    //Resize colulumn of index colNumber of JTable table
    public void setTableSize(JTable table, int colNumber){
        TableColumn tableCol = table.getColumnModel().getColumn(colNumber); //get desired column
        
        //Set initial width
        int bestWidth = tableCol.getMinWidth();
        
        //For each row
        int i;
        for (i=0; i < table.getRowCount(); i++){
            //Get component used to draw the cell
            TableCellRenderer render = table.getCellRenderer(i, colNumber);
            //Prepare the renderer of a cell
            Component component = table.prepareRenderer(render, i, colNumber);
            int width;
            //Calculate width
            width = component.getPreferredSize().width + table.getIntercellSpacing().width; //New width is based on preferred width and space of cells
            //The width of the column is the maximal width of all rows
            bestWidth = Math.max(bestWidth, width); //Keep maximal width, i)
        }
        
        tableCol.setPreferredWidth(bestWidth);
        
        
    }
    
    //Get maximal number of pages
    public int maxNumberPages(ArrayList<StringBuffer> textContent){
        int maxNumber;
        
        //Calculate maximum page number
        maxNumber = textContent.size()/1000;
        
        //Last lines on last page
        if(maxNumber%1000 != 0){
            maxNumber ++;
        }
        
        return maxNumber;
    }
    
    //Set next and previous buttons visibility
    public void nextPreviousBtnVisible(){
        //If maximal number of page attained
        if(presentPage + 1 >= maxPages){
            nextBtn.setVisible(false);
        }
        else{
            nextBtn.setVisible(true);
        }
        //Set previous button to visible when page number is more than 0
        if(presentPage - 1 > 0){
            previousBtn.setVisible(true);
        }
        //Set previous button to unvisible
        else{
            previousBtn.setVisible(false);
        }
    }
    
    //Display one page of text (1000 lines)
    public void displayPage(ArrayList<StringBuffer> textContent, int startLine, int endLine){
        int i;
        for (i = startLine; i < endLine; i++) {
            textArea.append(textContent.get(i).toString() + "\n");
        }
    }
    
    //Set next button to visible or invisible
    public void setNextBtnVisible(boolean visibility){
        nextBtn.setVisible(visibility);
    }
    
    //Set previous button to visible or invisible
    public void setPreviousBtnVisible(boolean visibility){
        previousBtn.setVisible(visibility);
    }
    
    //Set page number
    public void setPageNumber(int newNumber){
        presentPage = newNumber;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBtn;
    private javax.swing.JTextField goToPageField;
    private javax.swing.JScrollPane gtfTable;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel pageNumberLbl;
    private javax.swing.JButton previousBtn;
    public static javax.swing.JPanel tabPanel;
    private java.awt.TextArea textArea;
    public static javax.swing.JPanel textPanel;
    // End of variables declaration//GEN-END:variables
}
