import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main  {
	static grid t= new grid(10,10);
    public static void main(String[] args) {
    	System.out.println(System.getProperty("user.dir"));
    	t.fillBombs();
    	t.displayBombs();//displays position of bombs in stdout
    	t.applybombCounts();
    	t.displayNums();//displays bombs with corresponding neighbour numbers in stdout
    	t.displayFrame(); // displays state of current frame in stdout
    }

}
