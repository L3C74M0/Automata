package model;

import java.util.ArrayList;

public class Automaton {
	private ArrayList<State> states;
	private String initialState;
	private int type; //0 for Mealy 1 for Moore
	
	public Automaton() {
		states = new ArrayList<>();
		initialState = "";
	}

	public void addState(State state, int type) {
		states.add(state);
		this.type = type;
	}
	
	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}
	
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}
	
	/*
	public void print() {
		if (type == 0) { //Print Mealy
			for (int i = 0; i < states.size(); i++) {
				System.out.println("Nombre: " + states.get(i).getName() + "\tDestino 1: " + states.get(i).getDestiny1() + "\tDestino 2: " + states.get(i).getDestiny2() + 
						"\tSalida 1: " + states.get(i).getOut1() + "\tSalida 2: " + states.get(i).getOut2() +"\n");
			}
		}else {
			for (int i = 0; i < states.size(); i++) {
				System.out.println("Nombre: " + states.get(i).getName() + "\tDestino 1: " + states.get(i).getDestiny1() + "\tDestino 2: " + states.get(i).getDestiny2() + 
						"\tValor del estado: " + states.get(i).getStateValue() +"\n");
			}
		}
	}	
	*/
}