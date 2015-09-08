package services.user;

import bl.event.EventLogic;
import bl.user.UserLogic;
import interfaces.services.ServiceResult;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yair on 07/09/2015.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserServices {

        @POST
        @Path("/setEventForUser")
        public ServiceResult setEventForUser(@FormParam("userId")Integer userId, @FormParam("eventId")Integer eventId) {
            UserLogic userLogic = new UserLogic();

            return userLogic.setEventForUser(userId,eventId);
        }

}
