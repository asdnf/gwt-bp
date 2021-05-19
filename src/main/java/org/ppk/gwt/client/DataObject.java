package org.ppk.gwt.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class DataObject extends JavaScriptObject {

    protected DataObject() {
    }

    public native Integer getId() /*-{
        return this.id;
    }-*/;

    public native void setId(Integer id) /*-{
        this.id = id;
    }-*/;

    public native String getName() /*-{
        return this.name;
    }-*/;

    public native void setName(String name) /*-{
        this.name = name;
    }-*/;
}
