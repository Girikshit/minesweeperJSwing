import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class grid {
	int rowSize;
	int colSize;
	JFrame frame;
	box[][] table;
	boolean deathscreen= false;

	public grid(int row, int col) {
		this.rowSize=row;
		this.colSize=col;
		table = new box[row][col];
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(row,col));
		frame.setTitle("Minesweeper");
		frame.setResizable(true);
		
		
        for(int r=0;r<row;r++) {
        	for(int c=0;c<col;c++) {
        		table[r][c]= new box();
        		table[r][c].setRow(r);
        		table[r][c].setCol(c);
        		table[r][c].setG(this);
        		frame.add(table[r][c].getButton());
        	}
        }
        frame.setVisible(true);
	}
	
	public void displayFrame() {
		for(int r=0;r<this.rowSize;r++) {
        	for(int c=0;c<this.colSize;c++) {
        		table[r][c].display();
        		
        	}
        	System.out.println("");
        }
		System.out.println("");
	}
	
	public void displayBombs() {
		for(int r=0;r<this.rowSize;r++) {
        	for(int c=0;c<this.colSize;c++) {
        		table[r][c].displayBomb();
        	}
        	System.out.println("");
        }
		System.out.println("");
	}
	
	public void displayNums() {
		for(int r=0;r<this.rowSize;r++) {
        	for(int c=0;c<this.colSize;c++) {
        		if(table[r][c].isBomb()) {
        			System.out.print("@");
        		}else {
        			System.out.print(table[r][c].getBombcount());
        		}
        	}
        	System.out.println("");
		}
		System.out.println("");
	}

	
	public void fillBombs() {
		Random random = new Random();
		int noofbombs= (rowSize*colSize)/6;
		int rrow;
		int rcol;
		
		for(int i=1;i<noofbombs;i++) {
			rrow=random.nextInt(this.rowSize);
			rcol=random.nextInt(this.colSize);
			this.table[rrow][rcol].setBomb(true);;
			
		}	
	}
	
	public void applybombCounts(){
		for(int r=0;r<this.rowSize;r++) {
        	for(int c=0;c<this.colSize;c++) {
        		table[r][c].setBombcount(countBombs(r,c));
        	}
		}
	}
	
	//counts bombs around 1 box
	public Integer countBombs(int r,int c) {
		if (table[r][c].isBomb()) {
			return  0;
		}else {
			int count=0;
			if(isvalidPos(r-1,c-1)) {
				if(table[r-1][c-1].isBomb()) {
					count+=1;
				}
			}

			if(isvalidPos(r-1,c)) {
				if(table[r-1][c].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r-1,c+1)) {
				if(table[r-1][c+1].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r,c-1)) {
				if(table[r][c-1].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r+1,c-1)) {
				if(table[r+1][c-1].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r,c+1)) {
				if(table[r][c+1].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r+1,c+1)) {
				if(table[r+1][c+1].isBomb()) {
					count+=1;
				}
			}
			if(isvalidPos(r+1,c)) {
				if(table[r+1][c].isBomb()) {
					count+=1;
				}
			}
			return count;
		}
	}
	 
	private boolean isvalidPos(int r,int c){
		return!(r<0||r>=rowSize||c<0||c>=colSize);

	}
	
	
	public void searchAndReveal(int r, int c) {
		if (!table[r][c].isBomb()&& table[r][c].getBombcount()==0&&table[r][c].isVisited()==false) {
			table[r][c].setVisited(true);
			table[r][c].setRevealed(true);
			if(isvalidPos(r-1,c-1)) {
				table[r - 1][c - 1].setRevealed(true);
				searchAndReveal(r-1,c-1);
			}

			if(isvalidPos(r-1,c)) {
				table[r-1][c].setRevealed(true);
				searchAndReveal(r-1,c);
			}
			if(isvalidPos(r-1,c+1)) {
				table[r-1][c+1].setRevealed(true);
				searchAndReveal(r-1,c+1);
			}
			if(isvalidPos(r,c-1)) {
				table[r][c-1].setRevealed(true);
				searchAndReveal(r,c-1);
			}
			if(isvalidPos(r+1,c-1)) {
				table[r+1][c-1].setRevealed(true);
				searchAndReveal(r+1,c-1);
			}
			if(isvalidPos(r,c+1)) {
				table[r][c+1].setRevealed(true);
				searchAndReveal(r,c+1);
			}
			if(isvalidPos(r+1,c+1)) {
				table[r+1][c+1].setRevealed(true);
				searchAndReveal(r+1,c+1);
			}
			if(isvalidPos(r+1,c)) {
				table[r+1][c].setRevealed(true);
				searchAndReveal(r+1,c);
			}

		}
	}
	
	public box searchButton(Object object ) {
		box b=new box();
		for(int r=0;r<this.rowSize;r++) {
        	for(int c=0;c<this.colSize;c++) {
        		if (table[r][c].getButton().equals(object)) {
        			b=table[r][c];
        		}
        	}	
        }
		return b;
	}

	public void setDeathScreen() {
		if(!deathscreen){
			new DeathScreen(this);
			deathscreen= true;
		}
	}

}
