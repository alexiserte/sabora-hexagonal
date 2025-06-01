package com.sabora.api.mappers;

import com.sabora.api.dtos.FormDTO;
import com.sabora.application.domain.FoodSpecialist;
import com.sabora.application.domain.Form;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {QuestionDTOMapper.class})
public interface FormDTOMapper {

    @Mapping(source = "date", target = "creationDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "foodSpecialist", source = "author.username")
    FormDTO toDTO(Form form);

    @Mapping(target = "author", ignore = true)
    @Mapping(source = "creationDate", target = "date", dateFormat = "yyyy-MM-dd")
    Form mapSimple(FormDTO formDTO);

    default Form toDomain(FormDTO formDTO) {
        if (formDTO == null) {
            return null;
        }
        var form = mapSimple(formDTO);
        form.setAuthor(FoodSpecialist.builder().username(formDTO.getFoodSpecialist()).build());
        return form;
    }
}
