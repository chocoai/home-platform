package com.home.system.server.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 封装查询条件
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-23 10:07
 **/
public class BaseSpecification<T> {
    /**
     * 封装查询条件 -- 基础条件【删除标志==0、排序方式==创建时间降序排列】
     *
     * @param <T> T
     * @return Specification<T>
     */
    public static <T> Specification<T> getRestriction() {
        return (r, q, cb) -> {
            // 存放多个条件
            List<Predicate> predicateList = new ArrayList<>();

            // 删除标志
            predicateList.add(cb.equal(r.get("deleteFlag").as(Boolean.class), Boolean.FALSE));

            // 排序条件
            List<Order> orderList = new ArrayList<>();
            // 按“创建时间”进行降序排列
            orderList.add(cb.asc(r.get("createTime").as(Date.class)));
            return q.where(predicateList.toArray(new Predicate[predicateList.size()])).orderBy(orderList).getRestriction();
        };
    }

}
