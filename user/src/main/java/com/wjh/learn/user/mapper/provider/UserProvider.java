package com.wjh.learn.user.mapper.provider;

import com.wjh.learn.domain.user.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author wjh
 * @date 2019/9/1 11:51
 */
public class UserProvider {

    public String selectManyUser(User user) {
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("user");
            if (user.getId() != null) {
                WHERE("id = #{id}");
            }
            if (user.getUsername() != null) {
                WHERE("username=#{username}");
            }
        }};

        return sql.toString();
    }
}
