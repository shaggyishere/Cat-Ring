package businesslogic.kitchentask;

import businesslogic.recipe.Procedure;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;

public class KitchenTask {
    private String timing;
    private String quantity;
    private boolean completed;
    private Procedure procedure;
    private Turn turn;
    private Cook cook;

    public KitchenTask(Procedure proc) {
        this.procedure = proc;
        this.completed = false;
    }

    public void assign(KitchenTask task){

    }

    public void assign(KitchenTask task, Turn turn){

    }

    public void assign(KitchenTask task, Cook cook){

    }

    public void assignTiming(KitchenTask task, String timing){

    }

    public void assignQuantity(KitchenTask task, String quantity){

    }

    public void assign(KitchenTask task, Turn turn, Cook cook){

    }

    public void assignTiming(KitchenTask task, Turn turn, String timing){

    }

    public void assignQuantity(KitchenTask task, Turn turn, String quantity){

    }

    public void assignTiming(KitchenTask task, Cook cook, String timing){

    }

    public void assignQuantity(KitchenTask task, Cook cook, String quantity){

    }

    public void assign(KitchenTask task, String timing, String quantity){

    }

    public void assignTiming(KitchenTask task, Turn turn, Cook cook, String timing){

    }

    public void assignQuantity(KitchenTask task, Turn turn, Cook cook, String quantity){

    }

    public void assign(KitchenTask task, Turn turn, String timing, String quantity){

    }

    public void assign(KitchenTask task, Cook cook, String timing, String quantity){

    }

    public void assign(KitchenTask task, Turn turn, Cook cook, String timing, String quantity){

    }

    public void setCompletedTask(){

    }


    @Override
    public String toString() {
        return "KitchenTask{" +
                "timing='" + timing + '\'' +
                ", quantity='" + quantity + '\'' +
                ", completed=" + completed +
                ", procedure=" + procedure +
                ", turn=" + turn +
                ", cook=" + cook +
                '}';
    }
}
