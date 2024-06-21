package service;

import java.util.List;

import javax.persistence.Persistence;

import application.HelpException;
import dao.UserDao;
import model.User;

public class UserService {
	private UserDao userDao;

	public UserService() {
		try {
			userDao = new UserDao(Persistence.createEntityManagerFactory("JewelleryStoreApplication"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(User newUser) {
		userDao.create(newUser);
	}

	public void updateUser(User updatedUser) {
		userDao.update(updatedUser);
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

/// for login

	public User findUser(String user, String pass) throws HelpException {
		List<User> users = userDao.find(user);
		if (users.size() == 0) {
			throw new HelpException("Oops! User not found!");
		}
		User u = users.get(0);

		if (!pass.equals(u.getPassword())) {
			throw new HelpException("Oops! Password does not match");
		}
		return u;
	}

	public User addUser(String user, String pass) throws HelpException {
		List<User> users = userDao.find(user);
		if (user == null || user.isEmpty()) {
			throw new HelpException("Oops! Please provide a username!");
		}

		if (!users.isEmpty()) {
			throw new HelpException("Oops! User already exists!");
		}

		User newUser = new User(user, pass);
		userDao.create(newUser);
		return newUser;
	}
}