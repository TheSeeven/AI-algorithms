import java.util.Vector;

public class Datas {
    public static Node theGraph;

    public static void setGraphWithoutHeuristicAndPath() {
        theGraph=null;
        Node start_A = new Node("A",null);
        Node B = new Node("B",null);
        Node C = new Node("C",null);
        Node D = new Node("D",null);
        Node E = new Node("E",null);
        Node F = new Node("F",null);
        Node G = new Node("G",null);
        Node H = new Node("H",null);
        Node I = new Node("I",null);
        Node J = new Node("J",null);

        start_A.addNodeToNode(B,"A");
        start_A.addNodeToNode(C,"A");
        start_A.addNodeToNode(D,"B");
        start_A.addNodeToNode(E,"B");
        start_A.addNodeToNode(F,"C");
        start_A.addNodeToNode(G,"C");
        start_A.addNodeToNode(H,"D");
        start_A.addNodeToNode(I,"D");
        start_A.addNodeToNode(J,"F");

        theGraph=start_A;
    }

    public static void setGraphWithPathNoHeuristic() {

        theGraph=null;
        Vector<Path> pathsA=new Vector<Path>();
        Vector<Path> pathsB=new Vector<Path>();
        Vector<Path> pathsC=new Vector<Path>();
        Vector<Path> pathsD=new Vector<Path>();
        Vector<Path> pathsE=new Vector<Path>();
        Vector<Path> pathsF=new Vector<Path>();
        Vector<Path> pathsG=new Vector<Path>();
        Vector<Path> pathsH=new Vector<Path>();
        Vector<Path> pathsI=new Vector<Path>();
        Vector<Path> pathsJ=new Vector<Path>();
        Vector<Path> pathsK=new Vector<Path>();


        Node start_A = new Node("A",pathsA);
        Node B = new Node("B",pathsB);
        Node C = new Node("C",pathsC);
        Node D = new Node("D",pathsD);
        Node E = new Node("E",pathsE);
        Node F = new Node("F",pathsF);
        Node G = new Node("G",pathsG);
        Node H = new Node("H",pathsH);
        Node I = new Node("I",pathsI);
        Node J = new Node("J",pathsJ);
        Node K = new Node("J",pathsK);

        start_A.addNodeToNode(B, "A");
        start_A.addNodeToNode(C, "A");
        start_A.addNodeToNode(D, "A");
        start_A.addNodeToNode(E, "B");
        start_A.addNodeToNode(F, "B");
        start_A.addNodeToNode(G, "C");
        start_A.addNodeToNode(H, "D");
        start_A.addNodeToNode(J, "E");
        start_A.addNodeToNode(K, "H");
        start_A.addNodeToNode(I, "H");

        

        pathsA.add(new Path("B", 5));
        pathsA.add(new Path("C", 6));
        pathsA.add(new Path("D", 3));
        pathsB.add(new Path("A", 5));
        pathsB.add(new Path("E", 11));
        pathsB.add(new Path("F", 10));
        pathsC.add(new Path("A", 6));
        pathsC.add(new Path("G", 8));
        pathsD.add(new Path("A", 3));
        pathsD.add(new Path("H", 2));
        pathsE.add(new Path("B", 11));
        pathsE.add(new Path("J", 9));
        pathsF.add(new Path("B", 10));
        pathsG.add(new Path("C", 8));
        pathsH.add(new Path("D", 2));
        pathsH.add(new Path("K", 3));
        pathsH.add(new Path("I", 1));
        pathsJ.add(new Path("E", 9));
        pathsK.add(new Path("H", 3));
        pathsI.add(new Path("H", 1));
        theGraph=start_A;
    }


