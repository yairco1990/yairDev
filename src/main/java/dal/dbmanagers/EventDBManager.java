package dal.dbmanagers;

import dal.models.EventEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by Yair on 07/09/2015.
 */
public class EventDBManager extends DBManager{

    public EventDBManager(){
        super();
    }

    /**
     * @return all the events
     */
    public List<EventEntity> getAllEvents() {
        openSession();

        Criteria criteria = session.createCriteria(EventEntity.class);
//                .createAlias("favoritesById", "favorite");
//        criteria.add(Restrictions.eq("favorite.userId", userId));

        List<EventEntity> events = criteria.list();

        closeSession();

        return events;
    }

}
