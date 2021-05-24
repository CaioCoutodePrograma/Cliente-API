package infor.api.sp.nrb.documentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import infor.api.sp.nrb.controller.ClienteController;
import io.swagger.jaxrs.Reader;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.util.Json;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("api")
public class DocumentationSwagger {

    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ClienteController.class);
        return  resources;
    }

    private String getJson(Swagger swagger) throws JsonProcessingException{
        String json = new Gson().toJson(getJson(swagger));
        json = json.replaceAll("\\\\","");
        json = json.substring(1,json.length()-1);
        return json;

    }


    @Produces({MediaType.APPLICATION_JSON+"; charset=UTF-8"})
    public Response getJsonSwagger() throws JsonProcessingException, UnknownHostException, NoSuchAlgorithmException, UnsupportedEncodingException{
        Swagger swagger = new Reader(new Swagger()).read(getClasses());
        swagger.setBasePath("/nrb/rest");
        setInfor(swagger);
        return Response.status(200).entity(getJson(swagger)).build();
    }

    private String getJsonSwagger(Swagger swagger) throws JsonProcessingException{
        return Json.mapper().writeValueAsString(swagger);
    }

    private void setInfor(Swagger swagger) {
        Info info = new Info();
        info.setTitle("Documentatiton of a API REST with Java and Swagger");

        StringBuilder descricao = new StringBuilder();
        descricao.append("Use services below to consult, insert and delete informations");

        info.setDescription(descricao.toString());

        swagger.setInfo(info);
    }
}
