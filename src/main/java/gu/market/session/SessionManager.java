package gu.market.session;

import javax.servlet.http.HttpSession;

public class SessionManager {
	private final String IS_LOGIN = "isLogin";
	private final String NAME = "name";
	
    public boolean isLogin(HttpSession session) {
    	Object isLogin = session.getAttribute(IS_LOGIN);
    	if(isLogin != null) {
    		return (boolean) isLogin;
    	}
    	return false;
    }
    
    public void login(HttpSession session, String name) {
    	session.setAttribute(IS_LOGIN, true);
    	session.setAttribute(NAME, name);
    }
    
    public String getName(HttpSession session) {
    	return (String) session.getAttribute(NAME);
    }
}
