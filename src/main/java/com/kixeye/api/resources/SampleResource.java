package com.kixeye.api.resources;

import com.kixeye.api.bean.SampleResult;
import com.kixeye.api.dao.TestDAO;
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
    public Response doSampleCall(@QueryParam("testParam")String testParam){
        SampleResult sampleResult = new SampleResult(testParam, "result");
        return Response.ok(sampleResult).build();
    }
}
