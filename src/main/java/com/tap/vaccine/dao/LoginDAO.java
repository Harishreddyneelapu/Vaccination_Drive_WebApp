package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface LoginDAO {
	
	
	RegisterEntity getEntityByEmail(String email);
	boolean updateRegisterEntity(int id,int loginAttempts);
}
