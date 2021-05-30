package org.ppk.gwt.client;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class MainWidget extends com.google.gwt.user.client.ui.Composite {

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    CellTable<DataObject> table;

    @UiField
    PushButton addBtn;

    @UiField
    PushButton deleteBtn;

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


        SingleSelectionModel<DataObject> selectionModel = new SingleSelectionModel<DataObject>();
        table.setSelectionModel(selectionModel);

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                DataObject selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected: " + selected.getName());
                }
            }
        });

        RequestBuilder rb = new RequestBuilder(RequestBuilder.PUT, "/main/dataobject");
        rb.setRequestData("Hello!");

        rb.setCallback(new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {
                GWT.log(response.getText());

//                table.setRowCount(CONTACTS.size(), true);
//                table.setRowData(0, CONTACTS);
            }

            @Override
            public void onError(Request request, Throwable throwable) {

            }
        });


        addBtn.addClickHandler(clickEvent -> {
            DataObjectEditor dataObjectEditor = new DataObjectEditor();
            dataObjectEditor.getDlg().center();
            dataObjectEditor.getDlg().show();
        });
    }

    interface MyUiBinder extends UiBinder<DockLayoutPanel, MainWidget> {
    }
}
