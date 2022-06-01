package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.turn.Turn;

public class KitchenTaskPersistence implements KitchenTaskEventReceiver {
	@Override
	public void updateSheetCreated(KitchenSheet sheet) {
		KitchenSheet.saveNewSheet(sheet);
	}

	@Override
	public void updateTaskAdded(KitchenSheet sheet, KitchenTask task) {
		KitchenTask.addTask(sheet, task);
	}

	@Override
	public void updateTaskDeleted(KitchenTask task) {
		KitchenTask.deleteTask(task);
	}

	@Override
	public void updateSheetRestored(KitchenSheet sheet) {
		KitchenSheet.restoreSheet(sheet);
	}

	@Override
	public void updateTasksRearranged(KitchenSheet sheet) {
		KitchenSheet.saveTasksOrder(sheet);
	}

	@Override
	public void updateTaskAssigned(KitchenSheet sheet, KitchenTask task) {
		KitchenTask.assignTask(sheet, task);
	}

	@Override
	public void updateTaskCompleted(KitchenSheet sheet, KitchenTask task) {
		KitchenTask.setCompletedTask(sheet, task);
	}

	@Override
	public void updateTurnCompleteness(KitchenSheet sheet, Turn turn, boolean isComplete) {
		Turn.setTurnCompleteness(sheet, isComplete);
	}

}
