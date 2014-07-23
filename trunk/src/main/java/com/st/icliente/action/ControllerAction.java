package com.st.icliente.action;

import org.springframework.stereotype.Component;

@Component("controllerAction")
public class ControllerAction {

	public String changeVisibility(String part) {
		return "/pages/secure/" + part + "/" + part
				+ ".xthml?faces-redirect=true";
	}

	public String changeVisibilityShares() {
		return "/pages/secure/shares/shares.xhtml?faces-redirect=true";
	}

	public String changeVisibilityRestClient() {
		return "/pages/secure/restClient/restClient.xhtml?faces-redirect=true";
	}

	public String changeVisibilitySoapClient() {
		return "/pages/secure/soapClient/soapClient.xhtml?faces-redirect=true";
	}

	public String changeViewMarkitOnDemand() {
		return "/pages/secure/restClient/markitOnDemand.xhtml?faces-redirect=true";
	}

}
