package LikeLion6.weeks1;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class DemoConfig {
    private static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Value("${custom.property.single}")
    private String customProperty;

    @Value("${custom.property.single}")
    private List<String> customCommaList;

    @Value("${custom.property.default:default-property}")
    private String propertyDefault;

    @PostConstruct
    public void init() {
        logger.info("custom property: {}", customProperty);

        for (String commaListItem : customCommaList) {
            logger.info("comma List item: {]", commaListItem);
        }

        logger.info("default property: {]", propertyDefault);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
