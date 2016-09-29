package org.simon.pascal.sso.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.WebUtils;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
public class CookieUtil {

	
	public static void create(HttpServletResponse response,String name,String value,Boolean secure,Integer maxAge,String domain){
		Cookie cookie=new Cookie(name, value);
		
		cookie.setSecure(secure);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);		
	}
	
	public static void clear(HttpServletResponse response,String name){
		Cookie cookie=new Cookie(name, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);		
	}
	
	public static String getValue(HttpServletRequest request,String name){
		Cookie cookie=WebUtils.getCookie(request, name);
		return cookie!=null?cookie.getValue():null;
	}
}
