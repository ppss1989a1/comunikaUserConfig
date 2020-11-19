package br.com.assertiva.comunika.configurations.domain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class DataSerializador extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
		
		jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));	
		
	}
	

}
