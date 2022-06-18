package businesslogic.kitchentask;

import businesslogic.turn.Turn;

public interface KitchenTaskEventReceiver {
    void updateSheetCreated(KitchenSheet sheet);

    void updateTaskAdded(KitchenSheet sheet, KitchenTask task);

    void updateTaskDeleted(KitchenTask task);

    void updateSheetRestored(KitchenSheet sheet);

    void updateTasksRearranged(KitchenSheet sheet, KitchenTask task);

     void updateTaskAssigned(KitchenTask task);

    void updateTaskCompleted(KitchenTask task);

    void updateTurnCompleteness (Turn turn, boolean isComplete);
}
