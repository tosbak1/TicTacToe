import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class TTTView extends JFrame implements Observer {

	private ActionListener listener;
	private JButton[][] buttons;
	private JButton resetButton;
	private JFrame frame;
	private JPanel jp;
	private JPanel jp2;
	

	private TTTModel md;
	private int value;
	
	
	public TTTView(int size, ActionListener al){
		this.value = size;
		this.listener = al;
		jp = new JPanel();
		jp2 = new JPanel();
		
		frame = new JFrame("TicTacToe");
		frame.setSize(300, 300);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    
	    jp.setLayout(new GridLayout(size,size));
	    buttons = new JButton[size][size];
	    
	    //Reset button
	    resetButton = new JButton("Reset");
	    resetButton.addActionListener(listener);
	    jp2.add(resetButton);
	    frame.getContentPane().add(jp2, BorderLayout.SOUTH);
	    //frame.setVisible(true);
	    
	    
	    for(int i = 0; i< size; i++){
	    	for(int j = 0; j<size; j++){
	    		buttons[i][j] = new JButton("*");
	    		buttons[i][j].addActionListener(listener);
	    		
	    		jp.add(buttons[i][j]);
	    		buttons[i][j].setActionCommand("" + i + " " + j);
	    	}
	    }
	    
	    frame.getContentPane().add(jp, BorderLayout.CENTER);
	    frame.setVisible(true);
	}
	
	
	//returns the reset button
	public JButton getResetButton(){
		return this.resetButton;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		TTTModel md = (TTTModel)o;
		for(int i = 0; i< value; i++){
			for(int j = 0; j <value; j++){
				buttons[i][j].setText(md.getText(i, j));
			}
		}
		
	}
	


}
