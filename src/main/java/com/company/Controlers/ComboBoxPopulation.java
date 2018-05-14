package com.company.Controlers;

import com.company.Services.Service;
import com.company.Services.ServiceRepository;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.Map;

public class ComboBoxPopulation {
    private Map<String, String> prices = new HashMap<>();
    private Map<String, String> duration = new HashMap<>();

    public void comboBoxFill(ComboBox categoryComboBox, ComboBox serviceComboBox, ServiceRepository serviceRepository){
        if (categoryComboBox.getValue().equals("Manicure")) {
            serviceComboBox.getItems().clear();
            for (int i = 0; i < serviceRepository.manicure().size(); i++) {
                Service service = serviceRepository.manicure().get(i);
                serviceComboBox.getItems().add(service.getName());
//                prices.put(service.getName(), service.getPrice().toString());
//                duration.put(service.getName(), service.getDuration().toString());
            }
        } else if (categoryComboBox.getValue().equals("Pedicure")) {
            serviceComboBox.getItems().clear();
            for (int i = 0; i < serviceRepository.pedicure().size(); i++) {
                Service service = serviceRepository.pedicure().get(i);
                serviceComboBox.getItems().add(service.getName());
//                prices.put(service.getName(), service.getPrice().toString());
//                duration.put(service.getName(), service.getDuration().toString());
            }
        } else if (categoryComboBox.getValue().equals("Lashes")) {
            serviceComboBox.getItems().clear();
            for (int i = 0; i < serviceRepository.brwi().size(); i++) {
                Service service = serviceRepository.brwi().get(i);
                serviceComboBox.getItems().add(service.getName());
//                prices.put(service.getName(), service.getPrice().toString());
//                duration.put(service.getName(), service.getDuration().toString());
            }
        }
    }
}
