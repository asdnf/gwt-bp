package org.ppk.gwt.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class Pojo extends JavaScriptObject {

    protected Pojo() {
    }

    public native String getData() /*-{
        return this.data;
    }-*/;

    public native void setData(String data) /*-{
        this.data = data;
    }-*/;
}
