import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;


public class MatrixGame {

    private int[][] matrix = new int[3][3];
    private int h;
    private Coordinates cursor;

    MatrixGame(){}

    public Coordinates getCursor() {
        return cursor;
    }

    public void setCursor(Coordinates cursor) {
        this.cursor = cursor;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixGame(int[][] matrix, int h) {
        this.matrix = matrix;
        this.h = h;
        this.setCursor();
    }

    public MatrixGame(int[][] matrix) {
        this.matrix = matrix;
        this.cursor = this.getCursor();
        this.setCursor();
        this.setHScore();
    }




    static int[][] generateGame() {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int i = 1; i < 9; i++) {
            numbers.add(i);
        }
        numbers.add(-1);
        Collections.shuffle(numbers);
        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = numbers.getFirst();
                numbers.pop();
            }
        }
        return result;
    }

    private void setHScore() {
        int score = 0;
        int[][] solved = {{1,2,3},{4,5,6},{7,8,-1}};

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                    if(solved[i][j]!=this.matrix[i][j]) {                    
                        score++;
                    }
            }    
        }
        this.setH(score);
    }

    private boolean isEqualMatrix(int[][] matrix) { 
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(this.getMatrix()[i][j]!=matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void setCursor() {
        Coordinates result = null;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                
                if(this.getMatrix()[i][j]==-1) {
                    result = new Coordinates(i,j);
                }       
            }
        }
        this.setCursor(result);

    }

    private boolean isVisited(Vector<MatrixGame> visited) {
        
        for(MatrixGame i: visited) {
            if(this.isEqualMatrix(i.getMatrix())) {
                return true;
            }
        }
        return false;
    }

    private int[][] getNewMatrix() {
        int[][] result = new int[3][3];

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                result[i][j]=this.getMatrix()[i][j];
            }
        }

        return result;
    }


    private MatrixGame moveCursor(String direction) {
        int temp = -2;
        MatrixGame result = new MatrixGame();
        result.setMatrix(this.getNewMatrix());
        result.setCursor();
        result.setHScore();
        if(direction.toUpperCase()=="UP") {
            temp = result.getMatrix()[result.getCursor().getX()-1][result.getCursor().getY()];
            result.getMatrix()[result.getCursor().getX()-1][result.getCursor().getY()]=-1;
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()]=temp;
        }
        else if(direction.toUpperCase()=="DOWN") {
            temp = result.getMatrix()[result.getCursor().getX()+1][result.getCursor().getY()];
            result.getMatrix()[result.getCursor().getX()+1][result.getCursor().getY()]=-1;
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()]=temp;
        }  
        else if(direction.toUpperCase()=="LEFT") {
            temp = result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()-1];
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()-1]=-1;
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()]=temp;
        }  
        else if(direction.toUpperCase()=="RIGHT") {
            temp = result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()+1];
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()+1]=-1;
            result.getMatrix()[result.getCursor().getX()][result.getCursor().getY()]=temp;
        }   
        result.setHScore();
        result.setCursor();  
        return result;
    }
    
    private Vector<MatrixGame> generateChilds() {
        
        Vector<MatrixGame> results = new Vector<MatrixGame>();
        
       try {
            results.add(this.moveCursor("UP"));
       } 
        catch (Exception e) {
            // System.out.println("Up - failed!");
        }
        try {
            results.add(this.moveCursor("RIGHT"));
        } 
        catch (Exception e) {
            // System.out.println("Right - failed!");
        }
        try {
            results.add(this.moveCursor("DOWN"));
        } 
        catch (Exception e) {
            // System.out.println("Down - failed");
        }
        try {
            results.add(this.moveCursor("LEFT"));
        } 
        catch (Exception e) {
            // System.out.println("Left - failed");
        }
       return results;
    }

    public MatrixGame getBestChild(Vector<MatrixGame> visited) {
        MatrixGame result = null;
        Vector<MatrixGame> a = this.generateChilds();
        for(MatrixGame i: a) {
            if(result == null) {
                if(!i.isVisited(visited))
                {result = i;}
            } 
            else {
                if(!i.isVisited(visited)) {
                    if(result.getH()>=i.getH()) {
                        result=i;
                    }
                }
            }
        }
        return result;
    }

    public void printMatrixGame() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(this.getMatrix()[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static MatrixGame solveRandomGameMatrix(MatrixGame toSolve) {

        Vector<MatrixGame> visited = new Vector<MatrixGame>();
        MatrixGame board = toSolve;
        MatrixGame current = board;    
        System.out.println("Before: ");
        board.printMatrixGame();
        visited.add(current);
        try{
            while(current.getH()!=0) {
                visited.add(current);
                current=current.getBestChild(visited);
            }
        }
        catch(Exception e) {

        }
        return visited.lastElement();
    }

    

    


}