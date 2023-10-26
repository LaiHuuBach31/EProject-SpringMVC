package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileNotNullValidator implements ConstraintValidator<FileNotNull, MultipartFile> {

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		if(value.getOriginalFilename().isEmpty()) {
			return false;
		}
		return true;
	}

}
