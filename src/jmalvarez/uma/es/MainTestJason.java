package jmalvarez.uma.es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainTestJason {

	//		private static String appURL = "http://localhost:5000";
	private static String appURL = "http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com";

	public static void main(String[] args) throws JSONException {
		URL url = null;
		try {
			url = new URL(appURL + "/fullcontent");

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				StringBuilder completeResponse = new StringBuilder();
				for (String line; (line = reader.readLine()) != null;) {
					completeResponse.append(line);
				}
				System.out.println(completeResponse);
				JSONObject obj = new JSONObject (new String(completeResponse));
				JSONArray users = obj.getJSONArray("users");
				System.out.println("Usuarios: ");
				for (int i = 0; i < users.length();i++) {
					JSONObject aUser = users.getJSONObject(i);
					System.out.println(aUser.getString("userEmail") + " " +
							aUser.getString("passwd")  + " " +
							aUser.getString("nombre")  + " " +
							aUser.getString("primerApellido")  + " " +
							aUser.getString("segundoApellido")  + " " +
			                   aUser.getString("categoryName"));
				}
				JSONArray courses = obj.getJSONArray("courses");
				System.out.println("Asignaturas: ");
				for (int i = 0; i < courses.length();i++) {
					JSONObject aCourse = courses.getJSONObject(i);
					System.out.println(aCourse.getString("name"));
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ArrayList<String> urltests = new ArrayList<>();
			urltests.add(appURL + "/getuser/alvaroramos@uma.es/luna");
			urltests.add(appURL + "/getuser/jmalveroc@uma.es/223322");
			urltests.add(appURL + "/getuser/jmalveroc@uma.es/111111");
			urltests.add(appURL + "/getuser/alvaroramos@uma.es/585");

			for (String u: urltests) {
				System.out.println("URL: " + u);
				url = new URL(u);

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
					StringBuilder completeResponse = new StringBuilder();
					for (String line; (line = reader.readLine()) != null;) {
						completeResponse.append(line);
					}
					informacionUsuario(new String(completeResponse));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void informacionUsuario(String userInfoFromURL) throws JSONException {
		JSONObject obj = new JSONObject(new String(userInfoFromURL));
		System.out.println(obj.toString());
		String userSituation = obj.getString("situation");
		if (userSituation.equals("ABSENT")) {
			System.out.println(userSituation);			
		} else if (userSituation.equals("PRESENT")) {
			String userCategory = obj.getString("categoryName");
			if (userCategory.equals("Estudiante") || userCategory.equals("PDI")) {
				System.out.println(obj.getString("userEmail"));
				System.out.println(obj.getString("nombre"));				
				System.out.println(obj.getString("primerApellido"));				
				System.out.println(obj.getString("segundoApellido"));				
				System.out.println(obj.getString("categoryName"));				
				JSONArray usercourses = obj.getJSONArray("courses");
				System.out.print("2121313courses: ");
				for (int i = 0; i < usercourses.length();i++) {
					System.out.print(usercourses.getJSONObject(i).getString("name") + ", ");
				}
				System.out.println("");
			} else if (userCategory.equals("PAS")) {

			} else if (userCategory.equals("ONG")) {

			}else {
				System.err.println("No deberíamos estar aquí.");
			} 
		} else {
			System.err.println("Tampoco deberíamos estar aquí.");
		}
	}
}

