
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Controller {
    private MainScreen view;
    private Player player;
    private Scene[][] map;
    private int numRows;
    private int numCols;
    
    public Controller(MainScreen view, String filename){
        this.view = view;
        // read in the file
        try{
            Scanner input = new Scanner(new File(filename));
            // getting the map rows and columns
            this.numRows = input.nextInt();
            input.nextLine(); // drop to a new line
            this.numCols = input.nextInt();
            input.nextLine();
            // getting the player start row and column
            int startRow = input.nextInt();
            input.nextLine();
            int startCol = input.nextInt();
            input.nextLine();
            
            // create the player
            this.player = new Player(startRow, startCol);
            // create the scene array
            this.map = new Scene[numRows][numCols];
            
            // for loop to track the rows
            for(int row = 0; row < numRows; row++){
                // for loop to track columns
                for(int col = 0; col < numCols; col++){
                    String picName = input.next();
                    String description = input.nextLine();
                    
                    // create the scene and store it
                    this.map[row][col] = new Scene(picName, description);
                }
            }
            
            updatePicture();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    // helper method
    private void updatePicture(){
        int row = this.player.getRow();
        int col = this.player.getCol();
        
        BufferedImage pic = this.map[row][col].getImage();
        this.view.setPicture(pic);
        
        String description = this.map[row][col].getDescription();
        this.view.setInfo(description);
    }
    
    
    public void moveNorth(){
        if(this.player.getRow() > 0){
            this.player.moveNorth();
        }
        // update the picure
        updatePicture();
    }
    
    public void moveSouth(){
        if(this.player.getRow() < this.numRows - 1){
            this.player.moveSouth();
        }
        // update the picure
        updatePicture();
    }
    
    public void moveEast(){
        if(this.player.getCol() < this.numCols - 1){
            this.player.moveEast();
        }
        // update the picure
        updatePicture();
    }
    
    public void moveWest(){
        if(this.player.getCol() > 0){
            this.player.moveWest();
        }
        // update the picure
        updatePicture();
    }
    
}
