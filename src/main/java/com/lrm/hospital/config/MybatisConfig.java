package com.lrm.hospital.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author mamingcong
 * @Date 2019-10-21 20:13
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.lrm.hospital.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {
    @Value("${hospital.driverClassName}")
    private String driverClassName;

    @Value("${hospital.url}")
    private String url;

    @Value("${hospital.username}")
    private String userName;

    @Value("${hospital.password}")
    private String password;

    @Value("${hospital.initialSize}")
    private String initialSize;

    @Value("${hospital.minIdle}")
    private String minIdle;

    @Value("${hospital.maxActive}")
    private String maxActive;

    @Value("${hospital.filters}")
    private String filters;

    @Bean
    public DataSource defaultDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", driverClassName);
        props.put("url", url);
        props.put("username", userName);
        props.put("password", password);
        props.put("initialSize",initialSize);
        props.put("minIdle",minIdle);
        props.put("maxActive",maxActive);
        props.put("filters",filters);
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(defaultDataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:maps/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(
                "/mybatis/mybatis.xml"));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper()});
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean
    public DataSourceTransactionManager bossTransactionManager() throws Exception {
        return new DataSourceTransactionManager(defaultDataSource());
    }
}
