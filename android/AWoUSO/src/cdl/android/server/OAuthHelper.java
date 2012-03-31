package cdl.android.server;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthException;

public class OAuthHelper {
	private OAuthConsumer mConsumer;
	private OAuthProvider mProvider;
	
	private String mCallbackURL;
	
	public OAuthHelper(String consumerKey, String consumerSecret, String callbackURL) {
		
		mConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
		mProvider = new CommonsHttpOAuthProvider("http://wouso-next.rosedu.org/api/oauth/request_token/",
				"http://wouso-next.rosedu.org/api/oauth/access_token/", 
				"http://wouso-next.rosedu.org/api/oauth/authorize/");
		
		//Using OAuth 1.0a
		mProvider.setOAuth10a(true);
		
		if (callbackURL == null)
			mCallbackURL = OAuth.OUT_OF_BAND;
		else
			mCallbackURL = callbackURL;
	}
	
	public String getRequestToken() {
		String requestToken = null;
		
		try {
			requestToken = mProvider.retrieveRequestToken(mConsumer, mCallbackURL);
		} catch (OAuthException e) {
			e.printStackTrace();
		}
		
		return requestToken;
	}
	
	public String[] getAccessToken(String verifier) {
		try {
			mProvider.retrieveAccessToken(mConsumer, verifier);
		} catch (OAuthException e) {
			e.printStackTrace();
		}
		
		return new String[] {mConsumer.getToken(), mConsumer.getTokenSecret()};
	}
}
