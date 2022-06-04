package businesslogic.turn;

public class TurnManager {
    private TurnTable turnTable;

	// DUBBIO: avrebbe senso farlo statico? Bu...
	//è la stessa cosa di KitchenTaskManager.. io avrei pensato tutte queste classi come statiche,
	//loro preferiscono usare il pattern Singleton
	public void specifyTurnCompleteness(Turn turn, boolean isComplete) {
		this.turnTable.specifyTurnCompleteness(turn, isComplete);
	}

	public TurnTable getTurnTable() {
		return turnTable;
	}

}
