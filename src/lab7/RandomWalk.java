package lab7;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class RandomWalk {
    private String walked;

    public String getWalked() {
        return walked;
    }

    public void setWalked(String walked) {
        this.walked = walked;
    }
    public void randomWalk(HashMap<String,HashMap<String,Integer>> Graph){
        String [] nodeList = new String[Graph.size()];
        HashMap<Integer,String> eg=new HashMap<Integer,String>();
        int i=0;int count=0;
        Set<Entry<String, HashMap<String,Integer>>> entrySet = Graph.entrySet(); 
        for (Entry<String, HashMap<String,Integer>> entry : entrySet) {
            nodeList[i]=entry.getKey();
            i++;
        }
        Random r =new Random();
        int j=r.nextInt(Graph.size());
        String word=nodeList[j];String next="";
        String Walk = word;
        while(Graph.get(word)!=null){
            i=0;
            Set<Entry<String, Integer>> ent = Graph.get(word).entrySet(); 
            for (Entry<String, Integer> entry : ent) {
                nodeList[i]=entry.getKey();
                i++;
            }
            j=r.nextInt(Graph.get(word).size());
            next=nodeList[j];
            if(!eg.containsValue(word+" "+next)){
                eg.put(count, word+" "+ next);
                Walk=Walk+"->"+next;
                count++;
                word=next;
            }else{
                Walk=Walk+"->"+next;
                break;
            }
            
        }  
        setWalked(Walk);
    }
}
