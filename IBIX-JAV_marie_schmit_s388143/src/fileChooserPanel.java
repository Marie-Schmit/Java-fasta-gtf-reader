
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.lang.StringBuffer;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author marie
 */
public class fileChooserPanel extends javax.swing.JPanel {

    /**
     * Creates new form fileChooserPanel
     */
    public fileChooserPanel() {
        initComponents();
        
        this.gtfFile = false;
        this.fastaFile = false;
        
        clearBtn.setVisible(false);
        confirmBtn.setVisible(false);
    }
    
    //Indicates if chosen file is fasta or gtf. If both are false, no file is chosen.
    private boolean gtfFile; //Indicates if selected file is gft
    private boolean fastaFile; //Indicates if selected file is fa
    private ArrayList<StringBuffer> fileContent; //content of the file
    private String fileName; //Name of the selected file
    private String fileChosenMessage; //Message to display in actionFrame, indicating the name of the chosen file
    
    private String fileDirectory; //Name of the selected file directory
    private FileDialog nameBox; //File browser
    private Pattern extension = Pattern.compile(".*\\.(gtf|fa)"); //Regex of files extensions

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        fileBrowserBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchBarFile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        falseFileLbl = new javax.swing.JLabel();
        waitMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(940, 450));

        fileBrowserBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fileBrowserBtn.setText("Browse file");
        fileBrowserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileBrowserBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Please browse a fasta or gtf file");

        searchBarFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarFileActionPerformed(evt);
            }
        });
        searchBarFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarFileKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pick a file");

        falseFileLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        falseFileLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        waitMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setText("Large files take time to process");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(waitMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 87, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBarFile, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileBrowserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(clearBtn)
                        .addGap(44, 44, 44)
                        .addComponent(confirmBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(falseFileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileBrowserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBarFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addComponent(falseFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(waitMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        //No gtf nor fasta file is selected
        gtfFile = false;
        fastaFile = false;
        
        //Clear label indicating which file is selected
        setFileChosenMessage("");
        //CLear search bar
        searchBarFile.setText("");
        
        //Display clear and confirm buttons
        clearBtn.setVisible(false);
        confirmBtn.setVisible(false);
        
        //Delete wait message
        setWaitMessage("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void fileBrowserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileBrowserBtnActionPerformed
        //Fire file chooser when user clicks on button file browser
        nameBox = new FileDialog(new Frame(), "Open gtf or fasta File", FileDialog.LOAD);
        
        //Define search terms according to information in search bar
        searchTerms();
        
        //Display file chooser and wait
        nameBox.setVisible(true);
        
        //Set variables directory and file name
        fileDirectory = nameBox.getDirectory();
        fileName = nameBox.getFile();
        fileName = fileDirectory.concat(fileName);
        
        //Display a message indicating which file was chosen
        setFileChosenMessage(fileName);
              
        //Set clear and confirm buttons to visible
        clearBtn.setVisible(true);
        confirmBtn.setVisible(true);
        falseFileLbl.setText("");
    }//GEN-LAST:event_fileBrowserBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        //Display wait message
        setWaitMessage("Please wait, your selected file is being read...");

        //Set file name to display in panel actionPanel
        setFileChosenMessage(fileName);
        
        //Read file and store it's content
        fileContent = readFile(fileName);
        
        //Set data
        actionPanel.setData(this);
                
        //Open actionpanel and display results panel
        
        mainFrame.displayResultsPane.setVisible(true);
        mainFrame.actionPanel.setVisible(true);
        //Display text area of displayResultsPane
        mainFrame.displayResultsPane.setPanelVisible(true, false, false, false); //Only text panel is visible
        
        this.setVisible(false);
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void searchBarFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarFileActionPerformed

    private void searchBarFileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarFileKeyReleased
    
    }//GEN-LAST:event_searchBarFileKeyReleased

    //Set variable indicate the type of the file (gtf or fatsa). Set message indicating to the user which file was chosen.
    public void setFileChosenMessage(String filename){
        if(fileName.endsWith(".gtf")){
            //Set type of file to gtf
            gtfFile = true;
            fastaFile = false;
            
            //Update message indicating chosen file
            fileChosenMessage = "The chosen gtf file is: " + filename;
            
            //Display message indicating chosen file in label
            falseFileLbl.setText(fileChosenMessage);
        }
        else if(fileName.endsWith(".fa")){
            //Set type of file to fasta
            gtfFile = false;
            fastaFile = true;
            
            //Update message indicating chosen file
            fileChosenMessage = "The chosen fasta file is: " + filename;
            
            //Display message indicating chosen file in label
            falseFileLbl.setText(fileChosenMessage);
        }
        else{
            //Update file type (none)
            fastaFile = false;
            gtfFile = false;
            
            //Display error message text on label
            falseFileLbl.setText("File is neither gtf nor fasta. Please select another file.");
        }
    }
    
    //Define search browser according to information (path or filename) entered in search bar
    public void searchTerms(){
        String path = searchBarFile.getText(); //Text entered by user in search bar
        //If file location entered in text field, set directory
        if(path.endsWith("\\")){
            //Text entered is a path
            nameBox.setDirectory(path);
            nameBox.setFile("*.fa;*.gtf");
        }
        else if(path.matches(".*[\\.](gtf|fa)")){
            //Text entered is a filename
            nameBox.setFile(path);
        }
        else{
            //User can only choose fasta or gtf file
            nameBox.setFile("*.fa;*.gtf");
        }
    }
    
    //Check the type of the chosen file: it can only be .gtf or .fa
    public void checkFileType(String filename){
        if(!filename.matches(".*[\\.](gtf|fa)") | !filename.endsWith("\\")){
            falseFileLbl.setText("Please choose a path, or a fasta or gtf file.");
        }
        else{
            falseFileLbl.setText("  ");
        }
    }
    
    //Argument is a string of the name of the file to red. Read this file and return the result.
    public ArrayList<StringBuffer> readFile(String filename){
        ArrayList<StringBuffer> fileText = new ArrayList<StringBuffer> (); //Contend of the read file
        BufferedReader buffer = null; //Read the text with a BufferedReader
        String inLine; //A line read from the file
        
        try{
            //Create buffered stream
            buffer = new BufferedReader(new FileReader(filename));
            
            //Read a line, append it to the StringBuffer
            while((inLine = buffer.readLine()) != null){
                fileText.add(new StringBuffer(inLine + "\n")); //StringBuffer contains the lines of the file
            }
        }
        //Message if file not found
        catch(FileNotFoundException ex){
            System.out.println("File not found: " + filename);
            falseFileLbl.setText("File not found: " + filename);
        }
        //Message if error occurs
        catch(IOException ex){
            System.out.println(ex.getMessage());
            falseFileLbl.setText(ex.getMessage());
        }
        finally{
            try{
                //Close file if it was not empty
                if(fileText != null) buffer.close();
            }
            //Rause exception if file was empty
            catch(IOException ex){
                System.out.println(ex.getMessage());
                falseFileLbl.setText(ex.getMessage());
            }
        }
        
        return fileText;
    }
    
    //Set variable setWaitMessage
    public void setWaitMessage(String  message){
        waitMessage.setText(message);
    }
    
    //Get methods to get private fileChooserVariable from other classes, which avoid to break the encapsulation of the variables.
    //Get variables gtfFiles and fasta file
    public boolean[] getFileTypes(){
        return new boolean[]{gtfFile, fastaFile};
    }
    
    //Get file content
    public ArrayList<StringBuffer> getFileContent(){
        return fileContent;
    }
    
    //Get filename
    public String getFileName(){
        return fileName;
    }
    
    //Get fileChosenMessage
    public String getFileChosenMessage(){
        return fileChosenMessage;
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel falseFileLbl;
    private javax.swing.JButton fileBrowserBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField searchBarFile;
    private javax.swing.JLabel waitMessage;
    // End of variables declaration//GEN-END:variables
}
