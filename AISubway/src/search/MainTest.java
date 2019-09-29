package search;

import java.io.FileNotFoundException;

import subway.SubwayMap;

public class MainTest {

	public static void main(String[] args) throws FileNotFoundException {
		//create map
		SubwayMap bostonMap = subway.SubwayMap.buildBostonMap();
		//create parameters for start/ end
		int startid = bostonMap.getStationByName("Fenway").id;
		String startName = bostonMap.getStationByName("Fenway").name;
		int endid = bostonMap.getStationByName("South Station").id;
		String endName = bostonMap.getStationByName("South Station").name;
		//create start/end states
		StationState startState = new StationState(startName, startid);
		StationState endState = new StationState(endName, endid);
		//create Problem
		SubwayProblem Bostonprob = new SubwayProblem(startState, bostonMap);
		//Call Search
		Search.depthFirstSearch(Bostonprob);
//		StationState state = new StationState(bostonMap.getStationByID(1).toString(), 
//		SubwayProblem problem = new SubwayProblem(bostonMap.)
	}

}
