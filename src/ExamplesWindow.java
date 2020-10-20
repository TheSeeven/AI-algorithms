import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Vector;




public class ExamplesWindow extends JFrame implements ActionListener  {
    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private static JTree GraphViewer;
    private static JPanel[] panels = new JPanel[2];
    private static JLabel currentGraph;
    private static JLabel algorithmResults;

    private static Vector<DefaultMutableTreeNode> getMutableChilds(DefaultMutableTreeNode obj) {
        Vector<DefaultMutableTreeNode> result = new Vector<DefaultMutableTreeNode>();
        
        for(int i=0;i<obj.getChildCount();i++) {
            result.add((DefaultMutableTreeNode)obj.getChildAt(i));
        }
        return result;
    }

    private static void addToMutableObject(Node node,String name,DefaultMutableTreeNode tree) {
        
        DefaultMutableTreeNode current = tree;
        LinkedList<DefaultMutableTreeNode> toVisit = new LinkedList<DefaultMutableTreeNode>();

        while(current.getUserObject().toString()!=node.getName()) {
            toVisit.addAll(getMutableChilds(current));
            current = toVisit.pop();
        }
        current.add(new DefaultMutableTreeNode(name));

    }

    private static JTree transformTree(Node root)  {
        
        DefaultMutableTreeNode rootTree = new DefaultMutableTreeNode(root.getName());
        LinkedList<Node> childs = new LinkedList<Node>();
        Vector<Node> parents = new Vector<Node>();
        Vector<Node> temp = new Vector<Node>();

        Node current = root;
        
        parents.add(current);
        while(!parents.isEmpty() | !childs.isEmpty() | !temp.isEmpty()) { 
            for(Node i:parents) {
                childs.addAll(i.getChilds());
                temp.addAll(i.getChilds());
                while(!childs.isEmpty()) {
                    addToMutableObject(i, childs.pop().getName(),rootTree);
                }
            }
            parents.clear();
            parents.addAll(temp);
            temp.clear();         
        }   
    
        JTree tree = new JTree(rootTree); 
        return tree;
    }




    public ExamplesWindow(){}

