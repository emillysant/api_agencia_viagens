package com.agencia.viagem.validators;

import com.agencia.viagem.dtos.ViagensRecordDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, ViagensRecordDto> {

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(ViagensRecordDto dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }
        return dto.dataInicio().isBefore(dto.dataFim());
    }
}
