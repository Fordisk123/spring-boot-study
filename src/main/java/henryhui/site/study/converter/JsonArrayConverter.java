package henryhui.site.study.converter;

import com.alibaba.fastjson.JSON;
import henryhui.site.study.model.UserRole;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class JsonArrayConverter<T> {

    public String convertToDatabaseColumn(List<T> arrayList) {
        return JSON.toJSONString(arrayList);
    }

    public List<T> convertToEntityAttribute(String s) {
        return JSON.parseArray(s, (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
