package com.sda.gui.ui;

import com.sda.gui.model.Cat;
import com.sda.gui.service.CatApi;
import com.sda.gui.ui.CatsUi;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class CatForm extends FormLayout {

    private Long id;

    private final CatApi catApi;
    private final CatsUi catsUi;
    private TextField name = new TextField("Name");
    private NumberField age = new NumberField("Age");
    private Button save = new Button("Save");
    public CatForm(CatApi catApi, CatsUi catsUi) {
        this.catApi = catApi;
        this.catsUi = catsUi;
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        save.addClickListener((event)->saveCat());
        add(name, age, save);
    }
    private void saveCat() {
        Cat cat = new Cat();
        cat.setName(name.getValue());
        cat.setAge(age.getValue().intValue());
        name.clear();
        catApi.saveCat(cat);
        catsUi.refreshTable();
    }

    public void fill(Cat item) {
        name.setValue(item.getName());
        age.setValue((double)item.getAge());
        id=item.getId();

    }
}