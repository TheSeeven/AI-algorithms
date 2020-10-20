import java.util.LinkedList;
import java.util.Vector;


public class Node {

    private String name;
    private Vector<Node> childs = new Vector<Node>();

    private int score = -1;
    private Vector<Heuristic> heuristics = new Vector<Heuristic>();
    private Vector<Path> paths = new Vector<Path>();

    public Node(String name, Vector<Heuristic> heuristics,Vector<Path> paths) {
        this.name = name;
        this.heuristics = heuristics;
        this.paths=paths;
    }

    public Node(String name,Vector<Path> paths) {
        this.setName(name);
        this.paths=paths;
    }

    public void addNode(Node node) {
        this.childs.add(node);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Vector<Heuristic> getHeuristics() {
        return heuristics;
    }

    public void setHeuristics(Vector<Heuristic> heuristics) {
        this.heuristics = heuristics;
    }

    public Vector<Path> getPaths() {
        return paths;
    }

    public void setPaths(Vector<Path> paths) {
        this.paths = paths;
    }

    public Vector<Node> getChilds() {
        return childs;
    }

    public void setChilds(Vector<Node> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    private boolean hasChilds() {
        return !this.getChilds().isEmpty();
    }


    private int findPathTo(String destination) {

        // Return the length of a path to a specific node destination

        for(Path i:this.paths) {
            if(i.getDestination()==destination) {
                return i.getLength();
            }
        }
        return -1;
    }


    private int findHeuristicTo(String destination) {

        // gets the heuristic for a specific place from this node

        for (Heuristic i : this.heuristics) {
            if (i.getDestination() == destination) {
                return i.getVal();
            }
        }
        return -1;
    }

    boolean isVisited(Vector<Node> visited) {

        // Checks if this node exists in visited Vector

        if(visited.contains(this)) {
            return true;
        }
        return false;
    }
    
    public Node findNode(String toFind) {

        Vector<Node> visited = new Vector<Node>();
        Vector<Node> toVisit = new Vector<Node>();

        toVisit.add(this);
        while(toVisit.size()!=0) {
            for(Node i:toVisit) {
                if(i.getName()==toFind) {
                    return i;
                }
                if(!i.isVisited(visited)) {
                   toVisit.addAll(i.getChilds());
                }
                visited.add(i);
                toVisit.remove(i);
                break;
            }
        }
        return null;
    }

    public void addNodeToNode(Node node,String destination) { 

        // Adds the "node" to the child node where his name is "destination"

        Vector<Node> visited = new Vector<Node>();
        Vector<Node> toVisit = new Vector<Node>();

        toVisit.add(this);
        while(toVisit.size()!=0) {
            for(Node i:toVisit) {
                if(i.getName()==destination) {
                    i.addNode(node);
                    toVisit.clear();
                    break;
                }
                if(!i.isVisited(visited)) {
                   toVisit.addAll(i.getChilds());
                }
                visited.add(i);
                toVisit.remove(i);
                break;
            }
        }
    }

    private Node getChildNodeByString(String nodeName) {
        for(Node i:this.getChilds()) {
            if(i.getName()==nodeName) {
                return i;
            }
        }
        return null;
    }

    private Node findMinHeuristicToDestination(String destination) {
        Node nodeName=null;
        for(Node i:this.getChilds()) {
            if(nodeName==null) {
                nodeName=i;
            }
            else {
                if(nodeName.findHeuristicTo(destination)>i.findHeuristicTo(destination)) {
                    nodeName=i;
                }
            }
        }
        return nodeName;
    }

    private Path finMinNodePath() {
        Path temp=null;
        for(Path i: this.getPaths()) {
            if(temp==null) {
                temp=i;
            }
            else {
                if(temp.getLength()>i.getLength()) {
                    temp=i;
                }
            }
        }
        return temp;
    }

    public Vector<Node> BreadthFirstSearch(String start,String destination) {

        // Uninformed Breadth First Search Algorithm.

        Vector<Node> visited = new Vector<Node>();
        Vector<Node> toVisit = new Vector<Node>();
        toVisit.add(this.findNode(start));

        while(!toVisit.isEmpty()) {
            for(Node i:toVisit) {
                if(i.getName()==destination) {
                    visited.add(i);
                    toVisit.clear();
                    break;
                }
                if(!i.isVisited(visited)) {
                    visited.add(i);
                    for(Node j: i.getChilds()) {
                        if(!j.isVisited(visited)) {
                            toVisit.add(j);
                        }
                    }
                }
                toVisit.remove(i);
                break;
            }
        }
        return visited;
    }

    public Vector<Node> DepthFirstSearch(String start,String destination) {
        
        // Uninformed Depth First Search Algorithm.

        Vector<Node> visited = new Vector<Node>();
        LinkedList<Node> toVisit = new LinkedList<Node>();
        
        toVisit.addLast(this.findNode(start));
        Node end;
        boolean visitedChilds;

        while(!toVisit.isEmpty()) {
            end=toVisit.getLast();
            if(end.getName()==destination) {
                visited.add(toVisit.getLast());
                toVisit.clear();
                break;
            }
            if(end.hasChilds()) {
                visitedChilds=true; 
                for(Node i:end.childs) {
                    if(i.isVisited(visited)) {
                        continue;
                    }
                    else{
                        visitedChilds=false;
                        toVisit.addLast(i);
                        break;
                    }
                }
                if(!visited.contains(end)) {
                    visited.add(end);
                }
                if(visitedChilds) {
                    toVisit.removeLast();
                }
            }
            else {
                visited.add(end);
                toVisit.removeLast();
            }

        }
        return visited;
    }

    public Vector<Node> DepthLimitedSearch(String start,String destination,int limit) {
        
         // Uninformed Depth Limited Search Algorithm.
        
        if(limit<0) {
            return null;
        }
        
        Vector<Node> visited = new Vector<Node>();
        LinkedList<Node> toVisit = new LinkedList<Node>();
        
        toVisit.addLast(this.findNode(start));
        Node end;

        boolean visitedChilds;
        int level=0;
        while(!toVisit.isEmpty()) {
            end=toVisit.getLast();
            if(end.getName()==destination) {
                visited.add(toVisit.getLast());
                toVisit.clear();
                break;
            }
            if(end.hasChilds()) {
                visitedChilds=true; 
                if(level<limit){
                    for(Node i:end.childs) {
                        if(i.isVisited(visited)) {
                            continue;
                        }
                        else{
                            visitedChilds=false;
                            toVisit.addLast(i);
                            level++;
                            break;
                        }
                    }
                }
                if(!visited.contains(end)) {
                    visited.add(end);
                }
                if(visitedChilds) {
                    toVisit.removeLast();
                    level--;
                }
            }
            else {
                visited.add(end);
                toVisit.removeLast();
                level--;
            }

        }
        return visited;
    }

    public Vector<Node> UniformCostSearch(String start, String destination) {
        
        // Uninformed Uniform Cost Search Algorithm

        int score = 0;
        String temp;

        Vector<Node> visited = new Vector<Node>();
        Node current = this.findNode(start);

        while(true) {
            if(current.getName()==destination) {
                visited.add(current);
                break;
            }
            else {
                visited.add(current);
                temp=current.finMinNodePath().getDestination();
                score=score+current.findPathTo(temp);
                current=current.getChildNodeByString(temp);
                if(current==null) {
                    break;
                }
                
            }
        }
        visited.add(new Node("The total path length is: " + String.valueOf(score),null));
        return visited;
    }


    public Vector<Node> GreedyBestFirstSearch(String start, String destination) {
        
        // Chooses the best heuristics
        
        int score = 0; 

        Vector<Node> visited = new Vector<Node>();
        Node current = this.findNode(start);
        Node temp;

        while(true) {
            if(current.getName()==destination) {
                visited.add(current);
                break;
            }
            else {
                visited.add(current);
                temp=current;
                current = current.findMinHeuristicToDestination(destination);
               
                if(current==null || temp == null) {
                    break;
                }
                else {
                    score = score + temp.findPathTo(current.getName());
                }
            }   
        }
        visited.add(new Node("The total path length is: " + String.valueOf(score),null));
        return visited;
    }

    private void setScoreRelaxation(Node from,String destination) {
        this.setScore(from.findPathTo(this.getName())+this.findHeuristicTo(destination));
    }

    private Node getBestOptionAstar(String destination,Vector<Node> visited) {
        
        Node result = null;
        for(Node i:this.getChilds()) {
            if(result==null) {
                result=i;
                  
            }          
            else {
                if(result.getScore()==-1) {
                    result.setScoreRelaxation(this, destination);
                }
                if(i.getScore()==-1) {
                    i.setScoreRelaxation(this, destination);
                }
               
                if(!i.isVisited(visited)) {
                    if(i.getScore()<result.getScore()) {
                        result=i;
                        result.setScoreRelaxation(this, destination);
                    }
                }
            }
        }
        return result;
    }



    public Vector<Node> aStarSearch(String start, String destination) {
        

        Vector<Node> visited = new Vector<Node>();
        LinkedList<Node> toVisit = new LinkedList<Node>();

        Node current = this.findNode(start);

        boolean found = false;
        visited.add(current);
        while(!found) {
            if(current.getName()==destination) {
                found = true;
                break;
            }
            else {
                toVisit.add(current);
                current=current.getBestOptionAstar(destination, visited);
                if(current == null) {
                    toVisit.pop();
                    current=toVisit.getLast();
                }
                else {
                    visited.add(current);
                }

                
            }
        }
        return visited;
    }

}
