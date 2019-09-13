package com.upog.tennis.util;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.upog.tennis.dao.ConnectionDaoImpl;
import com.upog.tennis.repository.ConnectionRepository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.upog.tennis.model.Connection;

@Configuration
public class DataSourceFactory implements BeanFactoryAware {
	
	@Autowired
	private ConnectionDaoImpl connectionDaoImpl;
	
	private static ArrayList<Connection> connectionList =null;
		
	public void loadConnection(){
		if(connectionList==null) {
			connectionList= //new ArrayList<Connection>(); 
					(ArrayList<Connection>) connectionDaoImpl.retrieveAllConnection();
		/*	Connection connection = new Connection(1, "DBTENNIS",
					"jdbc:mysql://tennis.cnx63aff1prh.us-east-1.rds.amazonaws.com:3306/tennis",
					"admin","tennis123"); 
			connectionList.add(connection); */
		}
		
		System.out.println("The connecion list " + connectionList);
		ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
		
		for(Connection connection: connectionList) {
			String beanName= connection.getConnectionName();
			DataSource dataSource = DataSourceBuilder
	                				.create()
	                				.username(connection.getUserName())
	                				.password(connection.getPassword())
	                				.url(connection.getJdbcUrl())
	                				.driverClassName(connection.getDriverName())
	                				.build();
			 // please check the scope of the datasource bean
			System.out.println("");
			
	        configurableBeanFactory.registerSingleton(Constant.SB_DATA_SOURCE+beanName, dataSource);
	        configurableBeanFactory.registerSingleton(Constant.SB_JDBC_TEMPLATE+beanName,  new JdbcTemplate(dataSource));
       
		} 			             
	}
	
	public JdbcTemplate getJdbcTemplatebyName(String connectionName) {
		ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
		JdbcTemplate jdbcTemplate=  (JdbcTemplate) configurableBeanFactory.getBean(Constant.SB_JDBC_TEMPLATE+connectionName);
		return jdbcTemplate;
	}
	
	 private BeanFactory beanFactory;

	    @Override
	    public void setBeanFactory(BeanFactory beanFactory) {
	        this.beanFactory = beanFactory;
	    }

    
	
	@PostConstruct
    public void onPostConstruct() {
      
		
        
     }
	
	
   /* @Bean(name="dsCustom")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("123456")
                .url("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8")
                .driverClassName("oracle.jdbc.OracleDriver")
                .build()
                ; 
    }
    
  
    

    @Bean(name = "jdbcCustom")
    @Autowired
    public JdbcTemplate jdbcTemplate(@Qualifier("dsCustom") DataSource dsCustom) {
        return new JdbcTemplate(dsCustom);
    } */ 
}