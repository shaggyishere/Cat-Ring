package businesslogic.turn;

public class Turn {
    private boolean completed;

    public Turn(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
