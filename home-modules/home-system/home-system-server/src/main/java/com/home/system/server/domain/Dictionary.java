package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 字典信息 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_dictionary")
public class Dictionary {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 父节点ID
     */
	private Long parentId;

    /**
     * 字典名称
     */
	private String dictionaryName;

    /**
     * 字典值
     */
	private String dictionaryValue;

    /**
     * 字典描述
     */
	private String remark;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date updateTime;

    /**
     * 删除标志 1-未删，2-删除
     */
	private Boolean deleteFlag;
}