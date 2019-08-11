package com.sda.gui.ui;

import com.sda.gui.model.Cat;
import com.sda.gui.service.CatApi;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Route("cats")

public class CatsUi extends VerticalLayout {

    private final CatApi catApi;

   private Grid<Cat> catGrid = new Grid<>(Cat.class);
   private CatForm form;


    public CatsUi(CatApi catApi){
        this.catApi = catApi;

        CatForm form = new CatForm(catApi,this);

        catGrid.setColumns("id", "name", "age");
        catGrid.addItemClickListener((event) -> fileForm(event));
        refreshTable();

        HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeFull();
        hl.add(catGrid,form);


       add(hl);

    }

    private void fileForm(ItemClickEvent<Cat> event) {
        form.fill(event.getItem());
    }

    public void refreshTable() {
        catGrid.setItems(catApi.getCats());
    }
}
