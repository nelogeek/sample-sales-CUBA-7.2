package com.company.sales.web.screens.autoservice;

import com.company.sales.entity.Autoservice;
import com.company.sales.entity.Individuals;
import com.company.sales.entity.Legal;
import com.company.sales.entity.Person;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Session;
import javax.management.*;
import javax.sql.DataSource;
import java.lang.management.ManagementFactory;

@UiController("sales_Autoservice.browse")
@UiDescriptor("autoservice-browse.xml")
@LookupComponent("autoservicesTable")
@LoadDataBeforeShow
public class AutoserviceBrowse extends StandardLookup<Autoservice>{



    @Inject
    private GroupTable<Person> clientsTable;

    private TabSheet tabSheet;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private CollectionContainer<Person> clientsDc;

    @Inject
    private Metadata metadata;
    @Inject
    private CollectionLoader<Autoservice> autoservicesDl;

    @Inject
    private CollectionContainer<Autoservice> autoservicesDc;

    @Inject
    private CollectionLoader<Person> clientsDl;

    @Named("TabTables.Clients")
    private VBoxLayout ClientsTab;

    @Inject
    private Button createBtn;

    private DataSource dataSource;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private Actions actions;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        autoservicesDl.load();
    }



    @Subscribe(id = "autoservicesDc", target = Target.DATA_CONTAINER)
    public void onAutoservicesDcItemChange(InstanceContainer.ItemChangeEvent<Autoservice> event) {
        clientsDl.setParameter("autos", event.getItem());
        clientsDl.load();




        ClientsTab.setCaption("Clients (3)");
    }



    @Subscribe("create.createIndividuals")
    public void onPersonsTableCreateCreateIndividuals(Action.ActionPerformedEvent event) {
        Individuals individuals = metadata.create(Individuals.class);
        showCreateEditor(individuals);
    }

    @Subscribe("create.createLegal")
    public void onPersonsTableCreateCreateLegal(Action.ActionPerformedEvent event) {
        Legal legal = metadata.create(Legal.class);
        showCreateEditor(legal);
    }

    private void showCreateEditor(Person person) {
        screenBuilders.editor(clientsTable)
                .editEntity(person)
                .build()
                .show();
    }



}