package com.kixeye.api.resources

import javax.ws.rs.Path
import javax.ws.rs.GET
import com.yammer.metrics.annotation.Timed
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/groovySample")
@Produces(MediaType.APPLICATION_JSON)
class GroovyResource {
    @GET
    @Timed
    public Map<String, Object> getSampleInGroovy(){
        List<String> strings = ["one", "two", "three"]
        Map<String, Object> map = [anotherkey: "test", listKey: [3, 5]]
        Map<String, Object> returnedMap = [key: "value", keyMap: map, list: strings]
        return returnedMap
    }

}
