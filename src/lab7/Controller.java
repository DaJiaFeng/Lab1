package lab7;

import java.io.IOException;

public class Controller {
    private Dgraph graph;
    private BridgeWords bridgewords;
    private NewText newtext;
    private MinDistance mind;
    private RandomWalk rand;
    Controller() throws IOException{
        graph =new Dgraph();
        graph.CreateGraph();
    }
    public void mainController(Boundry a) throws IOException{
        switch (a.getChoose()){
        case 1:
           graph.showDirectedGraph(graph.getGraph());
        break;
        case 2: 
           a.setBridgewords();
           bridgewords.setBridgeWords(a.getBridgewords());
           bridgewords.queryBridgeWords(graph.getGraph());
           if (bridgewords.getReWord()=="@1"){
               a.showReword1();
           }
           else if (bridgewords.getReWord()=="@2"){
               a.showReword2();
           }
           else if (bridgewords.getReWord()=="@3"){
               a.showReword3();
           }
           else if (bridgewords.getReWord().contains(" ")){
               a.showReword5(bridgewords.getReWord());
           }
           else{
               a.showReword4(bridgewords.getReWord());
           }
        break;
        case 3:
            a.setNewText();
            newtext.setNewtext(a.getNewText());
            newtext.generateNewText(graph.getGraph());
            a.showNewText(newtext.getNewtext());
        break;
        case 4:
        a.setMinD();
        mind.setMin_d(a.getMinD());
        mind.calcShortestPath(graph.getGraph());
        if (mind.getMin_d()!=null){
            if(mind.getMin_d().contains("的最短路径")){
                a.showMinD(mind.getMin_d());
            }else{
                graph.showGraph(graph.getGraph(),mind.getMin_d().split("->"),1);
                a.showMinD(mind.getMin_d());
            }
        }
        else{
            a.showMine();
        }
        break;
            case 5:
        rand.randomWalk(graph.getGraph());
        if (rand.getWalked()!=null){
            String[] ssss=rand.getWalked().split("->");
            graph.showGraph(graph.getGraph(),rand.getWalked().split("->"),2);
        }
        
        a.showRandm(rand.getWalked());
        break;   
        }
        }
    }


