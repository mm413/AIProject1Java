package search;

import java.util.ArrayList;

public class EightPuzzleProblem extends Problem {
	State initial;
	State goal = new State("012345678");

	public EightPuzzleProblem(State initial) {
		super(initial);
		// TODO Auto-generated constructor stub
	}

	public EightPuzzleProblem(State initial, State goal) {
		super(initial, goal);
		this.initial = initial;
		this.goal = goal;
	}

	@Override
	public ArrayList<Tuple> successor(State state) {
		ArrayList<Tuple> successors = new ArrayList<Tuple>();
		char[] gameList = state.getName().toCharArray();
		for (int i =0; i < gameList.length; i++) {
		}
		for (int i =0; i < gameList.length; i++) {
			if (gameList[i] == '0'){
				//swap 0 with one above
				gameList[i] = gameList[i-3];
				gameList[i-3] = '0';
				Action act = new Action("up to");
				State newState = new State(new String (gameList));
				successors.add(new Tuple(act, newState));
				//swap 0 with one left
				gameList[i-3] = gameList[i-4];
				gameList[i-4] = '0';
				Action act2 = new Action("left to");
				State newState2 = new State(new String (gameList));
				successors.add(new Tuple(act2, newState2));
				//swap 0 with one below
				gameList[i-4] = gameList[i-1];
				gameList[i-1] = '0';
				Action act3 = new Action("down to");
				State newState3 = new State(new String (gameList));
				successors.add(new Tuple(act3, newState3));
				//swap 0 with one right
				gameList[i-1] = gameList[i];
				gameList[i] = '0';
				Action act4 = new Action("right to");
				State newState4 = new State(new String (gameList));
				successors.add(new Tuple(act4, newState4));
				return successors;
			}
		}
		System.out.println("here");
		return successors;
	}
//	private char[] makeMoves(char[] gameList) {
//		for (int i =0; i < gameList.length; i++) {
//			//this is equilavent of going up, left, down, right. idk how, but i did it out on paper, and it is.
//			if (gameList[i] == '0') {
//				char temp = gameList[i-1];
//				gameList[i-1] = gameList[i-3];
//				char temp2 = gameList[i-4];
//				gameList[i-4] = temp;
//				gameList[i-3] = temp2;
//			}
//		}
//		return gameList;
//		
//	}
	@Override
	public boolean goalTest(State state){
		return state.toString().equals(this.goal.toString());
	}

}
