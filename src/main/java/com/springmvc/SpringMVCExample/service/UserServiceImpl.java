package com.springmvc.SpringMVCExample.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.SpringMVCExample.model.BlogPost;
import com.springmvc.SpringMVCExample.model.Login;
import com.springmvc.SpringMVCExample.model.User;

public class UserServiceImpl implements UserService {

	private List<BlogPost> blogs;
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		String sql = "insert into users values(?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword() });
	}

	public List<BlogPost> validateUser(Login login) {
		String sql1 = "select * from User where username='" + login.getUsername() + " and  " + "password="
				+ login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql1, new UserMapper());

		if ((users != null)) {

			String sql = "select Post.title, Post.desc from Post, User where User.uid='" + "' and Post.uid='" + "'";
			List<BlogPost> blogs = jdbcTemplate.query(sql, new BlogMapper());

		}
		return blogs;

	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));

		user.setEmail(rs.getString("email"));

		return user;
	}

}

class BlogMapper implements RowMapper<BlogPost> {
	public BlogPost mapRow(ResultSet rs, int arg1) throws SQLException {
		BlogPost blogPost = new BlogPost();

		blogPost.setDescription(rs.getString("title"));
		blogPost.setTitle(rs.getString("title"));

		return blogPost;
	}

}