    public static void setGraphWithHeuristicNoPath() {

        theGraph=null;
        Node start_A=new Node("A",null);
        Node B=new Node("B",null);
        Node C=new Node("C",null);
        Node D=new Node("D",null);
        Node E=new Node("E",null);
        Node F=new Node("F",null);
        Node G=new Node("G",null);
        Node H=new Node("H",null);
        Node J=new Node("J",null);
        Node K=new Node("K",null);
        Node I=new Node("I",null);

        start_A.addNodeToNode(B, "A");
        start_A.addNodeToNode(C, "A");
        start_A.addNodeToNode(D, "A");

        start_A.addNodeToNode(E, "B");
        start_A.addNodeToNode(F, "B");

        start_A.addNodeToNode(G, "C");

        start_A.addNodeToNode(H, "D");

        start_A.addNodeToNode(J, "E");

        start_A.addNodeToNode(K, "H");
        start_A.addNodeToNode(I, "H");
        


        Vector<Heuristic> heuA= new Vector<Heuristic>();
        Vector<Heuristic> heuB= new Vector<Heuristic>();
        Vector<Heuristic> heuC= new Vector<Heuristic>();
        Vector<Heuristic> heuD= new Vector<Heuristic>();
        Vector<Heuristic> heuE= new Vector<Heuristic>();
        Vector<Heuristic> heuF= new Vector<Heuristic>();
        Vector<Heuristic> heuG= new Vector<Heuristic>();
        Vector<Heuristic> heuH= new Vector<Heuristic>();
        Vector<Heuristic> heuK= new Vector<Heuristic>();
        Vector<Heuristic> heuI= new Vector<Heuristic>();
        Vector<Heuristic> heuJ= new Vector<Heuristic>();


        heuA.add(new Heuristic("B",3));
        heuA.add(new Heuristic("C",5));
        heuA.add(new Heuristic("D",2));
        heuA.add(new Heuristic("E",10));
        heuA.add(new Heuristic("F",7));
        heuA.add(new Heuristic("G",9));
        heuA.add(new Heuristic("H",6));
        heuA.add(new Heuristic("J",13));
        heuA.add(new Heuristic("K",6));
        heuA.add(new Heuristic("I",5));

        heuB.add(new Heuristic("A",3));
        heuB.add(new Heuristic("C",4));
        heuB.add(new Heuristic("D",9));
        heuB.add(new Heuristic("E",7));
        heuB.add(new Heuristic("F",5));
        heuB.add(new Heuristic("G",11));
        heuB.add(new Heuristic("H",19));
        heuB.add(new Heuristic("J",12));
        heuB.add(new Heuristic("K",17));
        heuB.add(new Heuristic("I",20));
        
        heuC.add(new Heuristic("B",4));
        heuC.add(new Heuristic("A",5));
        heuC.add(new Heuristic("D",3));
        heuC.add(new Heuristic("E",8));
        heuC.add(new Heuristic("F",5));
        heuC.add(new Heuristic("G",7));
        heuC.add(new Heuristic("H",9));
        heuC.add(new Heuristic("J",16));
        heuC.add(new Heuristic("K",14));
        heuC.add(new Heuristic("I",13));

        heuD.add(new Heuristic("B",9));
        heuD.add(new Heuristic("C",3));
        heuD.add(new Heuristic("A",2));
        heuD.add(new Heuristic("E",22));
        heuD.add(new Heuristic("F",15));
        heuD.add(new Heuristic("G",12));
        heuD.add(new Heuristic("H",3));
        heuD.add(new Heuristic("J",26));
        heuD.add(new Heuristic("K",7));
        heuD.add(new Heuristic("I",5));

        heuE.add(new Heuristic("B",7));
        heuE.add(new Heuristic("C",8));
        heuE.add(new Heuristic("D",22));
        heuE.add(new Heuristic("A",10));
        heuE.add(new Heuristic("F",8));
        heuE.add(new Heuristic("G",11));
        heuE.add(new Heuristic("H",17));
        heuE.add(new Heuristic("J",8));
        heuE.add(new Heuristic("K",14));
        heuE.add(new Heuristic("I",26));

        heuF.add(new Heuristic("B",5));
        heuF.add(new Heuristic("C",7));
        heuF.add(new Heuristic("D",15));
        heuF.add(new Heuristic("E",8));
        heuF.add(new Heuristic("A",7));
        heuF.add(new Heuristic("G",6));
        heuF.add(new Heuristic("H",8));
        heuF.add(new Heuristic("J",5));
        heuF.add(new Heuristic("K",12));
        heuF.add(new Heuristic("I",15));


        heuG.add(new Heuristic("B",11));
        heuG.add(new Heuristic("C",7));
        heuG.add(new Heuristic("D",12));
        heuG.add(new Heuristic("E",11));
        heuG.add(new Heuristic("F",6));
        heuG.add(new Heuristic("A",9));
        heuG.add(new Heuristic("H",10));
        heuG.add(new Heuristic("J",16));
        heuG.add(new Heuristic("K",8));
        heuG.add(new Heuristic("I",13));


        heuH.add(new Heuristic("B",19));
        heuH.add(new Heuristic("C",9));
        heuH.add(new Heuristic("D",3));
        heuH.add(new Heuristic("E",17));
        heuH.add(new Heuristic("F",8));
        heuH.add(new Heuristic("G",10));
        heuH.add(new Heuristic("A",6));
        heuH.add(new Heuristic("J",27));
        heuH.add(new Heuristic("K",2));
        heuH.add(new Heuristic("I",1));


        heuJ.add(new Heuristic("B",12));
        heuJ.add(new Heuristic("C",16));
        heuJ.add(new Heuristic("D",26));
        heuJ.add(new Heuristic("E",8));
        heuJ.add(new Heuristic("F",5));
        heuJ.add(new Heuristic("G",16));
        heuJ.add(new Heuristic("H",27));
        heuJ.add(new Heuristic("A",13));
        heuJ.add(new Heuristic("K",16));
        heuJ.add(new Heuristic("I",23));

        heuK.add(new Heuristic("B",17));
        heuK.add(new Heuristic("C",14));
        heuK.add(new Heuristic("D",7));
        heuK.add(new Heuristic("E",14));
        heuK.add(new Heuristic("F",12));
        heuK.add(new Heuristic("G",8));
        heuK.add(new Heuristic("H",2));
        heuK.add(new Heuristic("J",16));
        heuK.add(new Heuristic("A",6));
        heuK.add(new Heuristic("I",2));

        heuI.add(new Heuristic("B",20));
        heuI.add(new Heuristic("C",13));
        heuI.add(new Heuristic("D",5));
        heuI.add(new Heuristic("E",26));
        heuI.add(new Heuristic("F",15));
        heuI.add(new Heuristic("G",13));
        heuI.add(new Heuristic("H",1));
        heuI.add(new Heuristic("J",23));
        heuI.add(new Heuristic("K",2));
        heuI.add(new Heuristic("A",5));

        start_A.setHeuristics(heuA);
        B.setHeuristics(heuB);
        C.setHeuristics(heuC);
        D.setHeuristics(heuD);
        E.setHeuristics(heuE);
        F.setHeuristics(heuF);
        G.setHeuristics(heuG);
        H.setHeuristics(heuH);
        J.setHeuristics(heuJ);
        K.setHeuristics(heuK);
        I.setHeuristics(heuI);

        theGraph=start_A;
    }


