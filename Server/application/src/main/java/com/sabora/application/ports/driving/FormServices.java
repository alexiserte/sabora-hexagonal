package com.sabora.application.ports.driving;


import com.sabora.application.domain.Form;

import java.util.List;

public interface FormServices {
    Form createFormDTO(Form form);

    void saveForm(Form formDTO);

    Form getFormById(Integer id);

    void deleteForm(Integer id);

    Form getFormByName(String name);

    List<Form> getAllForms();
}
