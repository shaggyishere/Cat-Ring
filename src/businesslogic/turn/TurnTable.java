package businesslogic.turn;

import persistence.PersistenceManager;

import java.util.ArrayList;
import java.util.List;

public class TurnTable {

	public static List<Turn> getTurns() {
		List<Turn> turns = new ArrayList<>();
		String userQuery = "SELECT * FROM Turns";
		PersistenceManager.executeQuery(userQuery, rs -> {
			Turn turn = new Turn(rs.getString("when"));
			turn.setCompleteness(rs.getInt("completed") != 0);
			turns.add(turn);
		});
		return turns;
	}
}
