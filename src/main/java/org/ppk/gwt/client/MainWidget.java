package org.ppk.gwt.client;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class MainWidget extends com.google.gwt.user.client.ui.Composite {

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    Label result;

    @UiField
    PushButton closeBtn;

    @UiField
    CellTable<DataObject> table;

    public MainWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        TextColumn<DataObject> nameColumn = new TextColumn<DataObject>() {
            @Override
            public String getValue(DataObject object) {
                return object.getName();
            }
        };
        table.addColumn(nameColumn, "Name");

        NumberCell idCell = new NumberCell();
        Column<DataObject, Number> idColumn = new Column<DataObject, Number>(idCell) {
            @Override
            public Number getValue(DataObject dataObject) {
                return dataObject.getId();
            }
        };
        table.addColumn(idColumn, "Id");


        final SingleSelectionModel<DataObject> selectionModel = new SingleSelectionModel<DataObject>();
        table.setSelectionModel(selectionModel);

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                DataObject selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected: " + selected.getName());
                }
            }
        });

        RequestBuilder rb = new RequestBuilder(RequestBuilder.PUT, "/main/dataobjects");
        rb.setRequestData("Hello!");

        table.setRowCount(CONTACTS.size(), true);
        table.setRowData(0, CONTACTS);

    }

    public Label getResult() {
        return result;
    }

    public PushButton getCloseBtn() {
        return closeBtn;
    }

    interface MyUiBinder extends UiBinder<DialogBox, MainWidget> {
    }
}
