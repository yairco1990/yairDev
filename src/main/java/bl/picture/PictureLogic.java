package bl.picture;


import dal.dbmanagers.PictureDBManager;
import dal.models.PictureEntity;
import interfaces.services.ServiceResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yair on 09/09/2015.
 */
public class PictureLogic {
    PictureDBManager pictureDBManager;
    ServiceResult result;

    public PictureLogic(){
        pictureDBManager = new PictureDBManager();
        result = new ServiceResult();
    }

    /**
     * get pictures for the relevant event
     * @param eventId
     * @return
     */
    public ServiceResult getPicturesForEvent(Integer eventId) {
        List<PictureEntity> pictures = pictureDBManager.getPicturesForEvent(eventId);

        ArrayList<HashMap<String,Object>> picturesList = new ArrayList<HashMap<String, Object>>();

        //set all the events in hashMap
        for (PictureEntity picture : pictures){
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("id", picture.getId());
            hashMap.put("uploader", picture.getUserId());
            hashMap.put("image", picture.getUrl());
            picturesList.add(hashMap);
        }

        result.setResultWithSuccess(picturesList);

        return result;
    }
}
