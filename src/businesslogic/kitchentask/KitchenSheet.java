package businesslogic.kitchentask;

import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.menu.MenuItem;
import businesslogic.procedure.Procedure;
import businesslogic.procedure.Recipe;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;

import java.util.ArrayList;
import java.util.List;

public class KitchenSheet {
	private String title;
	private List<KitchenTask> kitchenTasks;
	private ServiceInfo kitchenSheetService;

	public KitchenSheet(String title, ServiceInfo service) {
		this.title = title;
		this.kitchenSheetService = service;
		this.kitchenTasks = new ArrayList<>();

		Menu menu = service.getUsedMenu();
		List<Recipe> recipes = menu.getRecipes();
		List<Procedure> procedures = Procedure.retrieveProceduresToPrepare(recipes);

		for (Procedure proc : procedures) {
			KitchenTask task = new KitchenTask(proc);
			kitchenTasks.add(task);
		}
	}


	public KitchenTask addKitchenTask(Procedure procedure){
		KitchenTask task = new KitchenTask(procedure);
		this.kitchenTasks.add(task);
		procedure.addAssignedTask(task); //fixme: forse andrebbe tolto/modificato sempre per il discorso di responsabilità
		return task;
	}

	public void deleteKitchenTask(KitchenTask task){
		this.kitchenTasks.remove(task);
		task.getProcedure().removeAssignedTask(task);
	}

	public void restoreOriginalTask(){
		this.kitchenTasks.clear();
		Menu menu = this.kitchenSheetService.getUsedMenu();
		List<Recipe> recipes = menu.getRecipes();
		List<Procedure> procedures = Procedure.retrieveProceduresToPrepare(recipes);

		for (Procedure proc : procedures) {
			KitchenTask task = new KitchenTask(proc);
			kitchenTasks.add(task);
		}
	}

	public void moveTask(KitchenTask task, int position){
		kitchenTasks.remove(task);
		kitchenTasks.add(position, task);
	}

	public void assignTask(KitchenTask task, Turn turn, Cook cook, String timing, String quantity){
		task.assign(task, turn, cook, timing, quantity);
	}

	public void specifyCompletedTask(KitchenTask task){
		task.setCompletedTask();
	}


	// STATIC METHODS FOR PERSISTENCE
	public static void saveNewSheet(KitchenSheet sheet) {
		//TODO
	}

	public static void restoreSheet(KitchenSheet sheet) {
		//TODO
	}

	public static void saveTasksOrder(KitchenSheet sheet) {
		//TODO
	}


	public List<KitchenTask> getKitchenTasks() {
		return kitchenTasks;
	}

	@Override
	public String toString() {
		return "KitchenSheet{" +
				"title='" + title + '\'' +
				", kitchenTasks=" + kitchenTasks +
				", \nkitchenSheetService=" + kitchenSheetService +
				'}';
	}
}
