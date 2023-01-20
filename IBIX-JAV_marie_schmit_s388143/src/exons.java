
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author marie
 */
public class exons {

    public exons() {

    }

    public ArrayList<int[][]> getMultipleColoration(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent) {
        int lenAnnotation = 0; //Length of the annotation line before a sequence
        int lenPreviousLines = 0; //Sum of the length of all the previous sequences

        int numberSequences = fastaContent.size() / 2; //Number of sequences in the file

        ArrayList<int[][]> allIndexes = new ArrayList<int[][]>();
        int lenAnnotations = 0; //Sum of length of annotations
        int lenSequences = 0; //Sum of length of sequences

        //Parse 2 lignes of annotation and sequence in an ArrayList of StringBuffer
        for (int seq = 0; seq < fastaContent.size() - 1; seq += 2) {
            //Get annotation
            StringBuffer annotation = new StringBuffer(fastaContent.get(seq));
            //Get sequence
            StringBuffer sequence = new StringBuffer(fastaContent.get(seq + 1));

            //Calculate len of sum of annotations
            lenAnnotations += annotation.length() + 1; //For text display character of line return "\n" is added at the end of annotatoin line

            //Add them into an ArrayList
            ArrayList singleSeq = new ArrayList();
            singleSeq.add(annotation);
            singleSeq.add(sequence);

            //This arrayList is like a fasta file with a single sequence
            int[][] indexSequence = getSingleColoration(gtfContent, singleSeq);

            //The index of start must take the length of the previous lines (annotations and sequences) into account
            for (int i = 0; i < indexSequence.length; i++) {
                //If start is not null
                if (indexSequence[i][1] != 0) {
                    indexSequence[i][0] += lenSequences;
                }
            }
            //Actualise len of sequences
            lenSequences += sequence.length() + 1; //For text display, a character \n return is added at the end of the sequence
            //Add matrix of each sequence on matrix of all the sequences
            allIndexes.add(indexSequence);
        }

        return allIndexes;
    }

    //Get a hashmap of exons from gtf file.  The map contains the name of the sequence, start and end position of exons.
    public int[][] getSingleColoration(ArrayList<StringBuffer> gtfContent, ArrayList<StringBuffer> fastaContent) {
        //Make a hashmap of each gtf file line
        gtfStatistics gtfStats = new gtfStatistics();

        //Fasta annotation
        String[] fastaAnnotation = parseAnnotation(fastaContent);

        //Hashmap to store line values
        HashMap<String, String> line = new HashMap<String, String>();
        //Hashmap of exons per gene, containing chromosone name and list of start end indexes of exons
        HashMap<String, int[]> exonsMap = new HashMap<String, int[]>();

        //Index of coloration
        int[] indexColoration;
        //Matrix containing indexes of coloration for each row
        int[][] indexMatrix = new int[gtfContent.size()][2];

        //Scan each line of gtf content, starting at 5th line
        for (int row = 5; row < gtfContent.size(); row++) {
            line = gtfStats.hashLine(gtfContent.get(row)); //Format gtf content to hashMap

            //If index of coloration is not null, add index to matrix row
            indexColoration = isGtfExon(line, fastaAnnotation);

            //Add to matrix
            indexMatrix[row] = indexColoration;
            /*
            if (indexMatrix[row][1] > 0) {
                System.out.print("x, len " + indexMatrix[row][0] + " " + indexMatrix[row][1] + "\n");
            }
*/
        }
        return indexMatrix;
    }

