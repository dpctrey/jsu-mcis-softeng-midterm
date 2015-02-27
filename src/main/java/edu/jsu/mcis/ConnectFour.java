package edu.jsu.mcis;

public class ConnectFour {
    public enum Location {EMPTY, RED, BLACK};
    private Location[][] myArray = new Location[6][7];
	private int countOfEmpties = 0;
	private int countOfNotEmpties = 0;
	private boolean redTurn = true;
    public ConnectFour() {
        for (int r = 0; r < 6; r++){
			for (int c = 0; c < 7; c++){
				myArray[r][c] = Location.EMPTY;
			}
		}
    }
    
    public Location getTopOfColumn(int column) {
		int myStart = getHeightOfColumn(column);
		if (myStart == 0){
			return Location.EMPTY;
		}
		else {
			return myArray[myStart-1][column];
		}
    }
    
    public int getHeightOfColumn(int column) {
		countOfEmpties = 0;
		countOfNotEmpties = 0;
        for (int r = 0; r < 6; r++){
			if (myArray[r][column] == Location.EMPTY){
				countOfEmpties++;
			}
			else{
				countOfNotEmpties++;
			}
		}
		return countOfNotEmpties;
    }
    
    public void dropToken(int column) {
        int startPoint = getHeightOfColumn(column);
		if (startPoint >= 6){
			throw new ColumnFullException("\n This column is full! Please try again! \n");
		}
		if (redTurn && startPoint < 6){
			myArray[startPoint][column] = Location.RED;
		}
		if (!redTurn){
			myArray[startPoint][column] = Location.BLACK;
		}
		if (redTurn){
			redTurn = false;
		}
		else {
			redTurn = true;
		}
    }
}