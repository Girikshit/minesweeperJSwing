import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class box implements ActionListener {
	private grid g;
    private boolean bomb;
    private boolean revealed;
    private boolean visited;
    private int bombcount;
    private int row;
    private int col;
    private JButton button;
    ImageIcon un=new ImageIcon("x.jpg");
    ImageIcon i0=new ImageIcon("0.jpg");
    ImageIcon i1=new ImageIcon("1.jpg");
    ImageIcon i2=new ImageIcon("2.jpg");
    ImageIcon i3=new ImageIcon("3.jpg");
    ImageIcon i4=new ImageIcon("4.jpg");
    ImageIcon i5=new ImageIcon("5.jpg");
    ImageIcon i6=new ImageIcon("6.jpg");
    ImageIcon i7=new ImageIcon("7.jpg");
    ImageIcon i8=new ImageIcon("8.jpg");
    ImageIcon i9=new ImageIcon("bomb.jpg");
    
    
    
    
    public box(){
        this.bomb=false;
        this.revealed=false;
        this.bombcount=0;
        this.visited=false;
        this.button= new JButton();
        this.button.setIcon(un);
        this.button.addActionListener(this);
    }
    
    public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	public boolean isBomb() {
		return this.bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isRevealed() {
		return this.revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
		if (revealed) {
			this.button.setIcon(getIcon(this.bombcount));
			//this.button.setBackground(Color.BLUE);
		}
	}

	public int getBombcount() {
		return this.bombcount;
	}

	public void setBombcount(int bombcount) {
		this.bombcount = bombcount;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public void display(){
    	
    	if (revealed) {
			if (this.isBomb()) {
				System.out.print("@");
			} else {
				System.out.print(this.bombcount);
			} 
		}else {
			System.out.print("8");
		}
    	
    }

    public void displayBomb(){
    	
    	if (this.isBomb()) {
    		System.out.print("@");
    	}else {
    		System.out.print("-");
    	}
    	
    }
    
    public ImageIcon getIcon(int bcount) {
    	switch(bcount){
    		case 0:return i0;
	    	case 1: return i1;
	    	case 2:return i2;
	    	case 3:return i3;
	    	case 4:return i4;
	    	case 5:return i5;
	    	case 6:return i6;
	    	case 7:return i7;
	    	case 8:return i8;
	    	case 9:return i9;
	    	default:return null;
    	}
    }
   

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	

	public grid getG() {
		return g;
	}

	public void setG(grid g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.button) {
			g.displayFrame();
			if (this.isBomb()) {
				this.button.setIcon(i9);
				//this.button.setBackground(Color.BLACK);
			}else {
				if (this.bombcount!=0) {
					//this.button.setBackground(Color.BLUE);
					this.button.setIcon(getIcon(this.bombcount));
				}else {
					g.searchAndReveal(row, col);
				}
			}
		}
		
	}
	
}
