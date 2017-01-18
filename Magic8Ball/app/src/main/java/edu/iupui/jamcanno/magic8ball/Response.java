package edu.iupui.jamcanno.magic8ball;

/**
 * Created by alexc on 1/18/2017.
 */

public class Response {

    public String mResponseString;

    public static Response[] sAllResponses;


    //constructor
    Response(String responseString) {

        mResponseString = responseString;

    }


    //getters & setters
    public String getResponseString() {
        return mResponseString;
    }

    public void setResponseString(String responseString) {
        mResponseString = responseString;
    }



}
