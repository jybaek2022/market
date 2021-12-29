package gu.market.session;

import javax.servlet.http.HttpSession;

import gu.market.repository.model.Member;

public class SessionManager {
	private final String IS_LOGIN = "isLogin";
	private final String NAME = "name";
	private final String ADMIN = "admin";
	private final String ID = "id";
	
	private final String ACCESS_TOKEN = "accessToken";
	
    public boolean isLogin(HttpSession session) {
    	Object isLogin = session.getAttribute(IS_LOGIN);
    	if(isLogin != null) {
    		return (boolean) isLogin;
    	}
    	return false;
    }
    
    public void login(HttpSession session, Member member) {
    	session.setAttribute(IS_LOGIN, true);
    	session.setAttribute(NAME, member.getMemberName());
    	session.setAttribute(ADMIN, member.getMemberCheck());
    	session.setAttribute(ID, member.getMemberId());
    }
    
    public void setAccessToken(HttpSession session, String accessToken) {
    	session.setAttribute(ACCESS_TOKEN, accessToken);
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
    public String getAccessToken(HttpSession session) {
    	return (String) session.getAttribute(ACCESS_TOKEN);
    }
}
