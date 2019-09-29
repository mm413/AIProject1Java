package search;

import java.util.*;

public class NodeComparator implements Comparator<Node>{
	Problem problem;
	public NodeComparator(Problem problem) {
		this.problem = problem;
	}
	@Override
	public int compare(Node o1, Node o2) {
		if (o1.getPathCost()+ problem.h(o1) < o2.getPathCost() + problem.h(o2)) {
			return 1;
		}else if (o1.getPathCost()+ problem.h(o1) > o2.getPathCost()+ problem.h(o2)) {
			return -1;
		}
		return 0;
	}

}
