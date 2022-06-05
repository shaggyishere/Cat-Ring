package businesslogic.turn;

import java.util.List;

public class TurnTable {
    private List<Turn> turns; //da cancellare visto che i turni verranno fetchati da db

	public void specifyTurnCompleteness(Turn turn, boolean isComplete) {
		if (getTurns().contains(turn))
			turn.setCompleteness(isComplete);
	}

	public List<Turn> getTurns() {
		// TODO: fetchare tutti i turni da db
		return turns;
	}
}
