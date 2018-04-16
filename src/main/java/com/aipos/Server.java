package com.aipos;

import com.aipos.models.Student;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    @Path("aipos4lab")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateSubection(@FormParam("student") String param){
        Student student = gson.fromJson(param, Student.class);
    customService.createStudent(student);
    }

    @DELETE
    @Path("{name}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void deleteSubsection(@PathParam("name") String name){
        customService.deletefile(name);
    }


}
