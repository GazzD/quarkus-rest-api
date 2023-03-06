package loca.cyberia.controller

import loca.cyberia.model.Client
import loca.cyberia.service.ClientService
import java.util.Optional
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/clients")
class ClientController {

    @Inject
    lateinit var clientService: ClientService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(@QueryParam("name") name: Optional<String>): Response {
        if(name.isPresent) {
            val client = clientService.findByName(name.get())
                ?: return Response.ok("Client does not exists").status(Response.Status.NOT_FOUND).build();
            return Response.ok(client).build();
        }
        return Response.ok(clientService.findAll()).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: Long): Response {
        val client = clientService.findById(id);

        if(client.isPresent) {
            return Response.ok(client).build();
        }
        return Response.ok("Client does not exists").status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun save(client: Client): Response {
        clientService.store(client);
        return Response.ok(client).status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun update(client: Client): Response {
        clientService.update(client);
        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }


}