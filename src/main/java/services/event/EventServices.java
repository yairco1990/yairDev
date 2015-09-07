package services.event;

import bl.event.EventLogic;
import interfaces.services.ServiceResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yair on 07/09/2015.
 */
@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class EventServices {

    @GET
    @Path("/getallevents")
    public ServiceResult getAllEvents() {
        EventLogic eventLogic = new EventLogic();

        return eventLogic.getAllEvents();
    }
}
