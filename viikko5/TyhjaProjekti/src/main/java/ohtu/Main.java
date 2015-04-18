package ohtu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		String studentNr = "012345678";
		if (args.length > 0) {
			studentNr = args[0];
		}

		String url = "http://ohtustats-2015.herokuapp.com/students/"
				+ studentNr + "/submissions";

		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		client.executeMethod(method);

		InputStream stream = method.getResponseBodyAsStream();

		String bodyText = IOUtils.toString(stream);

		System.out.println("json-muotoinen data:");
		System.out.println(bodyText);

		Gson mapper = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
		Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

		int totalTasks = 0;
		int totalHours = 0;
		System.out.println("opiskelijanumero " + studentNr + ":\n");
		for (Submission submission : subs) {
			totalHours += submission.getHours();
			totalTasks += submission.getTasksDone().length;
			System.out.println("  " + submission);
		}
		System.out.println("\nyhteensä: " + totalTasks + " tehtävää " + totalHours + " tuntia");

	}
}
