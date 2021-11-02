package com.paymob.resources;

import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.http.utils.DataAccessing;

public class Intention extends DataAccessing {

    public Intention(Request requestObject, Model model) {
        super(requestObject, model);
    }

    public Intention(Request requestObject) {
        super(requestObject);
    }
}
