package com.github.lgigek.controllers.components;

public class UrlBuilder {

    public static final String REQUEST_PATH_API = "/api";

    public static final String REQUEST_PATH_TASK_GET_ALL = "/tasks";
    public static final String REQUEST_PATH_TASK_POST_OR_PUT = REQUEST_PATH_TASK_GET_ALL;
    public static final String REQUEST_PATH_TASK_GET_OR_DELETE = REQUEST_PATH_TASK_GET_ALL + "/{name}";

}