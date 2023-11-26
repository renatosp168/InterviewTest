package controllers;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import service.LabSeqService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.math.BigInteger;
@Path("/labseq")
public class LabSeqController {
    LabSeqService labSeqService;
    public LabSeqController()
    {
        labSeqService = new LabSeqService();
    }

    @GET
    @Path("{pos:.*}")
    @Produces("text/plain")
    @Operation(
            summary = "gets the value of the n-th of the sequence",
            description =  "Given a numeric non-decimal positive value the endpoint will return the value according to the sequence."
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200", description = "Ok!"),
            @APIResponse(responseCode = "400", description = "Invalid value supplied!"),
            @APIResponse(responseCode = "500", description = "Internal server error!")
        }
    )
    public Response getSequenceValue(@DefaultValue("0") @PathParam("pos") int pos ) {
        BigInteger result = labSeqService.calculateSequence(pos);
        if(result.intValue() == -1) {
            return Response.status(400).entity("Error!Invalid value: {" + pos + "}. Must be bigger than 0.").build();
        }
        return Response.ok(result.toString()).build();
    }
}
