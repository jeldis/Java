package com.javacodegeeks.javabasics.twoDarray;

public class TwoDarrayClass {

	static final int ROWS = 4;
	static final int COLS = 2;
	
	private int num;
	private String name;
	
	public TwoDarrayClass(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}

	public static void main(String[] args) {

		// first way of 2d array
		int[][] tableInt = new int[ROWS][COLS];
		
		// put values into the tableInt
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				tableInt[i][j] = i+j;
			}
		}
		// retrieve all values of table using foreach
		String outputTable1="Values of tableInt:\n";
		for (int[] row : tableInt) {
            for (int val : row) {
            	outputTable1 += " " + val;
            }
            outputTable1 += "\n";
        }
		System.out.println(outputTable1);
		
		// second way of 2d array, using a class
		TwoDarrayClass[][] tableClass;
		// array of references to arrays
		tableClass = new TwoDarrayClass[ROWS][];
		
		for(int i=0; i<ROWS; i++) {
			tableClass[i] = new TwoDarrayClass[COLS];
		}
		
		// create the object into the tableClass
		for(int i=0; i<tableClass.length; i++) {
			for(int j=0; j<tableClass[i].length; j++) {
				tableClass[i][j] = new TwoDarrayClass(i+j, "row"+i+"-col"+j);
			}
		}
		
		// print the name of the class of the tableClass
		String outputTable2 = "The values of tableClass:\n";
		for (int row = 0; row < tableClass.length; row++) {
            for (int col = 0; col < tableClass[row].length; col++) {
                outputTable2 += " name = " + tableClass[row][col].getName()+ "|";
            }
            outputTable2 += "\n";
        }
		System.out.println(outputTable2);
		
		// a more static way...
		String[][] fruitsTable = new String[][] {
				{"apple","orange"},
				{"kiwi","strawberry"}, 
				{"peach","melon"} , 
				{"cranberry","grape"}
		};
		System.out.println("Fruits in winter are: "+fruitsTable[0][0]+" and "+fruitsTable[0][1]);
		System.out.println("Fruits in summer are: "+fruitsTable[2][0]+" and "+fruitsTable[2][1]);
		
		
	}

}
