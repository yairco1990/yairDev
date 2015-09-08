package services.picture;

import bl.picture.PictureLogic;
import interfaces.services.ServiceResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yair on 09/09/2015.
 */
@Path("/picture")
@Produces(MediaType.APPLICATION_JSON)
public class PictureServices {

    @GET
    @Path("/getPictureForEvent")
    public ServiceResult setEventForUser(@QueryParam("eventId")Integer eventId) {
        PictureLogic pictureLogic = new PictureLogic();

        return pictureLogic.getPicturesForEvent(eventId);
    }
}
