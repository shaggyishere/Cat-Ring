package businesslogic.kitchentask;

import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.menu.MenuItem;
import businesslogic.menu.Section;
import businesslogic.recipe.Procedure;
import businesslogic.recipe.Recipe;
import businesslogic.turn.Turn;
import businesslogic.user.Cook;
import persistence.BatchUpdateHandler;
import persistence.PersistenceManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitchenSheet {
    private String title;
    private List<KitchenTask> kitchenTasks;
    private ServiceInfo kitchenSheetService;

    public KitchenSheet(String title, ServiceInfo service) {
        this.title = title;
        this.kitchenSheetService = service;
        this.kitchenTasks = new ArrayList<>();

        Menu menu = service.getUsedMenu();

        List<Recipe> recipes = menu.getRecipes();

        List<Procedure> procedures = Procedure.retrieveProceduresToPrepare(recipes);

        for (Procedure proc : procedures) {
            KitchenTask task = new KitchenTask(proc);
            kitchenTasks.add(task);
        }
    }


    public KitchenTask addKitchenTask(Procedure procedure){
        return null;
    }

    public void deleteKitchenTask(KitchenTask task){

    }

    public void restoreOriginalTask(){

    }

    public void moveTask(KitchenTask task, int position){

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


    // STATIC METHODS FOR PERSISTENCE
    public static void saveNewSheet(KitchenSheet sheet) {
//        String kitchenSheetInsert = "INSERT INTO catering.Menus (title, owner_id, published) VALUES (?, ?, ?);";
//        int[] result = PersistenceManager.executeBatchUpdate(kitchenSheetInsert, 1, new BatchUpdateHandler() {
//            @Override
//            public void handleBatchItem(PreparedStatement ps, int batchCount) throws SQLException {
//                ps.setString(1, PersistenceManager.escapeString(sheet.title));
//                ps.setInt(2, sheet.owner.getId());
//                ps.setBoolean(3, sheet.published);
//            }
//
//            @Override
//            public void handleGeneratedIds(ResultSet rs, int count) throws SQLException {
//                // should be only one
//                if (count == 0) {
//                    m.id = rs.getInt(1);
//                }
//            }
//        });
//
//        if (result[0] > 0) { // menu effettivamente inserito
//            // salva le features
//            featuresToDB(sheet);
//
//            // salva le sezioni
//            if (sheet.sections.size() > 0) {
//                Section.saveAllNewSections(sheet.id, sheet.sections);
//            }
//
//            // salva le voci libere
//            if (m.freeItems.size() > 0) {
//                MenuItem.saveAllNewItems(sheet.id, 0, sheet.freeItems);
//            }
//            loadedMenus.put(sheet.id, sheet);
//        }
    }




    @Override
    public String toString() {
        return "KitchenSheet{" +
                "title='" + title + '\'' +
                ", kitchenTasks=" + kitchenTasks +
                ", kitchenSheetService=" + kitchenSheetService +
                '}';
    }
}
