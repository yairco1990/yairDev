package services.event;

import bl.event.EventLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Yair on 07/09/2015.
 */
@Path("/event")
public class EventServices {

    @GET
    @Path("/getallevents")
    public String getMsg() {
        EventLogic eventLogic = new EventLogic();

        String s = eventLogic.getAllEvents();

        return "as";

    }
}
