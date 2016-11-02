package by.tr.totalizator.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {
	
	private final static DBResourceManager instance = new DBResourceManager();
	private final static String BUNDLE = "by.tr.totalizator.connectionpool.bd";
	
	private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE);
	
	public static DBResourceManager getInstance(){
		return instance;
	}
	
	public String getValue(String key){
		return bundle.getString(key);
	}
}
