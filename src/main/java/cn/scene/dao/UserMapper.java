package cn.scene.dao;

import cn.scene.model.User;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateByIsRade(Integer id);

    //修改用户积分
    int updateJiFenById(@Param("id") Integer id, @Param("number") Integer number);
}