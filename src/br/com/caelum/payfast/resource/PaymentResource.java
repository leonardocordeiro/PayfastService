package br.com.caelum.payfast.resource;

import static br.com.caelum.payfast.utils.PayfastUtils.DOMAIN;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;

import br.com.caelum.payfast.client.WebClient;
import br.com.caelum.payfast.modelo.Payment;

@Path("/payment")
public class PaymentResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.APPLICATION_XML)
	public Response pay(@Context HttpServletRequest request, Payment payment) throws IOException {
		String accessToken = request.getParameter("access_token");
		
		WebClient client = new WebClient(DOMAIN + "/PayfastWebApplication/token/accesstoken/" + accessToken);
		try { 
			HttpResponse response = client.doGet();
			
			if(response.getStatusLine().getStatusCode() == 401)
				return buildUnauthorizedResponse();
			
			return buildOkRespponse(payment);
		} catch(Exception e) { 
			throw new RuntimeException(e);
		}
	}

	private Response buildOkRespponse(Payment payment) {
		return Response.ok().entity(payment).build();
	}

	private Response buildUnauthorizedResponse() {
		return Response.status(HttpServletResponse.SC_UNAUTHORIZED).build();
	}
	
}
