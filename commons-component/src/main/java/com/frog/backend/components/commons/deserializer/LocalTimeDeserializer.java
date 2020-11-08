package com.frog.backend.components.commons.deserializer;

import com.frog.backend.components.commons.util.TimeUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;

/**
 * Description
 *
 * @author yxy
 * @date 2020-10-13
 */
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String time = jsonParser.getText();
        if(time.contains(TimeUtils.STRING_TIME_MARK)){
            return TimeUtils.stringToLocalTime(time,TimeUtils.TimeFormat.TIME_PATTERN);
        }
        return TimeUtils.millisToLocalTime(Long.parseLong(time));
    }
}
