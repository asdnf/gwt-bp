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

        MainWidget mw = new MainWidget();
        mw.getDialog().center();
        mw.getDialog().show();

    }

}
