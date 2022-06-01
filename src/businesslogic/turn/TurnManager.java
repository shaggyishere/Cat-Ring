package businesslogic.turn;

public class TurnManager {
    private TurnTable turnTable;

	// DUBBIO: avrebbe senso farlo statico? Bu...
	public void specifyTurnCompleteness(Turn turn, boolean isComplete) {
		this.turnTable.specifyTurnCompleteness(turn, isComplete);
	}

	public TurnTable getTurnTable() {
		return turnTable;
	}
}
