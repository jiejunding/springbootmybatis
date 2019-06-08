package com.example.springbootmybatisdemo1.mapper;

import com.example.springbootmybatisdemo1.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	User selectByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated
	 */
	int updateByPrimaryKey(User record);

	List<User> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
	
	/**
	 * 查询用户是记录
	 * @param userName
	 * @param password
	 * @return
	 */
	User selectUser(@Param("userName1") String userName ,@Param("password1") String password);
}