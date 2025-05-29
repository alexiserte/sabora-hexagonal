package com.sabora.application.ports.driving;

import com.sabora.server.DTOs.FormDTO;
import com.sabora.server.Entities.Form;

public interface FormServices {
    public FormDTO createFormDTO(Form form);
    public void saveForm(FormDTO formDTO);
    public Form getFormById(int id);
    public void deleteForm(int id);
}
