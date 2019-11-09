package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置（spring配置）
 * 相当于xml的替代者
 * @author s
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
public class TestConfig {
}