    //Scan a line of gtf file, compare to fasta information to determine if line is an exon of the right chromosome, overlapping the fasta sequence
    //In case of overlapping, calculate the indexes of coloration
    //Parameters are a line of gtf file, alreayd hashed in a map, and a string contanaining information on fasta annotation
    private int[] isGtfExon(HashMap<String, String> line, String[] fastaAnnotation) {
        //Line is an exon
        boolean feature = line.get("Feature").equals("exon");

        //Sequence from fasta and gtf exons must overlap each other
        //Parse fasta and gtf ends and starts to integers
        int gtfStart = Integer.parseInt(line.get("Start"));
        int gtfEnd = Integer.parseInt(line.get("End"));
        int faStart;
        int faEnd;

        boolean chromosome; //Is the chromosome right?

        //If file has long annotations
        if (fastaAnnotation.length > 3) {
            //Line corresponds to the right chromosome, indicated in fasta annotation
            chromosome = line.get("Sequence name").endsWith(fastaAnnotation[3]);
            faStart = Integer.parseInt(fastaAnnotation[4]);
            faEnd = Integer.parseInt(fastaAnnotation[5]);
        } else {
            //Line corresponds to the right chromosome, indicated in fasta annotation
            chromosome = line.get("Sequence name").endsWith(fastaAnnotation[0]);
            faStart = Integer.parseInt(fastaAnnotation[1]);
            faEnd = Integer.parseInt(fastaAnnotation[2]);
        }

        //Store indexes of coloration
        int[] indexColoration = {0, 0};

        //No overlapping if gtf ends before start of fasta
        //No overlapping if gtf starts after fasta
        boolean overlap = !((gtfEnd < faStart) || (gtfStart > faEnd));

        if (overlap) {
            //Store the start index of coloration, and it length
            indexColoration = colorationIndex(gtfStart, gtfEnd, faStart, faEnd);
        }

        return indexColoration;
    }

    //Return start and length of coloration, from start and end indices of gtf and fasta
    private int[] colorationIndex(int gtfStart, int gtfEnd, int faStart, int faEnd) {
        //Start, end and length of colored sequence
        int start = 0;
        int end = 0;

        //Set values of colored sequence indexes
        if (gtfStart > faStart) //gtf sequence starts after fasta sequence
        {
            start = gtfStart;
        } else if (gtfStart < faStart) //gtf sequence starts before fasta sequence
        {
            start = faStart;
        }
        if (gtfEnd > faEnd) //gtf sequence ends after fasta sequence
        {
            end = faEnd;
        } else if (gtfEnd < faEnd) //gtf sequence ends before fasta sequence
        {
            end = gtfEnd;
        }

        //The start of the fasta file has an index of 0. Set the index of start:
        int startIndex = start - faStart;
        //Set the length
        int length = end - start;
        //Sequence cannot end before start
        if (length < 0) {
            length = 0;
        }

        //Set start and length of coloration
        int[] index = {startIndex, length};

        return index;
    }

    //Get chromosome and chromosome location from single sequence fasta file annotation
    private String[] parseAnnotation(ArrayList<StringBuffer> fastaContent) {
        StringBuffer lineContent = fastaContent.get(0); //First line of the file, containing the annotation

        //Separate each element into list of strings
        String lineText = lineContent.toString(); //String buffer into string

        String[] line = lineText.split(":"); //Split at each ":"

        //If annotations are shortest
        if (line.length == 2) {
            //Split the second object of line
            String[] splitLine = line[1].split("-");

            String[] newLine = new String[3];
            newLine[0] = line[0];
            newLine[1] = splitLine[0];
            newLine[2] = splitLine[1].replaceAll("\n", "");

            return newLine;
        } else {
            return line;
        }
    }

    //Graphical representatoin of exons. Return coordinates of each exon rectangle
    public ArrayList<int[]> exonsGraphical(int[][] indexes, int panelHeight, int panelWidth) {
        //Matrix with the coordinates (start and length) of exons]
        int[][] indexMatrix = indexes;

        //Store rectangles coordinates
        ArrayList<int[]> coordinates = new ArrayList<int[]>();

        int y = 100; //y position of rectangle
        int height = 20; //Height of rectangle

        for (int exon = 0; exon < indexMatrix.length; exon++) {
            if (indexMatrix[exon][1] > 0) { //If the length of the exon is not null
                int x = (int)(indexMatrix[exon][0] * 0.05); //x coordinate of rectangle
                int width = (int)(indexMatrix[exon][1] * 0.1);  //Width of rectangle
                
                //If exon is too long, avoid that graphical goes out of the screening with a return to line of the graph
                /*
                if((x + width) > panelWidth){
                    y += 40; //Displayed on another line
                    x -= panelWidth; //Go back to begining of the line
                }
*/

                int[] rectCoordinates = {x, y, width, height};
                System.out.print("x, y, h, w " + x + " " + y + " " + width + " " + height + "\n");
                coordinates.add(rectCoordinates); //Add coordinates in ArrayList
            }
        }
        return coordinates;
    }

}
