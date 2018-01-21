package pl.webcommerce.components;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.ecommerce.system.InMemoryUserContext;
import pl.ecommerce.system.UserContext;

@Component
public class SystemComponents {

    @Bean
    public UserContext userContext() {
        UserContext userContext = new InMemoryUserContext();
        userContext.authorize("new_user");

        return userContext;
    }

}
