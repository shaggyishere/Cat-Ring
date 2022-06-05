package businesslogic.turn;

import java.util.List;

public class TurnManager {

	public void specifyTurnCompleteness(Turn turn, boolean isComplete) {
		turn.setCompleteness(isComplete);
	}

	public List<Turn> getTurnTable() {
		return TurnTable.getTurns();
	}

}
