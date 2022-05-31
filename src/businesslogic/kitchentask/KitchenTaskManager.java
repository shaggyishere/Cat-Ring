package businesslogic.kitchentask;

import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.menu.MenuEventReceiver;
import businesslogic.recipe.Procedure;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;
import businesslogic.user.User;

import java.util.ArrayList;
import java.util.List;

public class KitchenTaskManager {
    private KitchenSheet currentSheet;
    private List<KitchenTaskEventReceiver> eventReceivers;

    public KitchenTaskManager() {
        this.eventReceivers = new ArrayList<>();
    }


    public KitchenSheet createKitchenSheet(String title, EventInfo event, ServiceInfo service) throws UseCaseLogicException {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();

        // come mai non ti piace queta sotto?
        /*if (!user.isChef() ||
                !event.getServices().contains(service) ||
                !user.getAssignedEvents().contains(event) ||
                service.getUsedMenu() == null) {
            throw new UseCaseLogicException();
        }
*/
        KitchenSheet sheet = new KitchenSheet(title, service);
        this.setCurrentSheet(sheet);
        this.notifySheetCreated(sheet);

        return sheet;
    }

    public KitchenSheet chooseKitchenSheet(KitchenSheet sheet, EventInfo event, ServiceInfo service){
        return null;
    }

    public KitchenTask addKitchenTask (Procedure procedure){
        return null;
    }

    public void deleteKitchenTask(KitchenTask task){

    }

    public void restoreOriginalTask(){

    }

    public void moveTask(KitchenTask task, int position){

    }

    public List<Turn> getTurnTable(){
        return null;
    }

    public void assignTask(KitchenTask task){

    }

    public void assignTask(KitchenTask task, Turn turn){

    }

    public void assignTask(KitchenTask task, Cook cook){

    }

    public void assignTaskTiming(KitchenTask task, String timing){

    }

    public void assignTaskQuantity(KitchenTask task, String quantity){

    }

    public void assignTask(KitchenTask task, Turn turn, Cook cook){

    }

    public void assignTaskTiming(KitchenTask task, Turn turn, String timing){

    }

    public void assignTaskQuantity(KitchenTask task, Turn turn, String quantity){

    }

    public void assignTaskTiming(KitchenTask task, Cook cook, String timing){

    }

    public void assignTaskQuantity(KitchenTask task, Cook cook, String quantity){

    }

    public void assignTask(KitchenTask task, String timing, String quantity){

    }

    public void assignTaskTiming(KitchenTask task, Turn turn, Cook cook, String timing){

    }

    public void assignTaskQuantity(KitchenTask task, Turn turn, Cook cook, String quantity){

    }

    public void assignTask(KitchenTask task, Turn turn, String timing, String quantity){

    }

    public void assignTask(KitchenTask task, Cook cook, String timing, String quantity){

    }

    public void assignTask(KitchenTask task, Turn turn, Cook cook, String timing, String quantity){

    }

    public void specifyCompletedTask(KitchenTask task){

    }

    public void specifyTurnCompleteness(Turn turn, boolean isComplete){

    }


    private void notifySheetCreated(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver eventReceiver : eventReceivers) {
            eventReceiver.updateSheetCreated(sheet);
        }
    }

    private void notifyTaskAdded(KitchenSheet sheet, KitchenTask task){

    }

    private void notifyTaskDeleted (KitchenTask task){

    }

    private void notifySheetRestored(KitchenSheet sheet){

    }

    private void notifyTaskPositionChanged(KitchenTask task, int position){

    }

//    private void notifyTaskAssigned (KitchenSheet sheet, KitchenTask task,..){
//
//    }

    private void notifyTaskCompleted(KitchenSheet sheet, KitchenTask task){

    }

    private void notifyTurnCompletenessChanged(Turn turn, boolean isComplete){

    }


    public KitchenSheet getCurrentSheet() {
        return currentSheet;
    }

    // non so se servirà, nel caso alla fine possiamo poi toglierlo
    public List<KitchenTaskEventReceiver> getEventReceivers() {
        return eventReceivers;
    }

    public void setCurrentSheet(KitchenSheet currentSheet) {
        this.currentSheet = currentSheet;
    }

    public void addEventReceiver(KitchenTaskEventReceiver rec) {
        this.eventReceivers.add(rec);
    }

    public void removeEventReceiver(KitchenTaskEventReceiver rec) {
        this.eventReceivers.remove(rec);
    }
}
