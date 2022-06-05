package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.procedure.Procedure;
import businesslogic.turn.Turn;
import businesslogic.user.User;

public class KitchenTask {
	private String timing;
	private String quantity;
	private boolean completed;
	private Procedure procedure;
	private Turn turn;
	private User cook;

	public KitchenTask(Procedure proc) {
		this.procedure = proc;
		this.completed = false;
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

	public void setCompletedTask(){
		this.completed = true;
	}


	// STATIC METHODS FOR PERSISTENCE
	public static void addTask(KitchenSheet sheet, KitchenTask taskToAdd){
		//TODO: qui insert
	}

	public static void deleteTask(KitchenTask task) {
		//TODO: qui delete
	}

	public static void assignTask(KitchenSheet sheet, KitchenTask task) {
		//TODO: qui update
	}


	public static void setCompletedTask(KitchenSheet sheet, KitchenTask task) {
		//TODO: qui update
	}


	public Procedure getProcedure() {
		return procedure;
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
