package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {

}
