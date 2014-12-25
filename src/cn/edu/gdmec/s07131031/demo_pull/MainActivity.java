package cn.edu.gdmec.s07131031.demo_pull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public List<User> parse(InputStream in){
    	List<User> users;
    	User user;
    	String taName=null;
    	try {
			XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
			XmlPullParser parser=factory.newPullParser();
			parser.setInput(in,"UTF-8");
			int eventType=parser.getEventType();
			
			while(eventType != XmlPullParser.END_DOCUMENT){
				switch(eventType){
				case XmlPullParser.START_DOCUMENT:
					users=new ArrayList<User>();
					break;
				case XmlPullParser.START_TAG:
					taName=parser.getName();
					if(taName.equals("user")){
						user=new User();
						user.setId(Integer.parseInt( parser.getAttributeValue(null, "id")));
					}
					if(taName.equals("name")){
						eventType=parser.next();
						user.setName(parser.getText());
						
					}
				}
			}
			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
