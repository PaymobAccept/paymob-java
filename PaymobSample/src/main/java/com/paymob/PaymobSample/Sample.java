package com.paymob.PaymobSample;

import java.io.*;

import com.github.underscore.lodash.U;
import com.paymob.http.Request;
import com.paymob.resources.Intention;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "secretKey", urlPatterns = {"/getsecretKey","/getsecret"})
public class Sample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        Request r = new Request();
        r.setSecretKey("skl_eb7e7ac5117dcd6c0b7539a635f61764aca615bd3b63051606b845c30db3bff8");

        U.formatJson("{\"a\":{\"b\":\"data\"}}");

        U.Builder builder = U.objectBuilder()
                .add("amount", "1000")
                .add("currency", "EGP")

                .add("payment_methods",U.arrayBuilder()
                        .add("card").add("kiosk"))

                .add("billing_data", U.objectBuilder()
                        .add("apartment", "803")
                        .add("email", "claudette9@exa.com")
                        .add("floor", "42")
                        .add("first_name", "Abdelrahman")
                        .add("street", "Ethan Land")
                        .add("building", "8028")
                        .add("phone_number", "01010101010")
                        .add("shipping_method", "PKG")
                        .add("postal_code", "01898")
                        .add("city", "Cairo")
                        .add("country", "EG")
                        .add("last_name", "Hassan")
                        .add("state", "Cairo"))

                .add("customer", U.objectBuilder()
                        .add("first_name", "test")
                        .add("last_name", "test2")
                        .add("email", "claudette9@exa.com"))

                .add("items", U.arrayBuilder()

                        .add(U.objectBuilder()
                                .add("name", "ASC1515")
                                .add("amount", "500")
                                .add("description", "Smart Watch")
                                .add("quantity", "1"))

                        .add(U.objectBuilder()
                                .add("name", "ERT6565")
                                .add("amount", "500")
                                .add("description", "Power Bank")
                                .add("quantity", "1")))

                .add("extras",U.objectBuilder()
                        .add("name","test")
                        .add("userid","30"));

        out.println(new Intention(r).create(builder.toJson()));
    }

    public void destroy() {
    }
}