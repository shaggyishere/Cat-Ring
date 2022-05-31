package businesslogic.kitchentask;

import businesslogic.recipe.Procedure;
import businesslogic.turn.Turn;

public interface KitchenTaskEventReceiver {
    void updateSheetCreated(KitchenSheet sheet);

    void updateTaskAdded(Procedure proc);

    void updateTaskDeleted(KitchenTask task);

    void updateSheetRestored(KitchenSheet sheet);

    void updateTaskPositionChanged(KitchenTask task, int position);

    // sono necessari tutti quei parametri che sono nel DCD?
    // void updateTaskAssigned(KitchenSheet sheet, KitchenTask task,...);

    void updateTaskCompleted(KitchenSheet sheet, KitchenTask task);

    void updateTurnCompleteness (Turn turn, boolean isComplete);
}
