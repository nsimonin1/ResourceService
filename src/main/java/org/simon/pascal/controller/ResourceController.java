package org.simon.pascal.controller;

import javax.servlet.http.HttpServletResponse;

import org.simon.pascal.sso.auth.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Controller
public class ResourceController {
	private static final String jwtTokenCookieName = "JWT-TOKEN";

    @RequestMapping("/")
    public String home() {
        return "redirect:/protected-resource";
    }

    @RequestMapping("/protected-resource")
    public String protectedResource() {
        return "protected-resource";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }
}
