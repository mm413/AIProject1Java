package search;

import java.util.ArrayList;

import subway.Station;
import subway.SubwayMap;

public class SubwayWalkProblem extends SubwayProblem {
	SubwayMap map;
	State goal;
	ArrayList<State> goalStates;
	double leewayDistance;
	

	public SubwayWalkProblem(State initial, State goal, SubwayMap map, double leewayDistance) {
		super(initial, goal, map);
		this.map = map;
		this.goal = goal;
		this.leewayDistance = leewayDistance;
		this.goalStates = findLeewayGoals();
	}
	
	private ArrayList<State> findLeewayGoals(){
		ArrayList<State> goals = new ArrayList<State>();
		for (Station stat: map.stations()) {
			if (SubwayMap.straightLineDistance(map.getStationByName(goal.getName()), stat) <=leewayDistance) {
				goals.add(new StationState(stat.name, stat.id));
			}
		}
		return goals;
	}
	@Override
	public boolean goalTest(State state){
		for (State goal: goalStates) {
			if (state.equals(goal)) {
				return true;
			}
		}
		return false;
	}


}
