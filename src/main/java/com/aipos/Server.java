package com.aipos;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/h")
public class Server {

    Gson gson = new Gson();
    CustomService customService = new CustomService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage(){
        return gson.toJson(customService.getFilesName());
    }
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcreateSection(@PathParam("name") String name){
        return gson.toJson(customService.readFile(name));
    }
    @POST
    @Path("students")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateSubection(@FormParam("student") String param){

    customService.createStudent(gson.fromJson(param, Student.class).getName());
    }


}
