package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.procedure.Procedure;
import businesslogic.procedure.Recipe;
import businesslogic.turn.Turn;
import businesslogic.user.User;
import persistence.PersistenceManager;

import java.util.ArrayList;
import java.util.List;

public class KitchenSheet {
	private int id;
	private String title;
	private List<KitchenTask> kitchenTasks;
	private ServiceInfo kitchenSheetService;

	public KitchenSheet(String title, ServiceInfo service) {
		id = 0;
		this.title = title;
		this.kitchenSheetService = service;
		this.kitchenTasks = new ArrayList<>();

		getTasksFromService(service);
	}

	private void getTasksFromService(ServiceInfo service) {
		Menu menu = service.getUsedMenu();
		List<Recipe> recipes = menu.getRecipes();
		List<Procedure> procedures = Procedure.retrieveProceduresToPrepare(recipes);

		for (Procedure proc : procedures) {
			KitchenTask task = new KitchenTask(proc);
			kitchenTasks.add(task);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public int getKitchenTaskPosition (KitchenTask task){
		return this.kitchenTasks.indexOf(task);
	}

	public KitchenTask addKitchenTask(Procedure procedure){
		KitchenTask task = new KitchenTask(procedure);
		this.kitchenTasks.add(task);
		procedure.addAssignedTask(task); //fixme: forse andrebbe tolto/modificato sempre per il discorso di responsabilità
										 // DUBBIO: potresti avere ragione, ma chi lo deve fare? Qualcuno lo deve pur fare o no?
										 // (cioè mi sembra l'avessimo messo per qualche operazione, ma ora non ricordo)
		return task;
	}

	public void deleteKitchenTask(KitchenTask task){
		this.kitchenTasks.remove(task);
		task.getProcedure().removeAssignedTask(task);
	}

	public void restoreOriginalTask(){
		this.kitchenTasks.clear();
		getTasksFromService(this.kitchenSheetService);
	}

	public void moveTask(KitchenTask task, int position){
		kitchenTasks.remove(task);
		kitchenTasks.add(position, task);
	}

	public void assignTask(KitchenTask task, Turn turn, User cook, String timing, String quantity) throws BusinessLogicException {
		task.assign(turn, cook, timing, quantity);
	}

	public void specifyCompletedTask(KitchenTask task){
		task.setCompletedTask();
	}


	// STATIC METHODS FOR PERSISTENCE

	/**
	 * If there is already a sheet with that service_id the method communicates it to the user
	 * and opens the existing one by setting the correct id (ignoring the title parameter).
	 * Otherwise the method creates a new one; in this case it also creates a kitchenTask for each procedures in service.
	 */
	public static void saveNewSheet(KitchenSheet sheet) {
		String sheetIdFind = "SELECT id FROM catering.KitchenSheets WHERE service_id = " + sheet.kitchenSheetService.getId() + ";";
		PersistenceManager.executeQuery(sheetIdFind, rs -> sheet.id = rs.getInt("id"));
		if (sheet.id == 0) {
			String sheetInsert = "INSERT INTO catering.KitchenSheets (title, service_id) VALUES (" +
					"'" + PersistenceManager.escapeString(sheet.title) + "', " +
					sheet.kitchenSheetService.getId() +
					");";
			PersistenceManager.executeUpdate(sheetInsert);
			sheet.id = PersistenceManager.getLastId();

			for (KitchenTask task: sheet.kitchenTasks)
				KitchenTask.addTask(sheet, task, sheet.getKitchenTaskPosition(task));
		}
		else {
			System.out.println("!!!!!!The KitchenSheet associated with this service already exists, I set it as the currentSheet!!!!!!");
			List<Integer> allTasksId = new ArrayList<>();
			String taskIdFind = "SELECT id FROM catering.KitchenTasks WHERE kitchensheet_id = " + sheet.getId() + ";";
			PersistenceManager.executeQuery(taskIdFind, rs -> {
				int kitchenTaskId = rs.getInt("id");
				allTasksId.add(kitchenTaskId);
			});
//			System.out.println(allTasksId);
//			System.out.println(sheet.kitchenTasks);

			for (int pos = 0; pos < allTasksId.size(); pos++)
				sheet.kitchenTasks.get(pos).setId(allTasksId.get(pos));
		}
	}

	public static void restoreSheet(KitchenSheet sheet) {
		KitchenTask.deleteAllTasks(sheet);
		KitchenTask.addAllTasks(sheet);
	}

	public static void saveTasksOrder(KitchenSheet sheet, KitchenTask task) {
		for (int newPos = 0; newPos < sheet.kitchenTasks.size(); newPos++){
			String changePosition = "UPDATE catering.KitchenTasks SET position = " + newPos + " WHERE id = " + sheet.kitchenTasks.get(newPos).getId();
			PersistenceManager.executeUpdate(changePosition);
		}
	}

	public static int getIdFromTitle(String title) {
		final int[] result = {0};
		String sheetIdFind = "SELECT id FROM catering.KitchenSheets WHERE title = '" + title + "';";
		PersistenceManager.executeQuery(sheetIdFind, rs -> {
			int kitchenTaskId = rs.getInt("id");
			result[0] = kitchenTaskId;
		});
		return result[0];
	}

	public static KitchenSheet loadSheetInfoByTitle(String title, ServiceInfo service) throws BusinessLogicException {
		int idFromTitle = getIdFromTitle(title);
		if(idFromTitle <= 0) {
			throw new BusinessLogicException("Il foglio con titolo: \""+ title+ "\" non esiste");
		}
		KitchenSheet sheet = new KitchenSheet(title, service);
		sheet.id = idFromTitle;
		sheet.kitchenTasks = KitchenTask.loadTasksFor(sheet.id);
		return sheet;
	}

	public List<KitchenTask> getKitchenTasks() {
		return kitchenTasks;
	}

	@Override
	public String toString() {
		return "\n------------------------------------------------------------------------------------------------------\n"
				+ "\""+title +"\"" +  " {"+kitchenTasks +
				", \n" + kitchenSheetService +
				"}\n------------------------------------------------------------------------------------------------------\n";
	}
}
