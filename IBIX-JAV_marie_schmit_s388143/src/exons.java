
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
            
                    
            //Add to matrix if coloration indexes are not null
            indexMatrix[row] = indexColoration;
        }
        
        
        
        return indexMatrix;
    }

    //Scan a line of gtf file, compare to fasta information to determine if line is an exon of the right chromosome, overlapping the fasta sequence
    //In case of overlapping, calculate the indexes of coloration
    //Parameters are a line of gtf file, alreayd hashed in a map, and a string contanaining information on fasta annotation
    private int[] isGtfExon(HashMap<String, String> line, String[] fastaAnnotation) {
        //Line is an exon
        boolean feature = line.get("Feature").equals("exon");

        //Line corresponds to the right chromosome, indicated in fasta annotation
        boolean chromosome = line.get("Sequence name").endsWith(fastaAnnotation[3]);

        //Sequence from fasta and gtf exons must overlap each other
        //Parse fasta and gtf ends and starts to integers
        int gtfStart = Integer.parseInt(line.get("Start"));
        int gtfEnd = Integer.parseInt(line.get("End"));
        int faStart = Integer.parseInt(fastaAnnotation[4]);
        int faEnd = Integer.parseInt(fastaAnnotation[5]);
        
        //Store indexes of coloration
        int[] indexColoration = {0,0};

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
        if(length < 0)
            length =0;
        
        //Set start and length of coloration
        int[] index = {startIndex, length};

        return index;
    }

    /*
    //Use a hashmap of exons (containing their sequence name and their indexes of end and start)
    //Map the indexes of start and end with a single fasta sequence
    //Return an array: each line of the array coontains the start indice and the length of an exon
    public int[][] getSingleColoration(ArrayList<StringBuffer> gtfContent) {
        //Create instance of class exonData to number of exons and hashmap
        exonsData exonsData = getExons(gtfContent);

        //Get number of exons
        int numberExons = exonsData.numberExons;
        //Get HashMap of all exons
        HashMap<String, int[]> exonsMap = exonsData.exonsMap;

        //Matrix to store in each row the start indexes, and length, of colored characters of the sequence
        int[][] indexMatrix = new int[numberExons][2];
        int row = 0; //Index of row in matrix

        //For every element in the hashmap
        for (Map.Entry<String, int[]> exon : exonsMap.entrySet()) {
            int start = exon.getValue()[0];
            int end = exon.getValue()[1];
            int length = end - start;

            //Store start and length in the matrix
            indexMatrix[row][0] = start;
            indexMatrix[row][1] = length;

            //Next row
            row++;
        }

        for (int i = 0; i < indexMatrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < indexMatrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(indexMatrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        return indexMatrix;
    }
*/

    //Get chromosome and chromosome location from single sequence fasta file annotation
    private String[] parseAnnotation(ArrayList<StringBuffer> fastaContent) {
        StringBuffer lineContent = fastaContent.get(0); //First line of the file, containing the annotation

        //Separate each element into list of strings
        String lineText = lineContent.toString(); //STring buffer into string
        String[] line = lineText.split(":"); //Split at each ":"

        return line;
    }
}
