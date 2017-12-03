package com.mall.dao.user;

import com.mall.pojo.user.User;
import com.mall.pojo.user.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(String userSysId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(String userSysId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}