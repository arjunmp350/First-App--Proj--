
package com.pixel.sidhu.list;

import java.lang.Object;
import java.lang.String;

public class Details {
    private String _clas;
    private String _dob;
    private String _marks;
    private String _name;

    public Details(String string, String string2, String string3, String string4) {
        this._name = string;
        this._dob = string2;
        this._clas = string3;
        this._marks = string4;
    }

    public String getClas() {
        return this._clas;
    }

    public String getDob() {
        return this._dob;
    }

    public String getMarks() {
        return this._marks;
    }

    public String getName() {
        return this._name;
    }
}

