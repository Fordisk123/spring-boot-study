package henryhui.site.study.data.converter;

import com.alibaba.fastjson.JSON;

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
