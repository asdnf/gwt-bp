package org.ppk.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Entrance implements EntryPoint {

    public void onModuleLoad() {
        Button sendButton = new Button("Send");
        RootPanel.get("sendButtonContainer").add(sendButton);
        sendButton.addClickHandler(clickEvent -> {
            RequestBuilder rb = new RequestBuilder(RequestBuilder.PUT, "/main/test");
            rb.setRequestData("Hello!");

            rb.setCallback(new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    String json = response.getText();
                    Pojo pojo = JsonUtils.safeEval(json);
                    DialogBox dlg = new DialogBox();
                    dlg.setText("Response");
                    MainWidget widget = new MainWidget();
                    widget.getResult().setText(pojo.getData());
                    widget.getCloseBtn().addClickHandler(event -> {
                        dlg.hide();
                    });
                    dlg.add(widget);
                    dlg.center();
                    dlg.show();
                }

                @Override
                public void onError(Request request, Throwable exception) {

                }
            });
            try {
                rb.send();
            } catch (RequestException e) {
                e.printStackTrace();
            }
        });
    }

}
