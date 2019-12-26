/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.app;

import com.test.entity.User;
import com.test.utils.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author german
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }    

    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    
    /**
     * DELETE method for updating or creating an instance of UserResource
     * @param asyncResponse
     * @param id 
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteUser(@Suspended
    final AsyncResponse asyncResponse, @PathParam(value = "id")
    final String id) {
        
        Future<?> submit = executorService.submit(() -> {
            asyncResponse.resume(doDeleteUser(id));
        });
    }

    private Response doDeleteUser(@PathParam("id") String id) {
        User deleted = new User();
        deleted.setId(id);
        deleted.setName("German");
        deleted.setPhone("3013555555");
        
        return Response.getResponse(200, "User deleted successfully", deleted);
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void insertUser(@Suspended final AsyncResponse asyncResponse, final User saved) {
        Future<?> submit = executorService.submit(() -> {
            asyncResponse.resume(doInsertUser(saved));
        });
    }

    private Response doInsertUser(User saved) {
        return Response.getResponse(200, "User saved successfully", saved);
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path(value = "{id}")
    public void updateUser(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final String id) {
        Future<?> submit = executorService.submit(() -> {
            asyncResponse.resume(doUpdateUser(id));
        });
    }

    private Response doUpdateUser(@PathParam("id") String id) {
        User updated = new User();
        updated.setId(id);
        updated.setName("German");
        updated.setPhone("3013555555");
        
        return Response.getResponse(200, "User updated successfully", updated);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path(value = "{id}")
    public void getUser(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final String id) {
        Future<?> submit = executorService.submit(() -> {
            asyncResponse.resume(doGetUser(id));
        });
    }

    private Response doGetUser(@PathParam("id") String id) {
        User user = new User();
        user.setId(id);
        user.setName("German");
        user.setPhone("3013555555");
        
        return Response.getResponse(200, "User retrieved successfully", user);
    }
}
