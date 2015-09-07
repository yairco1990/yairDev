package services.general;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/aa")
	public String getMsg() {

		String output = "Jersey say : ";

		return output;

	}

	@GET
	@Path("/bb")
	public String getOtherMsg(@QueryParam("param")String param) {

		String output = "Jersey say : " + param;

		return output;

	}

}