package javaslang.jackson.datatype.deserialize;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import javaslang.Tuple;
import javaslang.collection.List;
import javaslang.collection.Map;

public class JavaslangDeserializers extends Deserializers.Base {

    @Override
    public JsonDeserializer<?> findBeanDeserializer(JavaType type,
                                                    DeserializationConfig config,
                                                    BeanDescription beanDesc) throws JsonMappingException {
        if (Map.class.isAssignableFrom(type.getRawClass())) {
            return new MapDeserializer(type);
        }
        if (Tuple.class.isAssignableFrom(type.getRawClass())) {
            return new TupleDeserializer(type);
        }
        if (List.class.isAssignableFrom(type.getRawClass())) {
            return new ListDeserializer(type);
        }
        return null;
    }
}