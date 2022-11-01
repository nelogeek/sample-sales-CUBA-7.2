package com.company.sales.web.screens.person;

import com.company.sales.entity.Individuals;
import com.company.sales.entity.Legal;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Person;

import javax.inject.Inject;

@UiController("sales_Person.browse")
@UiDescriptor("person-browse.xml")
@LookupComponent("personsTable")
@LoadDataBeforeShow
public class PersonBrowse extends StandardLookup<Person> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<Person> personsTable;

    @Inject
    private Metadata metadata;



    @Subscribe("createBtn.createLegal")
    public void onCreateBtnCreateLegal(Action.ActionPerformedEvent event) {
        Legal legal = metadata.create(Legal.class);
        showCreateEditor(legal);
    }





    private void showCreateEditor(Person person){
        screenBuilders.editor(personsTable)
                .editEntity(person)
                .build()
                .show();
    }

    @Subscribe("createBtn.createIndividuals")
    public void onCreateBtnCreateIndividuals(Action.ActionPerformedEvent event) {
        Individuals individuals = metadata.create(Individuals.class);
        showCreateEditor(individuals);
    }


}