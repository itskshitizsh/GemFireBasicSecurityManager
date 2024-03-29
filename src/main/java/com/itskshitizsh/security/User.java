package com.itskshitizsh.security;

import java.io.Serializable;
import java.util.List;

import org.apache.geode.security.ResourcePermission;


public class User implements Serializable {

	List<ResourcePermission> userPermissions;
	String userName;
	String userPassword;

	public User(String userName, String userPassword, List<ResourcePermission> userPermissions) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPermissions = userPermissions;
	}

	public String getUserPassword() {
		return userPassword;
	}

	@Override
	public String toString() {
		return userName;
	}

	public List<ResourcePermission> getPermissions() {
		return this.userPermissions;
	}

	public boolean hasPermission(ResourcePermission resourcePermissionRequested) {
		boolean hasPermission = false;

		for (ResourcePermission userPermission : userPermissions) {
			if (userPermission.implies(resourcePermissionRequested)) {
				hasPermission = true;
				break;
			}
		}
		return hasPermission;
	}
}