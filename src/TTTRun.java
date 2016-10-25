
public class TTTRun {
	
	
	public static void main(String[] args){
		TTTModel tm = new TTTModel(3);
		//TTTView tv = new TTTView(3, tc);
		TTTController tc = new TTTController(tm);
		TTTView tv = new TTTView(3, tc);
		tc.setView(tv);

		tm.addObserver(tv);
	}
}
