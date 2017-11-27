package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Dgraph {
    
    private HashMap<String,HashMap<String,Integer>> Graph=new HashMap<String,HashMap<String,Integer>>();
    
    public void CreateGraph() throws IOException{
        File f=new File("D:/aaa/help.txt");
        FileReader in =new FileReader(f);
        BufferedReader fr=new BufferedReader(in);
        String s=null;
        String str=" ";
     
        while((s=fr.readLine())!=null){
            s=s.replaceAll("[^a-zA-Z]"," ");
            str=str+s+" ";   
        }
        str=str.toLowerCase();
        str=str.trim(); 
        String []list=str.split("\\s+");
         
        fr.close();
        in.close();
        HashMap<String,HashMap<String,Integer>> graph=new HashMap<String,HashMap<String,Integer>>();
        for (int i=0;i<list.length-1;i++)
        {
            if (graph.containsKey(list[i])){
                if (graph.get(list[i]).containsKey(list[i+1]))
                {
                    int value=graph.get(list[i]).get(list[i+1]);
                    graph.get(list[i]).put(list[i+1],value+1);
                }
                else
                {
                    graph.get(list[i]).put(list[i+1],1);
                }       
            }
            else    
            {
                HashMap<String,Integer> ad=new HashMap<String,Integer>();
                ad.put(list[i+1], 1);
                graph.put(list[i],ad);
            }       
        }
        if(!graph.containsKey(list[list.length-1])){
            graph.put(list[list.length-1],null);}
        setGraph(graph);
    }
    public HashMap<String,HashMap<String,Integer>> getGraph() {
        return Graph;
    }
    public void setGraph(HashMap<String,HashMap<String,Integer>> graph) {
        Graph = graph;
    }
    public void showDirectedGraph(HashMap<String,HashMap<String,Integer>> Graph)
    {
        Graphviz gv = new Graphviz();
          gv.addln(gv.start_graph());
        Set<Entry<String, HashMap<String,Integer>>> entrySet =Graph.entrySet();
        for (Entry<String, HashMap<String,Integer>> entry : entrySet) {
            if(entry.getValue()!=null){
            Set<Entry<String,Integer>> entrs =entry.getValue().entrySet();
            for (Entry<String, Integer> entr : entrs) {
                 gv.addln(entry.getKey()+"[style=\"filled\", color=\"black\", fillcolor=\"chartreuse\"];");
                 gv.addln(entry.getKey()+"->"+entr.getKey()+"[label="+entr.getValue()+",color=\"red\"];");
                 gv.addln(entr.getKey()+"[style=\"filled\", color=\"black\", fillcolor=\"chartreuse\"];");
        }}}

          gv.addln(gv.end_graph());
         // System.out.println(gv.getDotSource());
          String type = "gif";
//        String type = "dot";
//        String type = "fig";    // open with xfig
//        String type = "pdf";
//        String type = "ps";
//        String type = "svg";    // open with inkscape
//        String type = "png";
//        String type = "plain";
//        File out = new File("/tmp/out." + type);   // Linux
          File out = new File("d:/aaa/graph." + type);    // Windows
          gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    }
    
    public void showGraph(HashMap<String,HashMap<String,Integer>> Graph,String[] s,int mm){
        Graphviz gv1 = new Graphviz();
        gv1.addln(gv1.start_graph());
        int sum=0;   
        Set<Entry<String, HashMap<String,Integer>>> entrySet1 =Graph.entrySet();
        for (Entry<String, HashMap<String,Integer>> entry : entrySet1) {
            if (entry.getValue()!=null){
            Set<Entry<String,Integer>> entrs =entry.getValue().entrySet();
            for (Entry<String, Integer> entr : entrs) {
                int x=0;
                for (int i=0;i<s.length-1;i++){
                    if (entry.getKey().equals(s[i]) && entr.getKey().equals(s[i+1]))
                    {
                        x=1;
                        break;
                    }   
                 
                }
                 
                if(x==1){
                    gv1.addln(entry.getKey()+"[style=\"filled\", color=\"black\", fillcolor=\"red\"];");
                    gv1.addln(entr.getKey()+"[style=\"filled\", color=\"black\", fillcolor=\"red\"];");
                    gv1.addln(entry.getKey()+"->"+entr.getKey()+"[label="+entr.getValue()+",color=\"red\"];");
                    sum+=entr.getValue();
                }
                else{
                     
                    gv1.addln(entry.getKey()+"->"+entr.getKey()+"[label="+entr.getValue()+"];");
                }    
        }   
        }}
        gv1.addln( sum  +"[shape=\"record\",style=\"filled\", color=\"black\", fillcolor=\"red\"];");
          gv1.addln(gv1.end_graph());
          //System.out.println(gv1.getDotSource());
          String type1 = "gif";
//        String type = "dot";
//        String type = "fig";    // open with xfig
//        String type = "pdf";
//        String type = "ps";
//        String type = "svg";    // open with inkscape
//        String type = "png";
//        String type = "plain";
//        File out = new File("/tmp/out." + type);   // Linux
          File out1 = new File("d:/aaa/graph"+mm+"." + type1);    // Windows
          gv1.writeGraphToFile( gv1.getGraph( gv1.getDotSource(), type1 ), out1 );
        }
}
