package bl.user;

import dal.dbmanagers.UserDBManager;
import dal.models.UserEntity;
import interfaces.services.ServiceResult;

/**
 * Created by Yair on 08/09/2015.
 */
public class UserLogic {
    UserDBManager userDBManager;
    ServiceResult result;

    public UserLogic(){
        userDBManager = new UserDBManager();
        result = new ServiceResult();
    }

    /**
     * set event id for user after he get in to some event
     * @param userId
     * @param eventId
     * @return ServiceResult
     */
    public ServiceResult setEventForUser(Integer userId, Integer eventId) {
        //get the relevant user
        UserEntity user = userDBManager.getUserByUserId(userId);

        //set the event id to the user
        user.setEventId(eventId);

        //update the user entity
        userDBManager.updateEntity(user);

        //set as success
        result.setAsSuccess();

        return result;
    }
}
