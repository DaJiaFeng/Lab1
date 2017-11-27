package lab7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boundry {
    private int choose=0;
    private String [] bridgewords;
    private String newText;
    private String minD;
    Boundry(){
        System.out.println("选择功能(-1:退出程序)：/n 1.展示有向图 /n 2.查询桥接词 /n 3.根据bridge word生成新文本/n 4.计算两个单词之间的最短路径/n 5.随机游走");
        while(choose!=-1){
            Scanner sii=new Scanner(System.in);
        if (sii.hasNextInt()){
        choose=sii.nextInt();
        }
    }
    }
    public int getChoose() {
        return choose;
    }
    public String [] getBridgewords() {
        return bridgewords;
    }
    public void setBridgewords() {
        System.out.println("Please input the two words: ");
        Scanner scan=new Scanner(System.in);
            if(scan.hasNext()){
                bridgewords[0]=scan.next();
                bridgewords[1]=scan.next();
            }
    }
    public String getNewText() {
        return newText;
    }
    public void setNewText() {
        System.out.println("Please input the text: ");
        Scanner sca=new Scanner(System.in);
        if(sca.hasNextLine()){
             newText=sca.nextLine();  
        }
        newText=newText.replaceAll("[^a-zA-Z]"," ");
        newText=newText.toLowerCase();
    }
    public void showNewText(String newtext){
        System.out.println(newtext);
    }
    public void showReword1(){
        System.out.println("No bridge words from "+"\""+bridgewords[0]+"\""+" to "+"\""+ bridgewords[1]+"\""+"!");
    }
    public void showReword2(){
        System.out.println("No"+"\""+bridgewords[0]+"\"" +"in the graph!");
    }
    public void showReword3(){
        System.out.println("No"+"\""+bridgewords[1]+"\"" +"in the graph!");
    }
    public void showReword4(String reword){
        System.out.println("The bridge words from "+ "\""+bridgewords[0]+"\""+ " to "+ "\""+bridgewords[1]+"\""+" is:"+reword);
    }
    public void showReword5(String reword){
        System.out.println("The bridge words from "+ "\""+bridgewords[0]+"\""+ " to "+ "\""+bridgewords[1]+"\""+" are:"+reword);
    }
    public String getMinD() {
        return minD;
    }
    public void setMinD() {
        System.out.println("Please input the two words: ");
        Scanner scan1 =new Scanner(System.in );
        if (scan1.hasNextLine()){
            minD = scan1.nextLine();
        }
    }
    public void showMinD(String min) {
        System.out.println(min);
    }
    public void showMine() {
        System.out.println("不可达！/n");
    }
    public void showRandm(String rand) throws IOException{
        System.out.println(rand);
        File fe = new File("D:/aaa/randompath.txt");
        FileOutputStream fop = new FileOutputStream(fe);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append(rand);
        writer.close();
    }

}
