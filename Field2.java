package snakalicious;

public class Field2 {
	private int row2, column2;

	public Field2(int row2, int column2) {
		this.row2 = row2;
		this.column2 = column2;
	}
	
	public boolean equals(Field2 field2) {
		if(field2.column2 == this.column2){
			if(field2.row2 == this.row2){
				return true;
			}
		}
			return false;
		
	}

	public int getRow2() {
		return row2;
	}

	public void setRow2(int row2) {
		this.row2 = row2;
	}

	public int getColumn2() {
		return column2;
	}

	public void setColumn2(int column2) {
		this.column2 = column2;
	}

}

