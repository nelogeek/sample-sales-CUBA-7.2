package com.company.sales.web.screens.autoservice;

import com.company.sales.entity.Individuals;
import com.company.sales.entity.Legal;
import com.company.sales.entity.Person;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Autoservice;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.xml.layout.loaders.TabSheetLoader;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Collection;

@UiController("sales_Autoservice.browse")
@UiDescriptor("autoservice-browse.xml")
@LookupComponent("autoservicesTable")
@LoadDataBeforeShow
public class AutoserviceBrowse extends StandardLookup<Autoservice> {

    @Inject
    private GroupTable<Person> clientsTable;

    private TabSheet tabSheet;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Metadata metadata;
    @Inject
    private CollectionLoader<Autoservice> autoservicesDl;

    @Inject
    private CollectionLoader<Person> clientsDl;

    @Named("TabTables.Clients")
    private VBoxLayout Clients;

    @Inject
    private Button createBtn;

    private DataSource dataSource;
    @Inject
    private UiComponents uiComponents;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        autoservicesDl.load();
    }

    @Subscribe(id = "autoservicesDc", target = Target.DATA_CONTAINER)
    public void onAutoservicesDcItemChange(InstanceContainer.ItemChangeEvent<Autoservice> event) {
        clientsDl.setParameter("autos", event.getItem());
        clientsDl.load();

        Clients.setCaption("Clients (3)");
    }

//    @Subscribe
//    protected void onInit(InitEvent event){
//        clientsTable.addGeneratedColumn("Type", entity -> {
//            LookupPickerField<Field> field = uiComponents.create(LookupPickerField.NAME);
//            field.setValueSource(new ContainerValueSource<>(clientsTable.get));
//        });
//    }












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

    private void showCreateEditor(Person person){
        screenBuilders.editor(clientsTable)
                .editEntity(person)
                .build()
                .show();
    }




}