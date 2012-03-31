package cdl.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import cdl.android.R;
import cdl.android.server.OAuthHelper;

public class AWoUSOActivity extends Activity {
    OAuthHelper helper;
	
    String[] accessToken;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        accessToken = new String[2];
        
        helper = new OAuthHelper("guest", "guest", "my-activity://callback");
      
        String uri = helper.getRequestToken();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
    }
    
    @Override
    public void onResume() {
    	String[] token = getVerifier();
    	
    	if (token != null) {
    		accessToken = helper.getAccessToken(token[1]);
    	}
    }
    
    private String[] getVerifier() {
    	//extract the token if it exists
    	Uri uri = this.getIntent().getData();
    	if (uri == null) {
    		return null;
    	}

    	String token = uri.getQueryParameter("oauth_token");
    	String verifier = uri.getQueryParameter("oauth_verifier");
    	
    	return new String[] { token, verifier };
    }
}