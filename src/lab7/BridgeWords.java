package lab7;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class BridgeWords {
    private String [] BridgeWords;
    private String reWord;
    public String [] getBridgeWords() {
        return BridgeWords;
    }
    public void setBridgeWords(String [] bridgeWords) {
        BridgeWords = bridgeWords;
    }
    public void queryBridgeWords(HashMap<String,HashMap<String,Integer>> Graph)
    {
        String [] array=new String[100];
        int i=0;
        if (Graph.containsKey(BridgeWords[0]) && Graph.containsKey(BridgeWords[1]))
        {
            if(Graph.get(BridgeWords[0])!=null)
            {
            Set<Entry<String,Integer>> valueSet = Graph.get(BridgeWords[0]).entrySet();
            for (Entry<String,Integer> entry : valueSet) {
                 if (Graph.get(entry.getKey())!=null && Graph.get(entry.getKey()).containsKey(BridgeWords[1])  ) 
                 {
                      array[i]= entry.getKey();  
                      i++;
                 }
            }
            }
            if (i==0)
            {
                setReWord("@1");
            }
            else if (i==1)
            {
                setReWord(array[0]);
            }
            else  
            {
                for (int j=0;j<i-1;j++)
                {
                    array[0]=array[j]+" ";
                }
                setReWord(array[0]);
            } 
        }
        else
        {
            if (!Graph.containsKey(BridgeWords[0]))
            {
                setReWord("@2");
            }
            else
            {
                setReWord("@3");
            }        
        }
    }
    
    
    public String queryBridgeWord(String word1, String word2,HashMap<String,HashMap<String,Integer>> Graph)
    {
        String [] array=new String[100];
        int i=0;
        if (Graph.containsKey(word1) && Graph.containsKey(word2))
        {
            if(Graph.get(word1)!=null)
            {
            Set<Entry<String,Integer>> valueSet = Graph.get(word1).entrySet();
            for (Entry<String,Integer> entry : valueSet) {
                 if (Graph.get(entry.getKey())!=null && Graph.get(entry.getKey()).containsKey(word2)  ) 
                 {
                      array[i]= entry.getKey();  
                      i++;
                 }
            }
            return array[0];
            }
            else  
                return null;
        }
        else
            return null;        
        }
    public String getReWord() {
        return reWord;
    }
    public void setReWord(String reWord) {
        this.reWord = reWord;
    }
    
}
