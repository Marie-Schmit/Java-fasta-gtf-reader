
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marie
 */
public class exons {
    public exons(){
        
    }
    
    //Get a hashmap of exons from gtf file.  The map contains gene id, start and end position of exons.
    public HashMap getExons(ArrayList<StringBuffer> gtfContent){
        //Make a hashmap of each gtf file line
        gtfStatistics gtfStats = new gtfStatistics();
        
        int i;
        int numero =1; //Number of exons sequence already stored in hashMap
        //Hashmap to store line values
        HashMap<String, Integer> line = new HashMap<String, Integer>();
        //Hashmap of exons per gene, containing chromosone name and list of start end indexes of exons
        HashMap<String, int[]> exonsMap = new HashMap<String, int[]>();
        
        //Scan each line of gtf content
        for (i = 5; i < gtfContent.size(); i++) {
            line = gtfStats.hashLine(gtfContent.get(i)); //Format gtf content to hashMap
            
            //If line is an exon
            if (line.get("Feature").equals("exon")) {
                //If key sequence name does not exist, create it
                if (exonsMap.get(line.get("Sequence name")) == null) { //First exon for this sequence
                    //Store start and end indices in a list of integers
                    int[] indices = {line.get("Start"), line.get("End")};
                    //exonsMap is a matrix containing the name of an exon sequence and its start and end indices
                    exonsMap.put(line.get("Sequence name").toString(), indices);
                    
                    //Restart numeor: one exon found for this sequence
                    numero = 1;

                //If key sequence already exist, change it's name 
                    //(one chromosome can have many exons, all have to be stored with a different key name)    
                } else {
                    //Store start and end indices in a list of integers
                    int[] indices = {line.get("Start"), line.get("End")};
                    //exonsMap is a matrix containing the name of an exon sequence and its start and end indices
                    exonsMap.put(line.get("Sequence name" + numero).toString(), indices);
                    numero++; //One more exon fiound for the sequence
                }
            }
        }
        System.out.println(exonsMap);
        return exonsMap;
}
