import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Covid19 {

	public static void main(String[] args) throws IOException, ParseException {
		OkHttpClient client=new OkHttpClient();
		Request request=new Request.Builder().url("https://disease.sh/v2/all").get().build();
		
		Response response=client.newCall(request).execute();
		String data = response.body().string();
		JSONParser jsonparser=new JSONParser();
		
		JSONObject jsonobject=(JSONObject)jsonparser.parse(data);
		
		System.out.println("Total cases : "+jsonobject.get("cases"));
		System.out.println("Recovered : "+jsonobject.get("recovered"));
		System.out.println("Today Recovered : "+jsonobject.get("todayRecovered"));
		System.out.println("Active : "+jsonobject.get("active"));
		System.out.println("Today cases : "+jsonobject.get("todayCases"));
		System.out.println("Total critical cases : "+jsonobject.get("critical"));
		System.out.println("Total Deaths : "+jsonobject.get("deaths"));
		System.out.println("Today Deaths : "+jsonobject.get("todayDeaths"));

	}

}
