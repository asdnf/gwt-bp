package org.ppk.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;

public class MainWidget extends com.google.gwt.user.client.ui.Composite {

    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    Label result;

    @UiField
    PushButton closeBtn;

    public MainWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Label getResult() {
        return result;
    }

    public PushButton getCloseBtn() {
        return closeBtn;
    }

    interface MyUiBinder extends UiBinder<DockLayoutPanel, MainWidget> {
    }
}
