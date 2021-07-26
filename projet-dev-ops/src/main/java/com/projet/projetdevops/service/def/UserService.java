package com.projet.projetdevops.service.def;

import java.util.List;
import java.util.Optional;

import com.projet.projetdevops.entity.User;

public interface UserService {

	List<User> getAllUsers();
	Optional<User> findUserById(int id);
	User addUser(String firstName, String lastName, String email, int age, boolean bourse);
	User updateUser(int id ,String firstName, String lastName, String email, int age, boolean bourse);
	void deleteUser(int id);
}
