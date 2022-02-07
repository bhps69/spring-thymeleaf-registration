package com.example.springbootExample.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootExample.WebSecurityConfig;
import com.example.springbootExample.model.GenderModel;
import com.example.springbootExample.model.UserModel;
import com.example.springbootExample.model.UserModelForm;

@Repository
public class AppUserDAO {
	@Autowired
	private WebSecurityConfig password;
	
	private static final Map<Long,UserModel> userList= new HashMap<Long,UserModel>();
	
	static {
		initData();
	}
	
	public static void initData() {
		
		String encrytedPassword = "";

		UserModel tom = new UserModel(1L, "tom", "Tom", "Tom", 
                true, GenderModel.MALE, "tom@waltdisney.com", encrytedPassword, "US");

		UserModel jerry = new UserModel(2L, "jerry", "Jerry", "Jerry", 
                true, GenderModel.MALE, "jerry@waltdisney.com", encrytedPassword, "US");

        userList.put(tom.getUserId(), tom);
        userList.put(jerry.getUserId(), jerry);
	}
	
	public UserModel findUserByName(String username) {
		Collection<UserModel> coll = userList.values();
		UserModel  u = null;
		for(UserModel col: coll)
		{
			if(col.getUserName().contentEquals(username))
			{
				u = col; 
			}		
		
		}
		return u;	
	}
	
	public UserModel findUserByEmail(String email) {
		Collection<UserModel> coll = userList.values();
		UserModel user = null;
		for(UserModel col: coll) {
			if(col.getEmail().equals(email)) {
				user = col;
			}
		}
		return user;
	}
	public List<UserModel> findAllUsers() {
		return new ArrayList<UserModel>(userList.values());
	}
	public Long getMaxUserId() {
		long max = 0;
		for(Long id : userList.keySet()) {
			if(id>max)
				max = id;
		}
		return max;
	}
	public UserModel createUser(UserModelForm userForm) {
		Long userId = this.getMaxUserId()+1;
		UserModel user = new UserModel(userId, userForm.getUserName(), userForm.getFirstName(), userForm.getLastName(),false, userForm.getGender(), userForm.getEmail(), userForm.getEncrytedPassword(), userForm.getCountryCode());
		userList.put(userId, user);
		return user;
	}
}
