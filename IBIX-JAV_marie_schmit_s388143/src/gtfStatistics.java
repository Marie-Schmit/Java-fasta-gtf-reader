
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
    private HashMap<String, Integer> setExonsPerGene(ArrayList<StringBuffer> textContent){
        int i;
        //Hashmap to store line values
        HashMap<String, String> line = new HashMap<String, String>();
        //Hashmap of exons per gene
        HashMap<String, Integer> exonsPerGene = new HashMap<String, Integer>();
        System.out.println(textContent.size());
        
        for (i = 6; i < textContent.size(); i++){
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
    
}
