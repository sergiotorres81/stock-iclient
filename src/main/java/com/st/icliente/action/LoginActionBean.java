package com.st.icliente.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.st.icliente.enums.SpringScope;

@Component("loginAction")
@Scope(SpringScope.REQUEST)
public class LoginActionBean {

	private Logger LOG = LoggerFactory.getLogger(LoginActionBean.class);

	private String userName;
	private String password;

	public String doLogin() {
		LOG.debug("Do login");
		return "success";
	}

	public String doLogin2() {
		LOG.debug("Do login2");
		return "/pages/secure/menu.xthml?faces-redirect=true";

	}

	public String goLoginOut() {
		LOG.debug("do login Out");
		return "/pages/home.xhtml?faces-redirect=true";
	}

	public String goLoginOut2() {
		LOG.debug("do login Out2");
		SecurityContextHolder.clearContext();
		return "/?faces-redirect=true";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
