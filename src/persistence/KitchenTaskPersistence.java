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
		KitchenTask.addTask(sheet, task, sheet.getKitchenTaskPosition(task));
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
	public void updateTasksRearranged(KitchenSheet sheet, KitchenTask task) {
		KitchenSheet.saveTasksOrder(sheet, task);
	}

	@Override
	public void updateTaskAssigned(KitchenTask task) {
		KitchenTask.assignTask(task);
	}

	@Override
	public void updateTaskCompleted(KitchenTask task) {
		KitchenTask.setCompletedTask(task);
	}

	@Override
	public void updateTurnCompleteness(Turn turn, boolean isComplete) {
		Turn.setTurnCompleteness(turn, isComplete);
	}

}
