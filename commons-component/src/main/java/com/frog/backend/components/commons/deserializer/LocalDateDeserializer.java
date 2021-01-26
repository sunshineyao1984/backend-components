package com.frog.backend.components.commons.deserializer;

import com.frog.backend.components.commons.util.TimeUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Description LocalDate反序列化器
 * 支持String类型的年月日“yyyy-MM-dd”和Long类型的毫秒数
 *
 * @author yxy
 * @date 2020-10-13
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String time = jsonParser.getText();
        if(time.contains(TimeUtils.STRING_DATE_MARK)){
            return TimeUtils.stringToLocalDate(time,TimeUtils.TimeFormat.SHORT_DATE_PATTERN_LINE);
        }
        return TimeUtils.millisToLocalDate(Long.parseLong(time));
    }
}
