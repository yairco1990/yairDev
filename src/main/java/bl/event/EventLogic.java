package bl.event;

import dal.dbmanagers.EventDBManager;
import dal.models.EventEntity;

import java.util.List;

/**
 * Created by Yair on 07/09/2015.
 */
public class EventLogic {

    public EventLogic(){

    }

    public static String getAllEvents() {
        EventDBManager eventDBManager = new EventDBManager();

        List<EventEntity> events = eventDBManager.getAllEvents();

        String s = "";

        for (EventEntity eventEntity : events){
            s = s + eventEntity.getId() + " " + eventEntity.getName();
        }

        return s;
    }
}
