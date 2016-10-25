import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TTTView extends JFrame implements Observer {

	private ActionListener listener;
	private JButton[][] buttons;
	private JFrame frame;
	private JTextArea area = new JTextArea();
	private TTTModel md;
	
	public TTTView(TTTModel md, ActionListener listener){
		this.md = md;
		this.listener = listener;
		frame = new JFrame("TicTacToe");
		frame.setSize(300, 300);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    
	    
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
