package henryhui.site.study.core.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AuthProperties {

    @Value("${demo.auth.secret}")
    private String tokenSecret;

    @Value("${demo.auth.expiration}")
    private long expiration;

}
