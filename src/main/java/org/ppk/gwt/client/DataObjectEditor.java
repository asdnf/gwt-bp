package org.ppk.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class DataObjectEditor extends Composite {

    private static final DataObjectEditor.MyUiBinder uiBinder = GWT.create(DataObjectEditor.MyUiBinder.class);

    @UiField
    PushButton okBtn;

    @UiField
    PushButton cancelBtn;

    @UiField
    RichTextArea nameField;

    @UiField
    RichTextArea idField;

    DialogBox dlg;

    public DataObjectEditor() {
        initWidget(uiBinder.createAndBindUi(this));

        dlg = new DialogBox();
        dlg.add(this);

        cancelBtn.addClickHandler(clickEvent -> {
            dlg.hide();
        });

        okBtn.addClickHandler(clickEvent -> {
            DataObject dataObject = DataObject.createInstance();
            dataObject.setName(nameField.getText());
            dataObject.setId(Integer.valueOf(idField.getText()));

            String json = JsonUtils.stringify(dataObject);

            RequestBuilder rb = new RequestBuilder(RequestBuilder.PUT, "/main/dataobject");
            rb.setRequestData(json);
            rb.setHeader("Content-Type", "application/json");
            rb.setCallback(new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    dlg.hide();
                }

                @Override
                public void onError(Request request, Throwable throwable) {

                }
            });

        });

    }

    public DialogBox getDlg() {
        return dlg;
    }

    interface MyUiBinder extends UiBinder<DockLayoutPanel, DataObjectEditor> {
    }
}