    void initialization(Node data)  {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1800,1000);
        ImageIcon image = new ImageIcon("lib/icon.png");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        frame.setTitle("Search Algorithms AI");
        frame.getContentPane();
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new GridLayout(1,2));
        
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        frame.add(panels[0]);
        frame.add(panels[1]);
        panels[0].setBackground(new Color(50,50,50));
        panels[1].setBackground(new Color(50,50,50));
        panels[0].setLayout(new GridLayout(11,1));
        panels[1].setLayout(new GridLayout(2,1));
    

        JButton MatrixButton = new JButton("Matrix Game");
        MatrixButton.setActionCommand("M");
        MatrixButton.addActionListener(this);
        MatrixButton.setPreferredSize(new Dimension(150,80));
        panels[0].add(MatrixButton);

        frame.setVisible(true);

        JButton DFS =  new JButton("Depth First Search");
        JButton GBFS =  new JButton("Greedy Best First Search");
        JButton UCS = new JButton("Uniform Cost Search");
        JButton DLS = new JButton ("Depth Limited Search");
        JButton BFS = new JButton ("Breadth First Search");
        JButton ASTAR = new JButton("AStar Search");

        DFS.setActionCommand("DFS");
        GBFS.setActionCommand("GBFS");
        UCS.setActionCommand("UCS");
        DLS.setActionCommand("DLS");
        BFS.setActionCommand("BFS");
        ASTAR.setActionCommand("ASTAR");

        DFS.addActionListener(this);
        GBFS.addActionListener(this);
        UCS.addActionListener(this);
        DLS.addActionListener(this);
        BFS.addActionListener(this);
        ASTAR.addActionListener(this);
        
        DFS.setPreferredSize(new Dimension(150,80));
        GBFS.setPreferredSize(new Dimension(150,80));
        UCS.setPreferredSize(new Dimension(150,80));
        DLS.setPreferredSize(new Dimension(150,80));
        BFS.setPreferredSize(new Dimension(150,80));
        ASTAR.setPreferredSize(new Dimension(150,80));
        
        panels[0].add(DFS);
        panels[0].add(GBFS);
        panels[0].add(UCS);
        panels[0].add(DLS);
        panels[0].add(BFS);
        panels[0].add(ASTAR);
        
        currentGraph=new JLabel();
        currentGraph.setText("No Graph selected!");
        currentGraph.setBackground(new Color(50,50,50));
        currentGraph.setForeground(new Color(225,225,225));
        currentGraph.setHorizontalAlignment(JLabel.CENTER);
        currentGraph.setFont(new Font(currentGraph.getFont().getName(),Font.PLAIN,30));
        panels[1].add(currentGraph);
        currentGraph.setVisible(true);

        JLabel searchResults = new JLabel("Algorithm Results:");
        searchResults.setText("Algorithm Results:");
        searchResults.setBackground(new Color(50,50,50));
        searchResults.setForeground(new Color(225,225,225));
        searchResults.setHorizontalAlignment(JLabel.CENTER);
        searchResults.setFont(new Font(currentGraph.getFont().getName(),Font.PLAIN,30));
        panels[0].add(searchResults);

        
        algorithmResults = new JLabel("No results yet");
        algorithmResults.setFont(new Font(currentGraph.getFont().getName(),Font.PLAIN,30));
        algorithmResults.setBackground(new Color(50,50,50));
        algorithmResults.setForeground(new Color(225,225,225));
        panels[0].add(algorithmResults);
        

    }


    private static String processResults(Vector<Node> list) { 
        String result = "";
        for(Node i:list) {
            result += i.getName() + "   ";
        }
        return result;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            panels[1].repaint();
            if(e.getActionCommand()=="M") {
                ImageIcon image = new ImageIcon("lib/icon.png");
                JFrame beforeMatrix = new JFrame("Before Algorithm");
                JFrame afterMatrix = new JFrame("After Algorithm");
                beforeMatrix.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                afterMatrix.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                beforeMatrix.setSize(300,300);
                beforeMatrix.setIconImage(image.getImage());
                beforeMatrix.setResizable(false);

                afterMatrix.setSize(300,300);
                afterMatrix.setIconImage(image.getImage());
                afterMatrix.setResizable(false);

                MatrixGame before = new MatrixGame(MatrixGame.generateGame());
                MatrixGame after = MatrixGame.solveRandomGameMatrix(before);

                JPanel beforePanel = new JPanel();
                JPanel afterPanel = new JPanel();

                beforePanel.setLayout(new GridLayout(3,3));
                afterPanel.setLayout(new GridLayout(3,3));
                beforeMatrix.add(beforePanel);
                afterMatrix.add(afterPanel);
                beforePanel.setBackground(new Color(50,50,50));
                afterPanel.setBackground(new Color(50,50,50));
                beforePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                afterPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                beforeMatrix.setLocation(0,500);
                afterMatrix.setLocation(500,500);

                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {
                        JLabel a = new JLabel(String.valueOf(before.getMatrix()[i][j]));        
                        JLabel b = new JLabel(String.valueOf(after.getMatrix()[i][j]));

                        a.setBackground(new Color(50,50,50));
                        b.setBackground(new Color(50,50,50));
                        a.setForeground(new Color(225,225,225));
                        b.setForeground(new Color(225,225,225));
                        a.setFont(new Font(a.getFont().getName(),Font.PLAIN,30));
                        b.setFont(new Font(a.getFont().getName(),Font.PLAIN,30));
                        a.setHorizontalAlignment(JLabel.CENTER);
                        b.setHorizontalAlignment(JLabel.CENTER);

                        beforePanel.add(a);
                        afterPanel.add(b);
                    }
                }

                beforeMatrix.setVisible(true);
                afterMatrix.setVisible(true);
                beforePanel.setVisible(true);
                afterPanel.setVisible(true);

               
            }
            
            else if(e.getActionCommand()=="UCS") {
                
                currentGraph.setText("Uniform Cost Search");
                
                Datas.setGraphWithPathNoHeuristic();
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);

                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.setVisible(true);

                
                algorithmResults.setText(processResults(Datas.theGraph.UniformCostSearch("A","D")));

            }
            else if(e.getActionCommand()=="BFS") {

                currentGraph.setText("Breadth first search:");

                Datas.setGraphWithoutHeuristicAndPath();
                
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);
                
                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.add(transformTree(Datas.theGraph));
                GraphViewer.setVisible(true);

                algorithmResults.setText(processResults(Datas.theGraph.BreadthFirstSearch("A","E")));
            }
            else if(e.getActionCommand()=="DFS") {

                currentGraph.setText("Depth First Search:");
            
                Datas.setGraphWithoutHeuristicAndPath();
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);
                
                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.add(transformTree(Datas.theGraph));
                GraphViewer.setVisible(true);

                algorithmResults.setText(processResults(Datas.theGraph.DepthFirstSearch("A","D")));

            }
            else if(e.getActionCommand()=="DLS") {

                currentGraph.setText("Depth Limited Search:");

                Datas.setGraphWithoutHeuristicAndPath();
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);
                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.add(transformTree(Datas.theGraph));
                GraphViewer.setVisible(true);

                algorithmResults.setText(processResults(Datas.theGraph.DepthFirstSearch("A","D")) + " limit 2");
            }
            else if(e.getActionCommand()=="ASTAR") {

                currentGraph.setText("ASTAR Search");

                Datas.setGraphWithHeuristicPath();
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);
                
                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.add(transformTree(Datas.theGraph));
                GraphViewer.setVisible(true);

                algorithmResults.setText(processResults(Datas.theGraph.aStarSearch("A","I")));

            }
            else if(e.getActionCommand()=="GBFS") {

                currentGraph.setText("Greedy best first search");

                Datas.setGraphWithHeuristicPath();
                try{panels[1].remove(GraphViewer);}
                catch(Exception i){}
                GraphViewer = transformTree(Datas.theGraph);
                panels[1].add(GraphViewer);
                
                GraphViewer.setBackground(new Color(50,50,50));
                GraphViewer.setFont(new Font(GraphViewer.getFont().getName(),GraphViewer.getFont().getStyle(),GraphViewer.getFont().getSize()+30));
                GraphViewer.add(transformTree(Datas.theGraph));
                GraphViewer.setVisible(true);

                algorithmResults.setText(processResults(Datas.theGraph.GreedyBestFirstSearch("A","D")));

            }
    }

}
