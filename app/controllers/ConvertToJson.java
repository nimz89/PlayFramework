package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Hotel;
import play.mvc.Result;
import views.html.showjson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static play.mvc.Results.ok;

/**
 * Created by nikhan on 12/10/15.
 */
public class ConvertToJson {
    public static Result convertPOJOToJson() throws FileNotFoundException,IOException {
        Hotel hotel=null;
        ArrayList<String> resultJsonList = new ArrayList<String>();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        hotel= new Hotel(1,"Courtyard by Marriott Montreal Downtown","Merchant");
        resultJsonList.add(ow.writeValueAsString(hotel));
        hotel= new Hotel(2,"Hotel Le Crystal Montreal","Agency");
        resultJsonList.add(ow.writeValueAsString(hotel));
        hotel= new Hotel(3,"Best Western Ville-Marie Hotel & Suites","Merchant");
        resultJsonList.add(ow.writeValueAsString(hotel));
        hotel= new Hotel(4,"Best Western Plus Montreal Downtown-hotel Europa","Merchant");
        resultJsonList.add(ow.writeValueAsString(hotel));
        hotel= new Hotel(5,"Holiday Inn Express Hotel & Suites Montreal Airport","Agency");
        resultJsonList.add(ow.writeValueAsString(hotel));

        return ok(showjson.render(resultJsonList));

    }

}
