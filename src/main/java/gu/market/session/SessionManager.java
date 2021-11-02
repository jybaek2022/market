package gu.market.session;

import javax.servlet.http.HttpSession;

public class SessionManager {
	private final String IS_LOGIN = "isLogin";
	private final String NAME = "name";
	private final String ADMIN = "admin";
	private final String ID = "id";
	
    public boolean isLogin(HttpSession session) {
    	Object isLogin = session.getAttribute(IS_LOGIN);
    	if(isLogin != null) {
    		return (boolean) isLogin;
    	}
    	return false;
    }
    
    public void login(HttpSession session, String[] value) {
    	session.setAttribute(IS_LOGIN, true);
    	session.setAttribute(NAME, value[0]);
    	session.setAttribute(ADMIN, value[1]);
    	session.setAttribute(ID, value[2]);
    }
    
    public String getName(HttpSession session) {
    	return (String) session.getAttribute(NAME);
    }
    public String getAdmin(HttpSession session) {
    	return (String) session.getAttribute(ADMIN);
    }
    public String getId(HttpSession session) {
    	return (String) session.getAttribute(ID);
    }
}
