package com.paw.servertrello.controllers;

import org.junit.Ignore;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by Jakub on 2016-11-02.
 */
public class BoardControllerIT {
    private static final String SERVER_URL = "http://localhost:8084/ServerTrello/";
    private static final String BOARD_CHUNK = "board/";
    private static final String BOARD_URL = SERVER_URL + BOARD_CHUNK;

    @Ignore
    @Test
    public void getId_returnsStatusCode200_boardExists() {
        long boardId = 4;
        given().
                accept("application/json").
                when().
                get(BOARD_URL + boardId).
                then().
                statusCode(200);
    }
    @Ignore
    @Test
    public void getId_returnsStatusCode404_boardDoesntExists() {
        long boardId = 235521546;
        given().
                accept("application/json").
                when().
                get(BOARD_URL + boardId).
                then().
                statusCode(404);
    }
    @Ignore
    @Test
    public void getId_returnsBoardObject_boardExists() {
        int boardId = 4;
        given().
                accept("application/json").
                when().
                get(BOARD_URL + boardId).
                then().
                statusCode(200).
                body("id", equalTo(boardId));

    }
/*
    @Test
    public void post_returnsStatus201_validCard() {
        String validCard = "{\n" +
                "  \"cardListId\": 1,\n" +
                "  \"title\": \"cardTestpost\"\n" +
                "}";
        given().
                accept("application/json").
                contentType("application/json").
                body(validCard).
                when().
                post(BOARD_URL).
                then().
                statusCode(201);
    }

    @Test
    public void post_returnsCardLocationHeader_validCard() {
        String validCard = "{\n" +
                "  \"cardListId\": 1,\n" +
                "  \"title\": \"cardTestpost\"\n" +
                "}";
        given().
                accept("application/json").
                contentType("application/json").
                body(validCard).
                when().
                post(BOARD_URL).
                then().
                statusCode(201).
                header("Location", startsWith(BOARD_URL));
    }
*/
}
