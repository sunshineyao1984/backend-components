package com.frog.backend.components.commons.deserializer;

import com.frog.backend.components.commons.util.TimeUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Description
 *
 * @author yxy
 * @date 2020-10-12
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String time = jsonParser.getText();
        if(time.contains(TimeUtils.STRING_MARK)){
            return TimeUtils.stringToLocalDateTime(time,TimeUtils.TimeFormat.LONG_DATE_PATTERN_LINE);
        }
        return TimeUtils.millisToLocalDateTime(Long.parseLong(time));
    }
}
