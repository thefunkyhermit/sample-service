package com.aidangordon.api.resources;

import com.aidangordon.api.dao.TestDAO;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/dbSample")
public class DBSampleResource {
    private TestDAO dao;

    public DBSampleResource(TestDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public Response getData(){
       String name =  dao.findNameById(3);
        return Response.ok(name).build();
    }

}
