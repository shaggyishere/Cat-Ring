package businesslogic.turn;

import businesslogic.kitchentask.KitchenSheet;

import java.util.Objects;

public class Turn {
    private boolean completed;
    private String when;

    public Turn(String when) {
        this.when = when;
    }

    public Turn(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getWhen() {
        return when;
    }

    public void setCompleteness(boolean isComplete) {
        this.completed = isComplete;
    }

    // STATIC METHODS FOR PERSISTENCE
    public static void setTurnCompleteness(KitchenSheet sheet, boolean isComplete) {
        // TODO: qui update
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turn)) return false;
        Turn turn = (Turn) o;
        return Objects.equals(when, turn.when);
    }

    @Override
    public int hashCode() {
        return Objects.hash(when);
    }
}
