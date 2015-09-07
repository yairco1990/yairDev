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
     * @return favorite branches of the user
     */
    public List<EventEntity> getAllEvents() {
        openSession();

        Criteria criteria = session.createCriteria(EventEntity.class);
//                .createAlias("favoritesById", "favorite");
//        criteria.add(Restrictions.eq("favorite.userId", userId));

        List<EventEntity> branches = criteria.list();

        closeSession();

        return branches;
    }
}
