package businesslogic.user;

import businesslogic.turn.Turn;

import java.util.ArrayList;
import java.util.List;

public class Cook extends User{
	private List<Turn> availableTurns;

	public Cook() {
		super();
		availableTurns = new ArrayList<>();
	}

	public boolean availableFor(Turn turn){
		return availableTurns.contains(turn);
	}
}
