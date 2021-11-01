/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Player {
    private int row;
    private int col;
    
    public Player(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public void moveNorth(){
        this.row--;
    }
    
    public void moveSouth(){
        this.row++;
    }
    
    public void moveEast(){
        this.col++;
    }
    
    public void moveWest(){
        this.col--;
    }
    
}
