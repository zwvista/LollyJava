package com.zwstudio.lolly.hibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.UserSetting;
import com.zwstudio.lolly.services.IUserSettingService;

@Repository
@Transactional
public class UserSettingDao extends BaseDao implements IUserSettingService {
	@SuppressWarnings("unchecked")
	public UserSetting getData() {
		return (UserSetting) getCurrentSession()
			.createSQLQuery("SELECT * FROM VUSERSETTINGS")
			.addEntity(UserSetting.class)
//			.createQuery("from UserSetting")
			.uniqueResult();
	}
}
