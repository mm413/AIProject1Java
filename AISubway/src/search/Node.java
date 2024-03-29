package search;

import java.util.*;

/**
A node in a search tree. Contains a pointer to the parent (the node
that this is a successor of) and to the actual state for this node.
Note that if a state is arrived at by two paths, then there are two 
nodes with the same state. Also includes the action that got us to this
state, and the total path cost (also known as g) to reach the node. Other
functions may add an f and h value.

You will not need to subclass this class.
*/

public class Node{
	private State state;
	private Node parent;
	private Action action;
	private double pathCost;
	private int depth;
	
	/**
	Create a search tree node, derived from a parent by an action
	@param state The state that the search node represents
	@param parent The predecessor node
	@param action The action that caused us to reach state
	@param pathCost The total path cost up to and including state/action.
	*/
	public Node(State state, Node parent, Action action, double pathCost){
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.pathCost = pathCost;
		this.depth = 0;
		
		if(parent != null)
			this.depth = parent.depth + 1;
	}
	
	/**
	Create a search tree node with no parent. The path cost and depth of this node are assumed to be 0.
	@param state The state that the search node represents
	*/
	public Node(State state){
		this.state = state;
		this.parent = null;
		this.action = null;
		this.pathCost = 0;
		this.depth = 0;
	}
	
	public String toString(){
		return "<Node " + this.state + ">";
	}
	
	public State getState(){
		return state;
	}
	
	public Action getAction(){
		return action;
	}
	
	public double getPathCost(){
		return pathCost;
	}
	
	public int getDepth(){
		return depth;
	}
	
	/**
	Create a list of Nodes from the root to this Node.
	@return A list of Nodes.
	*/
	public ArrayList<Node> path(){
		Node x = this;
		ArrayList<Node> result = new ArrayList<Node>();
		result.add(x);
		
		while(x.parent != null){
			result.add(x.parent);
			x = x.parent;
		}
		
		Collections.reverse(result);
		
		return result;
	}
	
	/**
	Return a list of nodes reachable from this node. (See Figure 3.8)
	@param problem The search problem
	@return A list of Nodes that can be reached from the current node.
	*/
	public ArrayList<Node> expand(Problem problem){
		ArrayList<Tuple> successors = problem.successor(this.state);
		
		ArrayList<Node> nodelist = new ArrayList<Node>();
		for(Tuple tuple:successors){
			Action act = tuple.getAction();
			State next = tuple.getState();
			nodelist.add(new Node(next, this, act, problem.pathCost(this.pathCost, this.state, act, next)));
		}
		
		return nodelist;
	}
}