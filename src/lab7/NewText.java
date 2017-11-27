package lab7;

import java.util.HashMap;

public class NewText {
    private String newtext;

    public String getNewtext() {
        return newtext;
    }

    public void setNewtext(String newtext) {
        this.newtext = newtext;
    }
    public void generateNewText(HashMap<String,HashMap<String,Integer>> Graph)
    {
        String[] wordlist=newtext.split("\\s+");
        String xx="";
        BridgeWords b =new BridgeWords();
        for(int i =0;i<wordlist.length-1;i++){
            String ss=b.queryBridgeWord(wordlist[i],wordlist[i+1],Graph);
            if(ss==null)
            {xx=xx+wordlist[i]+" ";}
            else
            {
                xx=xx+wordlist[i]+" "+ss+" ";
            }        
        }
        setNewtext(xx+wordlist[wordlist.length-1]);
        
    }
    

}
