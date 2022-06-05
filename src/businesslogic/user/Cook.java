package businesslogic.user;

import businesslogic.event.EventInfo;
import businesslogic.turn.Turn;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
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
