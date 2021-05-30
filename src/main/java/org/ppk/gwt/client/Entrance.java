package org.ppk.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

public class Entrance implements EntryPoint {

    public void onModuleLoad() {
        Button sendButton = new Button("Send");
        //RootPanel.get("sendButtonContainer").add(sendButton);

        DialogBox dlg = new DialogBox();

        MainWidget mw = new MainWidget();
        dlg.add(mw);

        dlg.center();
        dlg.show();
    }

}