    public static void setGraphWithHeuristicPath() {
        
        theGraph=null;
        Vector<Path> pathsA=new Vector<Path>();
        Vector<Path> pathsB=new Vector<Path>();
        Vector<Path> pathsC=new Vector<Path>();
        Vector<Path> pathsD=new Vector<Path>();
        Vector<Path> pathsE=new Vector<Path>();
        Vector<Path> pathsF=new Vector<Path>();
        Vector<Path> pathsG=new Vector<Path>();
        Vector<Path> pathsH=new Vector<Path>();
        Vector<Path> pathsI=new Vector<Path>();
        Vector<Path> pathsJ=new Vector<Path>();
        Vector<Path> pathsK=new Vector<Path>();


        pathsA.add(new Path("B", 5));
        pathsA.add(new Path("C", 6));
        pathsA.add(new Path("D", 3));
        pathsB.add(new Path("A", 5));
        pathsB.add(new Path("E", 11));
        pathsB.add(new Path("F", 10));
        pathsC.add(new Path("A", 6));
        pathsC.add(new Path("G", 8));
        pathsD.add(new Path("A", 3));
        pathsD.add(new Path("H", 2));
        pathsE.add(new Path("B", 11));
        pathsE.add(new Path("J", 9));
        pathsF.add(new Path("B", 10));
        pathsG.add(new Path("C", 8));
        pathsH.add(new Path("K", 3));
        pathsH.add(new Path("I", 2));
        pathsH.add(new Path("D", 2));
        pathsJ.add(new Path("E", 9));
        pathsK.add(new Path("H", 3));
        pathsI.add(new Path("H", 2));
        
        
        Vector<Heuristic> heuA= new Vector<Heuristic>();
        Vector<Heuristic> heuB= new Vector<Heuristic>();
        Vector<Heuristic> heuC= new Vector<Heuristic>();
        Vector<Heuristic> heuD= new Vector<Heuristic>();
        Vector<Heuristic> heuE= new Vector<Heuristic>();
        Vector<Heuristic> heuF= new Vector<Heuristic>();
        Vector<Heuristic> heuG= new Vector<Heuristic>();
        Vector<Heuristic> heuH= new Vector<Heuristic>();
        Vector<Heuristic> heuK= new Vector<Heuristic>();
        Vector<Heuristic> heuI= new Vector<Heuristic>();
        Vector<Heuristic> heuJ= new Vector<Heuristic>();


        heuA.add(new Heuristic("B",3));
        heuA.add(new Heuristic("C",5));
        heuA.add(new Heuristic("D",2));
        heuA.add(new Heuristic("E",10));
        heuA.add(new Heuristic("F",7));
        heuA.add(new Heuristic("G",9));
        heuA.add(new Heuristic("H",6));
        heuA.add(new Heuristic("J",13));
        heuA.add(new Heuristic("K",6));
        heuA.add(new Heuristic("I",5));

        heuB.add(new Heuristic("A",3));
        heuB.add(new Heuristic("C",4));
        heuB.add(new Heuristic("D",9));
        heuB.add(new Heuristic("E",7));
        heuB.add(new Heuristic("F",5));
        heuB.add(new Heuristic("G",11));
        heuB.add(new Heuristic("H",19));
        heuB.add(new Heuristic("J",12));
        heuB.add(new Heuristic("K",17));
        heuB.add(new Heuristic("I",20));
        
        heuC.add(new Heuristic("B",4));
        heuC.add(new Heuristic("A",5));
        heuC.add(new Heuristic("D",3));
        heuC.add(new Heuristic("E",8));
        heuC.add(new Heuristic("F",5));
        heuC.add(new Heuristic("G",7));
        heuC.add(new Heuristic("H",9));
        heuC.add(new Heuristic("J",16));
        heuC.add(new Heuristic("K",14));
        heuC.add(new Heuristic("I",13));

        heuD.add(new Heuristic("B",9));
        heuD.add(new Heuristic("C",3));
        heuD.add(new Heuristic("A",2));
        heuD.add(new Heuristic("E",22));
        heuD.add(new Heuristic("F",15));
        heuD.add(new Heuristic("G",12));
        heuD.add(new Heuristic("H",3));
        heuD.add(new Heuristic("J",26));
        heuD.add(new Heuristic("K",7));
        heuD.add(new Heuristic("I",5));

        heuE.add(new Heuristic("B",7));
        heuE.add(new Heuristic("C",8));
        heuE.add(new Heuristic("D",22));
        heuE.add(new Heuristic("A",10));
        heuE.add(new Heuristic("F",8));
        heuE.add(new Heuristic("G",11));
        heuE.add(new Heuristic("H",17));
        heuE.add(new Heuristic("J",8));
        heuE.add(new Heuristic("K",14));
        heuE.add(new Heuristic("I",26));

        heuF.add(new Heuristic("B",5));
        heuF.add(new Heuristic("C",7));
        heuF.add(new Heuristic("D",15));
        heuF.add(new Heuristic("E",8));
        heuF.add(new Heuristic("A",7));
        heuF.add(new Heuristic("G",6));
        heuF.add(new Heuristic("H",8));
        heuF.add(new Heuristic("J",5));
        heuF.add(new Heuristic("K",12));
        heuF.add(new Heuristic("I",15));

        heuG.add(new Heuristic("B",11));
        heuG.add(new Heuristic("C",7));
        heuG.add(new Heuristic("D",12));
        heuG.add(new Heuristic("E",11));
        heuG.add(new Heuristic("F",6));
        heuG.add(new Heuristic("A",9));
        heuG.add(new Heuristic("H",10));
        heuG.add(new Heuristic("J",16));
        heuG.add(new Heuristic("K",8));
        heuG.add(new Heuristic("I",13));


        heuH.add(new Heuristic("B",19));
        heuH.add(new Heuristic("C",9));
        heuH.add(new Heuristic("D",3));
        heuH.add(new Heuristic("E",17));
        heuH.add(new Heuristic("F",8));
        heuH.add(new Heuristic("G",10));
        heuH.add(new Heuristic("A",6));
        heuH.add(new Heuristic("J",27));
        heuH.add(new Heuristic("K",2));
        heuH.add(new Heuristic("I",1));


        heuJ.add(new Heuristic("B",12));
        heuJ.add(new Heuristic("C",16));
        heuJ.add(new Heuristic("D",26));
        heuJ.add(new Heuristic("E",8));
        heuJ.add(new Heuristic("F",5));
        heuJ.add(new Heuristic("G",16));
        heuJ.add(new Heuristic("H",27));
        heuJ.add(new Heuristic("A",13));
        heuJ.add(new Heuristic("K",16));
        heuJ.add(new Heuristic("I",23));

        heuK.add(new Heuristic("B",17));
        heuK.add(new Heuristic("C",14));
        heuK.add(new Heuristic("D",7));
        heuK.add(new Heuristic("E",14));
        heuK.add(new Heuristic("F",12));
        heuK.add(new Heuristic("G",8));
        heuK.add(new Heuristic("H",2));
        heuK.add(new Heuristic("J",16));
        heuK.add(new Heuristic("A",6));
        heuK.add(new Heuristic("I",2));

        heuI.add(new Heuristic("B",20));
        heuI.add(new Heuristic("C",13));
        heuI.add(new Heuristic("D",5));
        heuI.add(new Heuristic("E",26));
        heuI.add(new Heuristic("F",15));
        heuI.add(new Heuristic("G",13));
        heuI.add(new Heuristic("H",1));
        heuI.add(new Heuristic("J",23));
        heuI.add(new Heuristic("K",2));
        heuI.add(new Heuristic("A",5));

        Node start_A=new Node("A",heuA,pathsA);
        Node B=new Node("B",heuB,pathsB);
        Node C=new Node("C",heuC,pathsC);
        Node D=new Node("D",heuD,pathsD);
        Node E=new Node("E",heuE,pathsE);
        Node F=new Node("F",heuF,pathsF);
        Node G=new Node("G",heuG,pathsG);
        Node H=new Node("H",heuH,pathsH);
        Node J=new Node("J",heuJ,pathsJ);
        Node K=new Node("K",heuK,pathsK);
        Node I=new Node("I",heuI,pathsI);

        start_A.addNodeToNode(B, "A");
        start_A.addNodeToNode(C, "A");
        start_A.addNodeToNode(D, "A");
        start_A.addNodeToNode(E, "B");
        start_A.addNodeToNode(F, "B");
        start_A.addNodeToNode(G, "C");
        start_A.addNodeToNode(H, "D");
        start_A.addNodeToNode(J, "E");
        start_A.addNodeToNode(K, "H");
        start_A.addNodeToNode(I, "H");
        

        theGraph=start_A;
    }
}

