
public class App {



    public static void main(String[] args) throws Exception {
         

        
        // Datas.setGraphWithoutHeuristicAndPath();
        // Vector<Node> test = new Vector<Node>();
        // test = Datas.theGraph.BreadthFirstSearch("A", "I");
        // test = Datas.theGraph.DepthFirstSearch("A", "J");
        // test = Datas.theGraph.DepthLimitedSearch("A", "E", 3);

        // Datas.setGraphWithPathNoHeuristic();
        // test = Datas.theGraph.UniformCostSearch("A", "D");
        
        // Datas.setGraphWithHeuristicPath();
        // test=Datas.theGraph.GreedyBestFirstSearch("A", "H");
        // test=Datas.theGraph.aStarSearch("A", "E");



        ExamplesWindow visual = new ExamplesWindow();
        visual.initialization(Datas.theGraph);
        ;

        
    }

    
}

