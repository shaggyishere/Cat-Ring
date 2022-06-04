package businesslogic.event;

import businesslogic.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class EventInfo implements EventItemInfo {
    private int id;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private int participants;
    private User organizer;

    private ObservableList<ServiceInfo> services;

    public EventInfo() {
    }

    public EventInfo(String name) {
        this.name = name;
        id = 0;
    }

    public ObservableList<ServiceInfo> getServices() {
        return FXCollections.unmodifiableObservableList(this.services);
    }

    //TODO: maybe to delete
    public List<ServiceInfo> getServiceInfos() {
        return services.stream().toList();
    }

    public String toString() {
        return name + ": " + dateStart + "-" + dateEnd + ", " + participants + " pp. (" + organizer.getUserName() + ")";
    }

    // STATIC METHODS FOR PERSISTENCE

    public static ObservableList<EventInfo> loadAllEventInfo() {
        ObservableList<EventInfo> all = FXCollections.observableArrayList();
        String query = "SELECT * FROM Events WHERE true";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                String n = rs.getString("name");
                EventInfo e = new EventInfo(n);
                e.id = rs.getInt("id");
                e.dateStart = rs.getDate("date_start");
                e.dateEnd = rs.getDate("date_end");
                e.participants = rs.getInt("expected_participants");
                int org = rs.getInt("organizer_id");
                e.organizer = User.loadUserById(org);
                all.add(e);
            }
        });

        for (EventInfo e : all) {
            e.services.addAll(ServiceInfo.loadServiceInfoForEvent(e.id));
        }
        return all;
    }

    public static EventInfo getEventByName(String name) {
        EventInfo e = new EventInfo();
        String query = String.format("SELECT * FROM Events WHERE name = '%s'", name);
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                String n = rs.getString("name");
                e.name = n;
                e.id = rs.getInt("id");
                e.dateStart = rs.getDate("date_start");
                e.dateEnd = rs.getDate("date_end");
                e.participants = rs.getInt("expected_participants");
                int org = rs.getInt("organizer_id");
                e.organizer = User.loadUserById(org);
            }
        });

        e.services = ServiceInfo.loadServiceInfoForEvent(e.id);

        return e;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventInfo)) return false;
        EventInfo eventInfo = (EventInfo) o;
        return id == eventInfo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
