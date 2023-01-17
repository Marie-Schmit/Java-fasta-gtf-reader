
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
public class gtfStatistics {
    //Constructor
    public gtfStatistics(){
        
    }
  
    //Average number of exons per gene
    private double avgNumberExons;
    //Infinite length value
    private final int HIGH_LENGTH = 1000000;
    
    //////////////////////////////////////// Calculation of average number of exons per gene ///////////////////////////////
    //Hashmap of each line
    private HashMap hashLine(StringBuffer lineContent){
        //New hashmap
        HashMap<String, String> hash = new HashMap<String, String>();
        //Names of keys
        String[] keys = {"Sequence name", "Source", "Feature", "Start", "End", "Score", "Strand", "Frame", "Attributes"};
        
        //Separate each element into list of strings
        String lineText = lineContent.toString();
        String[] line = lineText.split("\t");
        
        for(int i = 0; i<keys.length; i++){
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
    
    //Hashmap of the number of exon per gene
    //Takes content of gtf file as argument, returns a HashMap with gene ids as keys and number of exon per gene as value
    private HashMap<String, Integer> setExonsPerGene(ArrayList<StringBuffer> textContent){
        int i;
        //Hashmap to store line values
        HashMap<String, String> line = new HashMap<String, String>();
        //Hashmap of exons per gene
        HashMap<String, Integer> exonsPerGene = new HashMap<String, Integer>();
        
        for (i = 5; i < textContent.size(); i++){
            line = hashLine(textContent.get(i));
            
            //If key gene_id does not exist, create it
            if(exonsPerGene.get(line.get("Gene ID")) == null){
                exonsPerGene.put(line.get("Gene ID").toString(), 0);
                
                //If line is an exon, actualise number of exons
                actualiseExonNumber(line, exonsPerGene);
            }
            else{
                //If gene id already exists in the hashmap, actualise number of exons
                actualiseExonNumber(line, exonsPerGene);
            }
        }
        System.out.println(exonsPerGene);
        return(exonsPerGene);
    }
    
    //If line is an exon, number of exon in corresponding gene in HashMap exonsPerGenes increases of 1
    //Takes a line of gtf file, and a hashmap indicating the number of exons (value) per gene (key), as arguments
    //Returns the hashMap with gene ids as key and the actualised number of exon for each gene id as value
    private HashMap<String, Integer> actualiseExonNumber(HashMap<String, String> line, HashMap<String, Integer> exonsPerGene){
        if(line.get("Feature").equals("exon")){ //Exon found
            //Calculate new number of exons
            int numberExons = exonsPerGene.get(line.get("Gene ID")) + 1;
            
            //ACtualise number of exons for this gene
            exonsPerGene.replace(line.get("Gene ID"), numberExons);
        }
        return exonsPerGene;
    }
    
    //Calculate average number of exons
    //Takes content of gtf file as argument
    //Returns average number of exon per gene
    public double averageExons(ArrayList<StringBuffer> textContent){
        HashMap<String, Integer> hashExons = setExonsPerGene(textContent);
        double average = 0;
        int sum = 0;
        int index = 0;
        
        //For every gene in the hashmap
        for(Map.Entry<String, Integer> gene : hashExons.entrySet()){
            sum += gene.getValue();
            index ++;
        }
        average = (double)sum/(double)index;
        avgNumberExons = average;
        return average;
    }
    
    /////////////////////////// Calculation of longest and shortest gene models within the file //////////////////////
    
    //Hashmap of the length per gene model
    //Takes content of gtf file as argument
    //Returns a hashmap of the min or max values and the coresponding genes id
    private HashMap<String, String[]> getMinMaxLength(ArrayList<StringBuffer> textContent){
        int i;
        
        //Hashmap to store results. The keys are max or min and the values are a list of length value and coresponding gene
        HashMap<String, String[]>resultMap = new HashMap<String, String[]>();
        
        //Hashmap to store line values
        HashMap<String, String> line = new HashMap<String, String>();
        
        int maxLen = 0; //Maximal Length
        int minLen = HIGH_LENGTH; //Minimal length
        String maxGene; //ID of longest gene
        String minGene; //ID of shortest gene
        
        for (i = 6; i < textContent.size(); i++){
            //Convert each line of the file to hashmap
            line = hashLine(textContent.get(i));
            
            //Caclulate length of considered line
            int length = getLength(line, "gene");
            
            if(length >=0){ //The line corresponds to gene model
                maxLen = Math.max(maxGene, length);
                
            }
        }
        return resultMap;
    }
    
    //Caclulate length of a gene model
    private int getLength(HashMap<String, String> line, String feature){
        int length = -1; //Impossible length if the feature is not "gene"
        int start;
        int end;
        
        if (line.get("Feature").equals(feature)){ //Only specific features are considered
            //Get start and end values from the HashMap and cast to integers
            start = Integer.parseInt(line.get("Start"));
            end = Integer.parseInt(line.get("End"));
            
            //Caclulate length with start and end values
            length = end - start;
        }
        
        return length;
    }
}
