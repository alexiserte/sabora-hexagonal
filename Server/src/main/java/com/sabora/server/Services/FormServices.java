package com.sabora.server.Services;

import com.sabora.server.DTOs.FormDTO;
import com.sabora.server.Models.Form;

import java.util.Optional;

public interface FormServices {
    public FormDTO createFormDTO(Form form);
    public void saveForm(FormDTO formDTO);
    public Form getFormById(int id);
    public void deleteForm(int id);
}
