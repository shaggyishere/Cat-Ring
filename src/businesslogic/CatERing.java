package businesslogic;

import businesslogic.event.EventManager;
import businesslogic.kitchentask.KitchenTaskManager;
import businesslogic.menu.MenuManager;
import businesslogic.procedure.ProcedureManager;
import businesslogic.turn.TurnManager;
import businesslogic.user.UserManager;
import persistence.KitchenTaskPersistence;
import persistence.MenuPersistence;

public class CatERing {
    private static CatERing singleInstance;

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    private MenuManager menuMgr;
    private ProcedureManager procedureMgr;
    private UserManager userMgr;
    private EventManager eventMgr;
    private KitchenTaskManager ktMgr;
    private TurnManager turnMgr;

    private MenuPersistence menuPersistence;
    private KitchenTaskPersistence kitchenTaskPersistance;

    private CatERing() {
        menuMgr = new MenuManager();
        procedureMgr = new ProcedureManager();
        userMgr = new UserManager();
        eventMgr = new EventManager();
        menuPersistence = new MenuPersistence();
        ktMgr = new KitchenTaskManager();
        kitchenTaskPersistance = new KitchenTaskPersistence();
        turnMgr = new TurnManager();
        menuMgr.addEventReceiver(menuPersistence);
        ktMgr.addEventReceiver(kitchenTaskPersistance);
    }


    public MenuManager getMenuManager() {
        return menuMgr;
    }

    public ProcedureManager getProcedureManager() {
        return procedureMgr;
    }

    public UserManager getUserManager() {
        return userMgr;
    }

    public EventManager getEventManager() { return eventMgr; }

    public KitchenTaskManager getKitchenTaskManager() {
        return ktMgr;
    }

    public TurnManager getTurnMgr() {
        return turnMgr;
    }
}
