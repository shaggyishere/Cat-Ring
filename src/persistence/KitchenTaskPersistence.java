package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.recipe.Procedure;
import businesslogic.turn.Turn;

public class KitchenTaskPersistence implements KitchenTaskEventReceiver {
	@Override
	public void updateSheetCreated(KitchenSheet sheet) {

	}

	@Override
	public void updateTaskAdded(Procedure proc) {

	}

	@Override
	public void updateTaskDeleted(KitchenTask task) {

	}

	@Override
	public void updateSheetRestored(KitchenSheet sheet) {

	}

	@Override
	public void updateTaskPositionChanged(KitchenTask task, int position) {

	}

	@Override
	public void updateTaskCompleted(KitchenSheet sheet, KitchenTask task) {

	}

	@Override
	public void updateTurnCompleteness(Turn turn, boolean isComplete) {

	}

}
