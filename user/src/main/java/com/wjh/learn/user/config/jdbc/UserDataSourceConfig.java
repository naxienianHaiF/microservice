package com.wjh.learn.user.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author WJH
 */
@Component
@Configuration
@ConfigurationProperties(prefix = UserDataSourceConfig.PREFIX)
@MapperScan(basePackages = UserDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDataSourceConfig {
    /**
     * mybatis扫描包路径
     */
    public static final String PACKAGE = "com.wjh.learn.user.mapper";
    /**
     * 配置文件属性前缀
     */
    public static final String PREFIX = "spring.datasource.user";

    private static final String MAPPER_LOCATION = "classpath:mybatis/user/*.xml";
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Primary
    @Bean(name = "userDataSource")
    public DataSource getUserDataSource() {
        DruidDataSource druid = new DruidDataSource();
        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);
        return druid;
    }

    @Primary
    @Bean(name = "userDataSourceTransactionManager")
    public DataSourceTransactionManager userDataSourceTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(getUserDataSource());
    }

    @Primary
    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(UserDataSourceConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

//    @Primary
//    @Bean
//    public SqlSessionTemplate getUserSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
