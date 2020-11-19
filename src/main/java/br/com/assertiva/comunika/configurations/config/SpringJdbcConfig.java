package br.com.assertiva.comunika.configurations.config;

	
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;

	import javax.sql.DataSource;

	@Configuration
	public class SpringJdbcConfig {

	    @Value("${spring.datasource.url}")
	    String url;

	    @Value("${spring.datasource.username}")
	    String username;

	    @Value("${spring.datasource.password}")
	    String password;

	    @Value("${spring.datasource.driverClassName}")
	    String className;

	    @Bean
	    public DataSource mysqlDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(className);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);

	        return dataSource;
	    }

	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }


	    @Bean
	    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
	        return new NamedParameterJdbcTemplate(dataSource);
	    }

	}



