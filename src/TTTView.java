import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class TTTView extends JFrame implements Observer {

	private ActionListener listener;
	private JButton[][] buttons;
	private JFrame frame;
	private JTextArea area = new JTextArea();
	private TTTModel md;
	private JPanel jp;
	
	public TTTView(TTTModel md, ActionListener al){
		this.md = md;
		this.listener = listener;
		jp = new JPanel();
		
		frame = new JFrame("TicTacToe");
		frame.setSize(300, 300);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    
	    jp.setLayout(new GridLayout(3,3));
	    buttons = new JButton[md.getSize()][md.getSize()];
	    
	    for(int i = 0; i< 3; i++){
	    	for(int j = 0; j<3; j++){
	    		buttons[i][j] = new JButton("");
	    		jp.add(buttons[i][j]);
	    		buttons[i][j].addActionListener(listener);
	    	}
	    }
	    
	    frame.getContentPane().add(jp, BorderLayout.CENTER);
	    frame.setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		TTTModel tm = new TTTModel(3);
		//ActionListener al = new ActionListener();
		TTTView tits = new TTTView(tm);
	}

}
