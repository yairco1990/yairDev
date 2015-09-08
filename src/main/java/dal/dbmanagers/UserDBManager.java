package dal.dbmanagers;

import dal.models.UserEntity;

/**
 * Created by Yair on 08/09/2015.
 */
public class UserDBManager extends DBManager{
    /**
     * default constructor
     */
    public UserDBManager(){
        super();
    }

    /**
     * get user entity by user id
     * @param userId
     * @return
     */
    public UserEntity getUserByUserId(Integer userId) {
        openSession();

        UserEntity user = (UserEntity)session.get(UserEntity.class, userId);

        return user;
    }
}
