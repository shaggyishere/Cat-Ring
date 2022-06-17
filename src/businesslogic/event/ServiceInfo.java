package businesslogic.event;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Objects;

public class ServiceInfo implements EventItemInfo {
    private int id;
    private String name;
    private Date date;
    private Time timeStart;
    private Time timeEnd;
    private int participants;
    private KitchenSheet kitchenSheet;
    private Menu usedMenu;

    public ServiceInfo(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Menu getUsedMenu() {
        return usedMenu;
    }

    /*public String toString() {
        return name + ": " + date + " (" + timeStart + "-" + timeEnd + "), " + participants + " pp.";
    }*/

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", participants=" + participants +
                ", usedMenu=" + usedMenu +
                '}';
    }

    // STATIC METHODS FOR PERSISTENCE

    public static ObservableList<ServiceInfo> loadServiceInfoForEvent(int event_id) {
        ObservableList<ServiceInfo> result = FXCollections.observableArrayList();
        String query = "SELECT id, name, service_date, time_start, time_end, expected_participants, proposed_menu_id " +
                "FROM Services WHERE event_id = " + event_id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                String s = rs.getString("name");
                ServiceInfo serv = new ServiceInfo(s);
                serv.id = rs.getInt("id");
                serv.date = rs.getDate("service_date");
                serv.timeStart = rs.getTime("time_start");
                serv.timeEnd = rs.getTime("time_end");
                serv.participants = rs.getInt("expected_participants");
                serv.usedMenu = Menu.getMenuById(rs.getInt("proposed_menu_id"));
                result.add(serv);
            }
        });

        return result;
    }

    public static ServiceInfo getFirstServiceForEvent(EventInfo event) {
        return loadServiceInfoForEvent(event.getId()).stream().findFirst().get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceInfo)) return false;
        ServiceInfo that = (ServiceInfo) o;
        return id == that.id;
    }
}
