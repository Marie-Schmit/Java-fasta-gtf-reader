
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
    public int numberSequence(ArrayList<StringBuffer> fileContent) {
        int numberSequence = 0; //Number of sequences

        //Check the number of lines starting with > (indicating a new sequence)
        for (int i = 0; i < fileContent.size(); i++) {
            //Get each line of the file and convert to string
            String line = fileContent.get(i).toString();
            //Check if line starts with <
            if (line.startsWith(">")) {
                numberSequence++; //Number of sequence increments
            }
        }
        return (numberSequence);
    }

    //Caclulate average length of multiple sequences from a list of length
    private double averageLengthSequences(int[] lengthList) {
        int sum = 0;
        int i;
        double average;

        for (i = 0; i < lengthList.length; i++) {
            sum += lengthList[i];
        }
        try {
            average = (sum / i);
            return average;
        } catch (Exception e) {
            System.out.println("Disvision per 0. Number of sequences in fasta file is null. Please try again with another file.");
            return 0;
        }
    }

    //Return list of length
    private int[] listLength(ArrayList<StringBuffer> fileContent, int numberSequences) {
        //Initialisation of list of length
        int[] listLen = new int[numberSequences];
        int sequenceIndex = 0;

        //If the file is empty, length is null
        if (numberSequences == 0) {
            listLen[0] = 0;
        } else {
            for (int i = 0; i < fileContent.size(); i++) {
                String line = fileContent.get(i).toString(); //Set line of text

                if (!line.startsWith(">")) { //Is a sequence
                    listLen[sequenceIndex] = (line.length()); //Add length of stringBuffer to list of length
                    sequenceIndex++;
                }
            }
        }

        return listLen;
    }

    //Calculate sequence length or average of sequences length for given file content
    public lengthResult statisticSeqLength(ArrayList<StringBuffer> fileContent) {
        int numberSequences = numberSequence(fileContent);

        if (numberSequences == 1) { //Only one sequence
            int numberLines = fileContent.size() - numberSequences; //Number of lines of the sequence
            int lenList[] = listLength(fileContent, numberLines); //List with the length of avery line of the sequence
            int len = 0; //Length initialisation

            //Sum all the length of the sequence
            for (int val : lenList) {
                len += val;
            }

            return new lengthResult(len, "single");
        } else { //Multiple sequences
            double average = averageLengthSequences(listLength(fileContent, numberSequences));
            return new lengthResult(average, "multiple");
        }
    }

    //Class to return results of length calculation (length value and indication of single or multiple sequences)
    final class lengthResult {

        private final double length;
        private final String sequenceType;

        public lengthResult(double length, String sequenceType) {
            this.length = length;
            this.sequenceType = sequenceType;
        }

        public double getLength() {
            return this.length;
        }

        public String getType() {
            return this.sequenceType;
        }
    }

    //Calculate number of G and umber of C characters in one string
    private int[] numberGC(StringBuffer line) {
        int numberG = 0;
        int numberC = 0;

        for (int i = 0; i < line.length(); i++) {
            if (!line.toString().startsWith(">")) { //Only consider sequences
                //Count number of g or G in the line
                if (line.charAt(i) == ('G' | 'g')) { //If character is a G
                    numberG++;
                } //Count number of C and c in the line
                else if (line.charAt(i) == ('C' | 'c')) {
                    numberC++;
                }
            }
        }
        int counts[] = {numberG, numberC};
        return counts; //Return a list of number of G and number of C in the considered line
    }

    //Calculate G/C content of all the sequences of a fasta file
    public double getGC(ArrayList<StringBuffer> fileContent) {
        int numberG = 0; //Number of G in all the sequences
        int numberC = 0; //Number of C in all the sequences
        double gc; //Value of GC content

        for (int i = 0; i < fileContent.size(); i++) {
            //Get a list of the number of G and C in the line if the line is a sequence
            int counts[] = new int[2];
            counts = numberGC(fileContent.get(i));

            //Actualise number of G and C in all the sequences
            numberG++;
            numberC++;
        }
        //Division by 0 if number of C is null
        if (numberC == 0) {
            gc = 0;
            //Throw exception
            throw new IllegalStateException("Division by 0. The number of C in fasta file sequence is null. File might be empty, please try with a new file.");
        } else {
            gc = numberG / numberC; //Calculate GC content
        }
        return gc;
    }
}
