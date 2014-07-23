package com.st.icliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.st.icliente.dto.ShareInfoDto;
import com.st.icliente.service.ISShare;

@Service
@Qualifier("shareService")
public class ShareService implements ISShare {

	@Override
	public List<ShareInfoDto> loadShares() {
		List<ShareInfoDto> shareList = new ArrayList<>();
		shareList.add(new ShareInfoDto("Enagas", "ENA", 23.34D));
		shareList.add(new ShareInfoDto("Banco Santander", "SAN", 7.65D));
		shareList.add(new ShareInfoDto("Mapfre", "MAP", 2.87D));
		shareList.add(new ShareInfoDto("Repsol", "REP", 19.08D));
		shareList.add(new ShareInfoDto("Indra", "INR", 12.89D));
		return shareList;
	}
}
