package com.wjh.learn.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 第二个数据源的配置
 * @author WJH
 */
@Component
@ConfigurationProperties(prefix = SecondDataSourceConfig.PREFIX)
@MapperScan(basePackages = SecondDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "learnSqlSessionFactory")
public class SecondDataSourceConfig {
    /**
     * mybatis扫描包路径
     */
    public static final String PACKAGE = "com.wjh.learn.second.mapper";
    /**
     * 配置文件属性
     */
    public static final String PREFIX="spring.datasource.second";

    private static final String MAPPER_LOCATION = "classpath:mybatis/second/*.xml";
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Bean(name = "learnDataSource")
    public DataSource getLearnDataSource() {
        DruidDataSource druid = new DruidDataSource();
        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);
        return druid;
    }

    @Bean(name = "learnDataSourceTransactionManager")
    public DataSourceTransactionManager userDataSourceTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(getLearnDataSource());
    }

    @Bean(name = "learnSqlSessionFactory")
    public SqlSessionFactory getLearnSessionFactory(@Qualifier("learnDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }


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
