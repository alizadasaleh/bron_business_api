//package az.bron.business.config;
//
//import az.bron.business.feature.contact.domain.model.Schedule;
//import az.bron.business.feature.contact.infrastructure.persistence.ScheduleTypeHandler;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.TypeHandlerRegistry;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = {"az.bron.business.feature.**.infrastructure.persistence"}, sqlSessionTemplateRef = "postgresSessionTemplate")
//public class DataSourceConfiguration {
//
//    @Bean(name = "postgresDataSourceProperties")
//    @Primary
//    @ConfigurationProperties("app.datasource.postgres")
//    public DataSourceProperties postgresDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "postgresDataSource")
//    @Primary
//    @ConfigurationProperties("app.datasource.postgres.configuration")
//    public DataSource postgresDataSource() {
//        return postgresDataSourceProperties().initializeDataSourceBuilder()
//                .type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "postgresSessionFactory")
//    @Primary
//    public SqlSessionFactory postgresSessionFactory(@Qualifier("postgresDataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        SqlSessionFactory sessionFactory = sessionFactoryBean.getObject();
//
//        TypeHandlerRegistry typeHandlerRegistry = sessionFactory.getConfiguration().getTypeHandlerRegistry();
//        typeHandlerRegistry.register(Schedule.class, JdbcType.OTHER, ScheduleTypeHandler.class);
//        return sessionFactory;
//    }
//
//    @Bean(name = "postgresTransactionManager")
//    @Primary
//    public DataSourceTransactionManager postgresTransactionManager(@Qualifier("postgresDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "postgresSessionTemplate")
//    @Primary
//    public SqlSessionTemplate postgresSessionTemplate(@Qualifier("postgresSessionFactory") SqlSessionFactory sqlSessionFactory)
//            throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
