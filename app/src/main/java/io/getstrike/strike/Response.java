package io.getstrike.strike;

import java.util.ArrayList;

/**
 * Created by Sidharth on 10/02/16.
 */
public class Response {
    int id;
    String type;
    String app_name;
    Data data;

    class Data{
        ArrayList<Email> emails;
    }
}

