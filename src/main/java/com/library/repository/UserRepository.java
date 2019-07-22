package com.library.repository;

import java.util.concurrent.ConcurrentHashMap;

import com.library.model.Student;

public class UserRepository {
		public ConcurrentHashMap<String, Student> userDetailList = new ConcurrentHashMap<>();

		public ConcurrentHashMap<String, Student> getUserDetailList() {
			return userDetailList;
		}

		public void setUserDetailList(ConcurrentHashMap<String, Student> userDetailList) {
			this.userDetailList = userDetailList;
		}
		public Student getUser(String userId){
			return userDetailList.get(userId);
		}
		public void updateUser(String userId,Student student){
			userDetailList.put(userId, student); 
		}
}
