import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathScreen implements ActionListener {
    JFrame frame;
    grid gridToDispose;
    JPanel panel;
    JButton button1;
    JButton button2;

    public DeathScreen(grid g){
        frame = new JFrame("You died");
        gridToDispose= g;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);

        button1 = new JButton("Play Again");
        button1.addActionListener(this);

        button2 = new JButton("Exit");
        button2.addActionListener(this);

        panel.add(button1);
        panel.add(button2);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.button1){
            gridToDispose.frame.dispose();
            gridToDispose=null;
            frame.dispose();
            grid t=new grid(10,10);
            t.fillBombs();
            t.displayBombs();//displays position of bombs in stdout
            t.applybombCounts();
            t.displayNums();//displays bombs with corresponding neighbour numbers in stdout
            t.displayFrame();
        }else if(e.getSource()==this.button2){
            gridToDispose.frame.dispose();
            gridToDispose=null;
            frame.dispose();
        }
    }
}
