package view;

import com.aipos.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import netscape.javascript.JSObject;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Conroller {
    ClientConfig config;
    javax.ws.rs.client.Client client;
    WebTarget target ;
    Gson gson;
    private String baseURI;

    public Conroller() {
        config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getBaseURI());
        gson = new Gson();
    }

    public List<String> getSections() {
        String response = target.path("rest").
                path("h").
                request().
                accept(MediaType.APPLICATION_JSON).
                get(String.class);
        return gson.fromJson(response, new TypeToken<List<String>>(){}.getType());
    }

    public String  getName(String name) {
        String response = target.path("rest").
                path("h").
                path(name).
                request().
                accept(MediaType.APPLICATION_JSON).
                get(String.class);
        return gson.fromJson(response, new TypeToken<String>(){}.getType());
    }

    public void  addStudent (String name) {
        Form form = new Form();

        form.param("student",gson.toJson(new Student(name)));
        Response response = target.
                path("h").
                path("students").
                request().
                post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/").build();
    }
}


