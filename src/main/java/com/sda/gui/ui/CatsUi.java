package com.sda.gui.ui;

import com.sda.gui.model.Cat;
import com.sda.gui.service.CatApi;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Route("cats")

public class CatsUi extends VerticalLayout {

    private final CatApi catApi;

   private Grid<Cat> catGrid = new Grid<>(Cat.class);


    public CatsUi(CatApi catApi){
        this.catApi = catApi;

        catGrid.setColumns("id", "name", "age");
       catGrid.setItems(catApi.getCats());
       add(catGrid);



    }

}
