package com.wjh.learn.user.mapper;

import com.wjh.learn.domain.user.User;
import com.wjh.learn.user.mapper.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wjh
 * @date 2019/8/28 21:23
 */
@Mapper
public interface UserMapper {

//    @Insert("insert into user(username,pwd,tellphone,nickname,self_introduction,image,create_time) " +
//            "value(#{username},#{pwd},#{tellphone},#{nickname},#{selfIntroduction},#{image},#{createTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(User user);

//    @Update("update user set pwd = #{pwd}, nickname = #{nickname}, " +
//            "self_introduction = #{selfIntroduction} where id=#{id}")
    int update(User user);

//    @Select({"<script>select * from user <where>" +
//            "<if test=\"username!= null\">and username=#{username}</if>" +
//            "<if test=\"tellphone!= null\">and tellphone=#{tellphone}</if>" +
//            "<if test=\"id!= null\">and id=#{id}</if>" +
//            "</where>" +
//            "</script>"})
    User selectOneUser(User user);

//    @SelectProvider(type = UserProvider.class, method = "selectManyUser")
    List<User> selectManyUser(User user);
}
