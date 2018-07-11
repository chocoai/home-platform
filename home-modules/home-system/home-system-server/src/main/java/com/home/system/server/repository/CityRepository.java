package com.home.system.server.repository;

import com.home.system.server.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 城市
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface CityRepository extends JpaRepository<City,Long> {

}