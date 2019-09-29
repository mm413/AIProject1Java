package search;

import subway.Station;

public class StationState extends State {
	int id;
	String name;

	public StationState(String n, int ident) {
		super(n);
		this.id  = ident;
		this.name = n;
		
	}
	public int getID() {
		return this.id;
	}
	public boolean equals(State s){
		return this.name.equals(s.getName());
	}

}
