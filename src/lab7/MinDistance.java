package lab7;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class MinDistance {
    private String min_d;

    public String getMin_d() {
        return min_d;
    }

    public void setMin_d(String min_d) {
        this.min_d = min_d;
    }
    public void calcShortestPath(HashMap<String,HashMap<String,Integer>> Graph){
        String [] word = min_d.split("\\s+");
        if (word.length==1){
            word[1]=null;
        }
        HashMap<String,String> MinPath=new HashMap<String,String>();
        HashMap<String,Integer> MinDis=new HashMap<String,Integer>();
        if(Graph.containsKey(word[0])) {
                if (Graph.get(word[0])==null){
                    setMin_d(null);
                }
                MinPath.put(word[0], word[0]);
                MinDis.put(word[0], 0);
                String [] nextNode=new String[1000];
                int i=0,j=0;
                Set<Entry<String, Integer>> entrySet = Graph.get(word[0]).entrySet();
                for (Entry<String, Integer> entry : entrySet) {
                    MinDis.put(entry.getKey(),MinDis.get(word[0])+ entry.getValue());
                    MinPath.put(entry.getKey(),MinPath.get(word[0])+"->"+entry.getKey());
                    nextNode[i]=entry.getKey();
                    i++;
                }
                while(Graph.size()>MinDis.size() && j<Graph.size()){
                    if(Graph.get(nextNode[j])!=null){
                    entrySet=Graph.get(nextNode[j]).entrySet();
                    for (Entry<String, Integer> entry : entrySet) {
                        if(!MinDis.containsKey(entry.getKey())){
                            MinDis.put(entry.getKey(),MinDis.get(nextNode[j])+ entry.getValue());
                            MinPath.put(entry.getKey(),MinPath.get(nextNode[j])+"->"+entry.getKey());
                            nextNode[i]=entry.getKey();
                            i++;
                        }
                        else
                        {
                            if(MinDis.get(nextNode[j])+entry.getValue()< MinDis.get(entry.getKey())){
                                MinDis.put(entry.getKey(), MinDis.get(nextNode[j])+entry.getValue());
                                MinPath.put(entry.getKey(), MinPath.get(nextNode[j])+"->"+entry.getKey());
                            }
                        }
                    }
                    }
                    
                   j++;
                    
                }
                //输出所有点的最短路径。    
                if(Graph.containsKey(word[1])){
                    setMin_d(MinPath.get(word[1]));
                }
                else{
                    if(word[1]==null){
                        String dis="";
                         Set<Entry<String, String>> entryS = MinPath.entrySet();     //打印图
                            for (Entry<String, String> entry : entryS) {
                                dis=dis+entry.getKey()+"的最短路径: /n"+entry.getValue()+" 最短路径长为 "+MinDis.get(entry.getKey())+"/n";
                            }
                            setMin_d(dis);
                    }
                    else{
                        setMin_d(null);
                    }
                }
            
        }
        else{
            setMin_d(null);}
    }
}
