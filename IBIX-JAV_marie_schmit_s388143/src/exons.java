
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
    private exonsData getExons(ArrayList<StringBuffer> gtfContent) {
        //Make a hashmap of each gtf file line
        gtfStatistics gtfStats = new gtfStatistics();

        int i;
        int numero = 1; //Number of exons sequence already stored in hashMap
        int numberExons = 0;
        
        //Create an instance of class exonData to store the results
        exonsData exonsData = new exonsData();

        //Hashmap to store line values
        HashMap<String, String> line = new HashMap<String, String>();
        //Hashmap of exons per gene, containing chromosone name and list of start end indexes of exons
        HashMap<String, int[]> exonsMap = new HashMap<String, int[]>();

        //Scan each line of gtf content
        for (i = 5; i < gtfContent.size(); i++) {
            line = gtfStats.hashLine(gtfContent.get(i)); //Format gtf content to hashMap
            
            //If line is an exon
            if (line.get("Feature").equals("exon")) {
                //Count number of exons
                numberExons ++;

                //If key sequence name does not exist, create it
                if (exonsMap.get(line.get("Sequence name")) == null) { //First exon for this sequence

                    //Store start and end indices in a list of integers
                    int[] indices = {Integer.parseInt(line.get("Start")), Integer.parseInt(line.get("End"))};
                    //exonsMap is a matrix containing the name of an exon sequence and its start and end indices
                    exonsMap.put(line.get("Sequence name"), indices);

                    //Restart numeor: one exon found for this sequence
                    numero = 1;

                    //If key sequence already exist, change it's name 
                    //(one chromosome can have many exons, all have to be stored with a different key name)    
                } else {
                    //Store start and end indices in a list of integers
                    int[] indices = {Integer.parseInt(line.get("Start")), Integer.parseInt(line.get("End"))};
                    //exonsMap is a matrix containing the name of an exon sequence and its start and end indices
                    exonsMap.put(line.get("Sequence name") + numero, indices);
                    numero++; //One more exon fiound for the sequence
                }
            }
        }
        
        exonsData.exonsMap = exonsMap;
        exonsData.numberExons = numberExons;
        return exonsData;
    }
    
    //Use a hashmap of exons (containing their sequence name and their indexes of end and start)
    //Map the indexes of start and end with a single fasta sequence
    //Return an array: each line of the array coontains the start indice and the length of an exon
    public int[][] getSingleColoration(ArrayList<StringBuffer> gtfContent){
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
    
    //Get chromosome and chromosome location from single sequence fasta file annotation
    private HashMap hashAnnotation(ArrayList<StringBuffer> gtfContent) {
        //New hashmap
        HashMap<String, String> hash = new HashMap<String, String>();
        //Names of keys
        String[] keys = {"Sequence name", "Source", "Feature", "Start", "End", "Score", "Strand", "Frame", "Attributes"};

        //Separate each element into list of strings
        String lineText = lineContent.toString();
        String[] line = lineText.split("\t");
        
        //Each value of the gtf line is linked to a key
        for (int i = 0; i < keys.length; i++) {
            hash.put(keys[i], line[i]);
        }

        //Transform attribute into string
        String[] attributes = hash.get("Attributes").split(";");
        //New entry gene id in hashmap (extract only the string after "gene_id")
        String geneID = attributes[0].replace("gene_id ", "");
        geneID = geneID.replace("\"", "");

        hash.put("Gene ID", geneID);

        //Extract gene id from attributes, which is between: gene_id " and: ";
        //Pattern pattern = Pattern.compile("(?<=gene_id\s\").*?(?=\")");
        //Matcher matcher = pattern.matcher(attributes[0]);
        //hash.put("geneID", matcher.group().toString());
        return hash;
    }
    
    
    //Nested class for exons representation and results storages
    public final class exonsData{
        int numberExons;
        HashMap<String, int[]> exonsMap = new HashMap<String, int[]>();
    }
}
