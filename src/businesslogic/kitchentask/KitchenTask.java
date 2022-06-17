package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.procedure.Procedure;
import businesslogic.turn.Turn;
import businesslogic.user.User;
import persistence.BatchUpdateHandler;
import persistence.PersistenceManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KitchenTask {
	private int id;
	private String timing;
	private String quantity;
	private boolean completed;
	private Procedure procedure;
	private Turn turn;
	private User cook;

	public KitchenTask(Procedure proc) {
		this.id = 0;
		this.timing = "";
		this.quantity = "";
		this.completed = false;
		this.procedure = proc;
		this.turn = null;
		this.cook = null;
	}

	public void assign(Turn turn, User cook, String timing, String quantity) throws BusinessLogicException {
		//do the assignment only if turn is not completed and cook is available for that turn
		if ( ((turn != null && turn.isCompleted()) || (cook != null && !cook.availableFor(turn))) ){
			throw new BusinessLogicException("Parametri assegnamento task non validi");
		}
		else {
			if (turn != null)
				this.turn = turn;
			if (cook != null)
				this.cook = cook;
			if (timing != null)
				this.timing = timing;
			if (quantity != null)
				this.quantity = quantity;
		}
	}

	public int getId() {
		return id;
	}

	public String getTiming() {
		return timing;
	}

	public String getQuantity() {
		return quantity;
	}

	public boolean isCompleted() {
		return completed;
	}

	public Turn getTurn() {
		return turn;
	}

	public User getCook() {
		return cook;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setCompletedTask(){
		this.completed = true;
	}

	public void setId(int id) {
		this.id = id;
	}

	// STATIC METHODS FOR PERSISTENCE
	public static void addTask(KitchenSheet sheet, KitchenTask taskToAdd, int posInKitchenSheet){
		System.out.println(taskToAdd);
		String secInsert = "INSERT INTO catering.KitchenTasks (completed, kitchensheet_id, procedures_id, position) VALUES (" +
				taskToAdd.isCompleted() + ", " +
				sheet.getId() + ", " +
				taskToAdd.getProcedure().getId() + ", " +
				posInKitchenSheet +
				");";
		PersistenceManager.executeUpdate(secInsert);
		taskToAdd.id = PersistenceManager.getLastId();
	}

	public static void deleteTask(KitchenTask task) {
		String taskdel = "DELETE FROM KitchenTasks WHERE id = " + task.id;
		PersistenceManager.executeUpdate(taskdel);
	}

	public static void assignTask(KitchenTask task) {
		String assign = "UPDATE catering.KitchenTasks SET timing = '" + task.timing + "', quantity = '" + task.quantity + "', cook_id = " + (task.cook==null ? null : task.cook.getId()) + ", turn_when = '" + (task.turn==null ? null : task.turn.getWhen()) + "' WHERE id = " + task.id + ";";
		PersistenceManager.executeUpdate(assign);
	}


	public static void setCompletedTask(KitchenTask task) {
		String assign = "UPDATE catering.KitchenTasks SET completed = true WHERE id = " + task.id + ";";
		PersistenceManager.executeUpdate(assign);
	}

	public static void deleteAllTasks(KitchenSheet sheet) {
		String taskdel = "DELETE FROM KitchenTasks WHERE kitchensheet_id = " + sheet.getId();
		PersistenceManager.executeUpdate(taskdel);
	}

	public static void addAllTasks(KitchenSheet sheet) {
		int pos = 0;
		for (KitchenTask task : sheet.getKitchenTasks()) {
			addTask(sheet, task, pos);
			pos++;
		}
	}

	@Override
	public String toString() {
		return "\nKitchenTask{" +
				"timing='" + (timing != null ? timing : "") + '\'' +
				", quantity='" + (quantity != null ? quantity : "") + '\'' +
				", completed=" + completed +
				", procedure=" + procedure +
				", turn=" + (turn != null ? turn.getWhen() : "''") +
				", cook=" + (cook != null ? cook.getUserName() : "''") +
				'}';
	}
}
