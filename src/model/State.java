package model;

public class State {
	private char name;
	private char destiny1;
	private char destiny2;
	private char out1;// Only for Mealy
	private char out2;// Only for Mealy
	private char stateValue; // Only for Moore

	public State(char name, char destiny1, char destiny2, char out1, char out2, char stateValue) {
		this.name = name;
		this.destiny1 = destiny1;
		this.destiny2 = destiny2;
		this.out1 = out1;
		this.out2 = out2;
		this.stateValue = stateValue;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public char getDestiny1() {
		return destiny1;
	}

	public void setDestiny1(char destiny1) {
		this.destiny1 = destiny1;
	}

	public char getDestiny2() {
		return destiny2;
	}

	public void setDestiny2(char destiny2) {
		this.destiny2 = destiny2;
	}

	public char getOut1() {
		return out1;
	}

	public void setOut1(char out1) {
		this.out1 = out1;
	}

	public char getOut2() {
		return out2;
	}

	public void setOut2(char out2) {
		this.out2 = out2;
	}

	public char getStateValue() {
		return stateValue;
	}

	public void setStateValue(char stateValue) {
		this.stateValue = stateValue;
	}
}