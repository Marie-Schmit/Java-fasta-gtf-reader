
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marie
 */
public class fastaStatistics {
    //Constructor
    public fastaStatistics() {

    }
        
    //Calculates number of sequences in the fasta file (passed as ArrayList)
    private int numberSequence(ArrayList<StringBuffer> fileContent){
        int numberSequence = 0; //Number of sequences
        
        //Check the number of lines starting with > (indicating a new sequence)
        for (int i = 0; i < fileContent.size(); i++){
            //Get each line of the file and convert to string
            String line = fileContent.get(i).toString();
            //Check if line starts with <
            if(line.startsWith(">")){
                numberSequence ++; //Number of sequence increments
            }
        }
        return (numberSequence);
    }
    
    //Caclulate average length of multiple sequences from a list of length
    private double averageLengthSequences(int[] lengthList){
        int sum = 0;
        int i;
        double average;
        
        for (i = 0; i < lengthList.length; i++){
            sum += lengthList[i];
        }
        try{
            average = (sum/i);
            return average;
        }
        catch(Exception e){
            System.out.println("Disvision per 0. Number of sequences in fasta file is null. Please try again with another file.");
            return 0;
        }
    }
    
    //Return list of length
    private int[] listLength(ArrayList<StringBuffer> fileContent, int numberSequences){
        int[] listLen = new int[numberSequences]; //Initialisation of list of length
        int sequenceIndex = 0;
        
        for(int i=0; i < fileContent.size(); i++){
            String line = fileContent.get(i).toString(); //Set line of text
            
            if(!line.startsWith(">")){ //Is a sequence
                listLen[sequenceIndex] = (line.length()); //Add length of stringBuffer to list of length
                sequenceIndex ++;
            }
        }
        return listLen;
    }
    
    //Calculate sequence length or average of sequences length for given file content
    public lengthResult statisticSeqLength(ArrayList<StringBuffer> fileContent){
        int numberSequences = numberSequence(fileContent);
        
        if(numberSequences == 1){ //Only one sequence
            double len = (double)listLength(fileContent, numberSequences)[0];
            return new lengthResult(len, "single");
        }
        else{ //Multiple sequences
            double average = averageLengthSequences(listLength(fileContent, numberSequences));
            return new lengthResult(average, "multiple");
        }
    }
}

//Class to return results of length calculation (length value and indication of single or multiple sequences)
final class lengthResult{
    private final double length;
    private final String sequenceType;
    
    public lengthResult(double length, String sequenceType){
        this.length = length;
        this.sequenceType = sequenceType;
    }
    
    public double getLength(){
        return length;
    }
    
    public String getType(){
        return sequenceType;
    }
    
}
