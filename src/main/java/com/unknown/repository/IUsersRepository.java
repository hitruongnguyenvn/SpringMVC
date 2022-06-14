package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.UsersEntity;

public interface IUsersRepository extends JpaRepository<UsersEntity, Integer> {
	UsersEntity findOneByUserNameAndStatus(String userName, int status);
}
