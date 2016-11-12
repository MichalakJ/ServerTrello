package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.Comment;
import com.paw.servertrello.persistance.model.CommentTable;

/**
 * Created by Jakub on 2016-11-12.
 */
public class CommentConverter {
    public static Comment convertFromEntityToDto(CommentTable commentTable) {
        Comment comment = new Comment();
        comment.setCardId(commentTable.getCardId());
        comment.setId(commentTable.getId());
        comment.setMessage(commentTable.getMessage());
        comment.setUserId(commentTable.getUserId());
        return comment;
    }

    public static CommentTable convertFromDtoToEntity(Comment comment){
        CommentTable commentTable = new CommentTable();
        commentTable.setUserId(comment.getUserId());
        commentTable.setId(comment.getId());
        commentTable.setMessage(comment.getMessage());
        commentTable.setCardId(comment.getCardId());
        return commentTable;

    }
}
