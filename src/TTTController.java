import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTController implements ActionListener{
	private TTTModel tModel;
	private TTTView tView;
	
	public TTTController(TTTModel tm){
		this.tModel = tm;
	}
	
	public void setView(TTTView tv){
		this.tView = tv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String reset = tView.getResetButton().getActionCommand();
		String action = arg0.getActionCommand();
		if(action.equals(reset)){
			tModel.boardReset();
			return;
		}
		
		
			String[] moves = action.split(" ");
			
			int x = Integer.parseInt(moves[0]);
			int y = Integer.parseInt(moves[1]);
			
			tModel.play(x, y);
	}

}
