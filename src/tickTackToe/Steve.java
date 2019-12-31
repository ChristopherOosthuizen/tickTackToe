package tickTackToe;

import java.util.ArrayList;
import java.util.Arrays;

public class Steve {
	private Board b;
	private int[][] value_table;
	public Steve(Board b) {
		this.b = b;
		int[][]vals ={{8,1,9},
				{4,5,3},
				{7,2,6}};
		 this.value_table = vals;
	}
	public int[] random() {
		ArrayList<ArrayList<Spot>> lister = b.getList();
		int []spot = new int[2];
		
		while(lister.get(spot[0]).get(spot[1]).getSpot() != 0) {
			spot[0] = (int)(Math.random()*3);
			spot[1] = (int)(Math.random()*3);
		}
		return spot;
	}
	public int[] containsTwoOppsong() {
		int count =0;
		
		for(int ii=0; ii<3;ii++) {
		count =0;
		for(int i=0; i<3;i++) {
			
			if(value_table[i][ii] ==0)
				count++;
			
		}
		
		if(count ==2) {
			for(int i=0;i<3;i++) {
				value_table[i][ii] *=9;
			}
		}
		
		}
		count =0;
		for(int ii=0; ii<3;ii++) {
			count =0;
			for(int i=0; i<3;i++) {
				
				if(value_table[ii][i] ==0)
					count++;
				
			}
			
			if(count ==2) {
				for(int i=0;i<3;i++) {
					value_table[ii][i] *=9;
				}
			}
			
			}	count =0;
			
			
			if(value_table[0][0] ==0)
				count++;
			if(value_table[2][2] ==0)
				count++;
			if(value_table[1][1] ==0)
				count++;
			
		
		
		if(count ==2) {
			
				value_table[0][0] *=50;
				value_table[2][2] *=50;
				value_table[1][1] *=50;
		}
		count =0;
		
		
		if(value_table[0][2] ==0)
			count++;
		if(value_table[2][0] ==0)
			count++;
		if(value_table[1][1] ==0)
			count++;
		
	
	
	if(count ==2) {
		
			value_table[0][2] *=50;
			value_table[2][0] *=50;
			value_table[1][1] *=50;
	}
		
		
		return null;
	}
	public int[] containsTwoFor() {
		int count =0;
		
		for(int ii=0; ii<3;ii++) {
		count =0;
		for(int i=0; i<3;i++) {
			
			if(value_table[i][ii] <0)
				count++;
			
		}
		
		if(count ==2) {
			for(int i=0;i<3;i++) {
				value_table[i][ii] *=50;
			}
		}
		
		}
		count =0;
		for(int ii=0; ii<3;ii++) {
			count =0;
			for(int i=0; i<3;i++) {
				
				if(value_table[ii][i] <0)
					count++;
				
			}
			
			if(count ==2) {
				for(int i=0;i<3;i++) {
					value_table[ii][i] *=50;
				}
			}
			
			}
		
			count =0;
			
				
				if(value_table[0][0] <0)
					count++;
				if(value_table[2][2] <0)
					count++;
				if(value_table[1][1] <0)
					count++;
				
			
			
			if(count ==2) {
				
					value_table[0][0] *=50;
					value_table[2][2] *=50;
					value_table[1][1] *=50;
			}
			count =0;
			
			
			if(value_table[0][2] <0)
				count++;
			if(value_table[2][0] <0)
				count++;
			if(value_table[1][1] <0)
				count++;
			
		
		
		if(count ==2) {
			
				value_table[0][2] *=50;
				value_table[2][0] *=50;
				value_table[1][1] *=50;
		}
			
			
		
		
		return null;
	}
	public int[] calculated() {
		ArrayList<ArrayList<Spot>> lister = b.getList();
		for(int i=0; i< 3;i++) {
			for(int ii=0;ii<3;ii++) {
				if(lister.get(i).get(ii).getSpot() == 'y') {
					value_table[i][ii] =0;
				}if(lister.get(i).get(ii).getSpot() == 'x') {
					value_table[i][ii] =-1;
				}
			}
		}
		
		containsTwoFor();
		containsTwoOppsong();
		
		int[] max = {0,0};
		for(int i=0;i< 3;i++) {
			for(int ii=0;ii<3;ii++) {
				if(value_table[i][ii] > value_table[max[0]][max[1]]) {
					max[0] = i;
					max[1] =ii;
				}
			}
		}
		if(b.turn ==1 && lister.get(1).get(1).getSpot() ==0) {
			max[0] = 1;
			max[1] =1;
		}
		System.out.println();
		Arrays.stream(value_table).map(Arrays::toString).forEach(System.out::println);
		
		return max;
	}
}
