package br.com.assertiva.comunika.configurations.domain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class DataDeserializador  extends JsonDeserializer<LocalDateTime>{

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return LocalDateTime.parse(p.readValueAs(String.class), new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm:ss").toFormatter(Locale.ENGLISH));
		
	}

}
