package com.home.developer.server.repository;

import com.home.developer.server.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 开发商
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 9:51:36
*/
public interface DeveloperRepository extends JpaRepository<Developer,Long> {

}