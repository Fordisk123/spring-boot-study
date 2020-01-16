package henryhui.site.study.data.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class JsonArrayConverter<T> {
    private static ObjectMapper MAPPER = new ObjectMapper();

    public String convertToDatabaseColumn(List<T> arrayList) {
        try{
            return MAPPER.writeValueAsString(arrayList);
        }catch (Exception e){
            return "[]";
        }
    }

    public List<T> convertToEntityAttribute(String s) {
        try{
            JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
            return MAPPER.readValue(s , jt);
        }catch (Exception e){
            return new ArrayList();
        }
    }
}
