package dal.dbmanagers;

import dal.models.PictureEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Yair on 09/09/2015.
 */
public class PictureDBManager extends DBManager {
    public PictureDBManager(){ super();}

    public List<PictureEntity> getPicturesForEvent(Integer eventId) {
        openSession();

        Criteria criteria = session.createCriteria(PictureEntity.class).add(Restrictions.eq("eventId", eventId));

        List<PictureEntity> pictures = criteria.list();

        closeSession();

        return pictures;
    }
}
