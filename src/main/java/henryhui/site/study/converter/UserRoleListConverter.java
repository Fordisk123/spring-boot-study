package henryhui.site.study.converter;


import henryhui.site.study.model.UserRole;

import javax.persistence.AttributeConverter;
import java.util.List;

public class UserRoleListConverter extends JsonArrayConverter<UserRole> implements AttributeConverter<List<UserRole>, String> {
}
