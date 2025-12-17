package ru.mephi;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.Path;

@Path("/do")
public class WebController {
    @GET
    @Path("/test")
    public String test() {
        return "privet mir";
    }
}
