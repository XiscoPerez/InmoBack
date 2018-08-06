package mx.com.realstate.administration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import mx.com.realstate.administration.properties.GradleProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class Application.
 */
@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

    /** The gradle properties. */
    @Autowired
    private GradleProperties gradleProperties;

    /** The name. */
    @Value("${name}")
    private String name;

    /** The regex. */
    @Value("${regex}")
    private String regex;

    /** The title. */
    @Value("${title}")
    private String title;

    /** The description. */
    @Value("${description}")
    private String description;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * News api.
     *
     * @return the docket
     */
    @SuppressWarnings("checkstyle:designforextension")
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(name).apiInfo(apiInfo()).select().paths(regex(regex)).build();
    }

    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).version(gradleProperties.getVersion()).build();
    }
}
