package bl.event;

import dal.dbmanagers.EventDBManager;
import dal.models.EventEntity;
import interfaces.services.ServiceResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yair on 07/09/2015.
 */
public class EventLogic {
    ServiceResult result;
    public EventLogic(){
        result = new ServiceResult();
    }

    /**
     * get all the events
     * @return
     */
    public ServiceResult getAllEvents() {
        //create eventDBManager
        EventDBManager eventDBManager = new EventDBManager();

        //get all the events from db
        List<EventEntity> events = eventDBManager.getAllEvents();

        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();

        //set all the events in hashMap
        for (EventEntity eventEntity : events){
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("id", eventEntity.getId());
            hashMap.put("name", eventEntity.getName());
            hashMap.put("image", eventEntity.getImage());
            list.add(hashMap);
        }

        result.setResultWithSuccess(list);

        return result;
    }
}
