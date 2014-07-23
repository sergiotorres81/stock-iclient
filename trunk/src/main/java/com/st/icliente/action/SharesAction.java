package com.st.icliente.action;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.st.icliente.dto.ShareInfoDto;
import com.st.icliente.enums.SpringScope;
import com.st.icliente.service.ISShare;

@Component("sharesAction")
@Scope(SpringScope.REQUEST)
public class SharesAction {

	private Logger LOG = LoggerFactory.getLogger(SharesAction.class);

	@Autowired
	@Qualifier("shareService")
	private ISShare shareService;

	private List<ShareInfoDto> shareList;

	@PostConstruct
	public void init() {
		LOG.debug("Initializing GenericAction");
		shareList = shareService.loadShares();

	}

	public List<ShareInfoDto> getShareList() {
		return shareList;
	}

	public void setShareList(List<ShareInfoDto> shareList) {
		this.shareList = shareList;
	}

}
