package businesslogic.turn;

import businesslogic.kitchentask.KitchenSheet;

public class Turn {
    private boolean completed;

    public Turn(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleteness(boolean isComplete) {
        this.completed = isComplete;
    }

    // STATIC METHODS FOR PERSISTENCE
    public static void setTurnCompleteness(KitchenSheet sheet, boolean isComplete) {
        // TODO: qui update
    }
}
