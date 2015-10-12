package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Hotel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Application extends Controller {

   /* public static Result index() {
return ok(index.render("Your new application is ready."));
    }
*/

    public static Result listHotels() throws FileNotFoundException,IOException {

        final String dir = System.getProperty("user.dir");
        File file = new File(dir+"/app/sampleJSONfile");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        StringBuilder jsonContent=new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            jsonContent.append(line);
        }
        fileReader.close();
        ObjectMapper mapper = new ObjectMapper();
        Collection<Hotel> list = mapper.readValue(jsonContent.toString(), new TypeReference<Collection<Hotel>>(){ });
        ArrayList<Hotel> listOfHotels = new ArrayList<Hotel>(list);
        return ok(index.render(listOfHotels));
    }



}
