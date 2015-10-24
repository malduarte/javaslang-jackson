package javaslang.jackson.datatype;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import javaslang.collection.List;

class JavaslangDeserializers extends Deserializers.Base {

    @Override
    public JsonDeserializer<?> findBeanDeserializer(JavaType type,
                                                    DeserializationConfig config,
                                                    BeanDescription beanDesc) throws JsonMappingException {
        if (List.class.isAssignableFrom(type.getRawClass())) {
            return new ListDeserializer(type);
        }
        return null;
    }
}
