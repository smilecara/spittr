package spittr.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;;

@Configuration
public class DataConfig {

	// @Bean
	// public JndiObjectFactoryBean dataSource() {
	// JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
	// jndiObjectFactoryBean.setJndiName("jdbc/spittrDS");
	// jndiObjectFactoryBean.setResourceRef(true);
	// jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
	// return jndiObjectFactoryBean;
	// }

	// @Bean
	// public BasicDataSource dataSource() {
	// BasicDataSource ds = new BasicDataSource();
	// ds.setDriverClassName("org.h2.Driver");
	// ds.setUrl("jdbc:h2:tcp://localhost/~/spittr");
	// ds.setUsername("root");
	// ds.setPassword("123456");
	// ds.setInitialSize(5);
	// ds.setMaxActive(20);
	// return ds;
	// }

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource ds = new DriverManagerDataSource();
	// ds.setDriverClassName("org.h2.Driver");
	// ds.setUrl("jdbc:h2:tcp://localhost/~/spittr");
	// ds.setUsername("root");
	// ds.setPassword("123456");
	// return ds;
	// }

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath: schema.sql")
				.addScript("classpath: test-data.sql").build();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMappingResources(new String[] {"Spittr.hbm.xml"});
		Properties properties = new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		sessionFactoryBean.setHibernateProperties(properties);
		return sessionFactoryBean;
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
