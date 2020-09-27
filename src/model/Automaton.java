package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Automaton {
	private ArrayList<State> states;
	private String initialState;
	private int type; // 0 for Mealy 1 for Moore
	private HashMap<String, ArrayList<String>> listConections;

	public Automaton() {
		states = new ArrayList<>();
		initialState = "";
		listConections = new HashMap<String, ArrayList<String>>();
	}

	/**
	 * This method adds a state type object to ArrayList<State>
	 * pre: States should be initialized
	 * post: A new state has been added to ArrayList<State>
	 * @param state type State and type of State (0 for Mealy 1 for Moore)
	 */
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

	/**
	 * This method selects the initial state
	 * post: The initial state has been chosen
	 * @param String initialState with the name of the initial state
	 */
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	/**
	 * BFS method removes inaccessible states
	 * pre: There must be a set of states
	 * post: Inaccessible states have been removed
	 */
	public void BFS() {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		for (int i = 0; i < states.size(); i++) {
			visited.put(states.get(i).getName() + "", false);
		}

		Queue<String> queue = new LinkedList<String>();
		visited.put(initialState, true);
		queue.add(initialState);

		while (queue.size() != 0) {
			String temp = queue.poll();
			for (String state : listConections.get(temp)) {
				if (!visited.get(state)) {
					visited.put(state, true);
					queue.add(state);
				}
			}
		}

		for (String accesible : visited.keySet()) {
			if (visited.get(accesible) == false) {
				listConections.remove(accesible);
			}
		}
	}
}