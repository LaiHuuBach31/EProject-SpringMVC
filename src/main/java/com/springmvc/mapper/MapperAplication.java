package com.springmvc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperAplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
