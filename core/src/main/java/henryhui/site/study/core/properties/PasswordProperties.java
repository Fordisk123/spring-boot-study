package henryhui.site.study.core.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PasswordProperties {
    @Value("${demo.password.salt.save}")
    String saveSalt;

    @Value("${demo.password.salt.input}")
    String inputSalt;

}
