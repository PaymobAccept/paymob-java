package com.paymob.http.methods;

import org.json.JSONObject;

public interface Patch {
    JSONObject patch(String payload);
}
