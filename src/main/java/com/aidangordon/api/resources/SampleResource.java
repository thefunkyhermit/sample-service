package com.aidangordon.api.resources;

import com.aidangordon.api.bean.SampleResult;
import com.aidangordon.api.bean.User;
import com.yammer.dropwizard.auth.Auth;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {



    @GET
    @Timed
    public Response doSampleCall(@Auth User user, @QueryParam("testParam")String testParam){
        SampleResult sampleResult = new SampleResult(testParam, "result");
        return Response.ok(sampleResult).build();
    }
}
