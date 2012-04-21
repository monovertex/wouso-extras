package cdl.android.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import cdl.android.model.UserInfo;

public class ApiRequests {
	private final String userInfoAPICallURL = "http://wouso-next.rosedu.org/api/info/?user=alex";
	
	/**
	 * Makes the API call to the server and parses the response into an UserInfo
	 * @return an UserInfo instance
	 */
	public UserInfo getUserInfo() {
		UserInfo user = new UserInfo();
		
		StringBuilder info = new StringBuilder();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(userInfoAPICallURL);
		HttpResponse response = null;
		
		try {
			response = client.execute(request);
			
			int code = response.getStatusLine().getStatusCode();
			System.out.println("code - " + code);
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				InputStream inStream = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(inStream), 8192);
				String line;
				while ((line = br.readLine()) != null) {
					info.append(line + "\n");
				}
			}
		} catch (ClientProtocolException e) {
			System.err.println("Exception: e.getMessage()");
		} catch (IOException e) {
			System.err.println("Exception: e.getMessage()");
		}
		
		return user;
	}
}
