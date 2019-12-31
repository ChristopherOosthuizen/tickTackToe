package tickTackToe;

import javax.swing.JButton;

public class Spot extends JButton{
	private char spot;

	public char getSpot() {
		return spot;
	}

	public void setSpot(char spot) {
		this.spot = spot;
		this.setText(spot+"");
	}
	
}
