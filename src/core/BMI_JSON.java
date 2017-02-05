package core;
import java.text.DecimalFormat;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
@Path("/json")
public class BMI_JSON {   
	
       @GET
       @Path("/imperial")
       @Produces("application/json")
       public String CalcImperial(
              @DefaultValue("1") @QueryParam("height") int h,     // h in inches   
              @DefaultValue("1") @QueryParam("weight") int w) {   // w in pounds   
              DecimalFormat df = new DecimalFormat("####0.0");
              Double bmi = (double) w / (h * h) * 703;             // w / Math.pow(h, 2) * 703
              String result = df.format(bmi).toString();
/*return "<calc unit=\"imperial\">" + "<height>" + h + "</height>" + "<weight>" + w + "</weight>" + "<bmi>" + result + "</bmi>" + "</calc>";  }*/
              return "{\"calc\": {\"unit\": \"metric\", \"height\": " + h + "\"weight\": " + w + "\"bmi\": " + result + "}}";	}
       
       @GET
       @Path("/metric")
       @Produces("application/json")
       public String CalcMetric(
              @DefaultValue("1") @QueryParam("height") int h,      // h in centimeter
              @DefaultValue("1") @QueryParam("weight") int w) {   // w in kilogram
              DecimalFormat df = new DecimalFormat("####0.0");
              Double bmi = (double) w / (h * h) * 10000;		// w / Math.pow(h, 2) * 10000
              String result = df.format(bmi).toString();
/*return "<calc unit=\"imperial\">" + "<height>" + h + "</height>" + "<weight>" + w + "</weight>" + "<bmi>" + result + "</bmi>" + "</calc>";  } */
              return "{\"calc\": {\"unit\": \"metric\", \"height\": " + h + "\"weight\": " + w + "\"bmi\": " + result + "}}";	}
                                                 }


