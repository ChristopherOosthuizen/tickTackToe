package tickTackToe;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Board {
	private ArrayList<ArrayList<Spot>> list;
	private JFrame frame;
	public int turn;
	private Steve steve;
	public Board() {
		turn =1;
		list = new ArrayList<ArrayList<Spot>>();
		frame=new JFrame();
		
		
		ActionListener Move = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Spot sp= (Spot)e.getSource();
				
				if(!isWin()&&((Spot)e.getSource()).getSpot() == 0) {
					
					((Spot)e.getSource()).setSpot('y');
					
					if(!isWin()) {
					int[] spots = steve.calculated();
					list.get(spots[0]).get(spots[1]).setSpot('x');
					
					
					}
					turn++;
				}
				isWin();
					
			}
			
		};
		
		
		GridLayout layout =new GridLayout(0,3);
		for(int i=0;i<3;i++) {
			list.add(new ArrayList<Spot>());
			for(int ii=0;ii<3;ii++) {
			Spot but = new Spot();
			list.get(i).add(but);
			but.addActionListener(Move);
			frame.add(but);
		}
		}
		frame.setLayout(layout);
		
		
		
		frame.setSize(400,400);
		frame.setVisible(true);
		steve = new Steve(this);
		
	}
	private boolean isWin() {
		for(int i=0;i< list.size();i++) {
			char spot = list.get(i).get(0).getSpot();
			if(spot !=0&&list.get(i).get(1).getSpot() == spot && list.get(i).get(2).getSpot() == spot) {
				System.out.println(spot =='y'?"you win":"you lose");
				return true;
			}
		}
		for(int i=0;i< list.size();i++) {
			char spot = list.get(1).get(i).getSpot();
			if(spot !=0&&list.get(0).get(i).getSpot() == spot && list.get(2).get(i).getSpot() == spot) {
				System.out.println(spot =='y'?"you win":"you lose");
				return true;
			}
		}
		char spot = list.get(1).get(1).getSpot();
		if(spot !=0&&list.get(0).get(2).getSpot() == spot && list.get(2).get(0).getSpot() == spot) {
			System.out.println(spot =='y'?"you win":"you lose");
			return true;
		}
		if(spot !=0&&list.get(0).get(0).getSpot() == spot && list.get(2).get(2).getSpot() == spot) {
			System.out.println(spot =='y'?"you win":"you lose");
			return true;
		}
		return false;
	}
	
	
	public ArrayList<ArrayList<Spot>> getList(){
		return list;
	}
	
	

}
