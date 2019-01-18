package com.springmvc.SpringMVCExample.service;

import java.util.List;

import com.springmvc.SpringMVCExample.model.BlogPost;
import com.springmvc.SpringMVCExample.model.Login;
import com.springmvc.SpringMVCExample.model.User;

public interface UserService {

	void register(User user);

	List<BlogPost> validateUser(Login login);

}
