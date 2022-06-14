package com.unknown.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.unknown.util.SecurityUtils;

//@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargerUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargerUrl(Authentication authentication) {
		String url = null;
		String role = SecurityUtils.getAuthority();
		if(isAdmin(role)) {
			url = "/admin/home";
		} else if(isUser(role)) {
			url = "/home";
		}
		return url;
	}

	private boolean isAdmin(String role) {
		if (role.equals("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(String role) {
		if (role.equals("USER")) {
			return true;
		}
		return false;
	}

}
