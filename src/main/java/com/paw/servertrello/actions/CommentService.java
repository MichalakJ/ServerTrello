package com.paw.servertrello.actions;

import com.paw.servertrello.lib.Comment;
import com.paw.servertrello.persistance.Converters.CommentConverter;
import com.paw.servertrello.persistance.model.CardTable;
import com.paw.servertrello.persistance.model.CommentTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jakub on 2016-11-12.
 */
public class CommentService {
    public static Map comments = new HashMap();
    public static long keyId;

    static {
        CommentTable comment1 = new CommentTable(++keyId, 1L, 1L, "commentMsg");
        comments.put(keyId, comment1);
        CommentTable comment2 = new CommentTable(++keyId, 1L, 1L, "other comment msg");
        comments.put(keyId, comment2);

    }

    public static Comment find(Long id) {
        if(!comments.containsKey(id)){
            return null;
        }
        Comment comment = CommentConverter.convertFromEntityToDto((CommentTable) comments.get(id));
        return comment;
    }

    public static long save(Comment comment) {
        CommentTable commentTable = CommentConverter.convertFromDtoToEntity(comment);
        commentTable.setId(++keyId);
        comments.put(keyId, commentTable);
        return keyId;
    }


    public static int delete(Long id) {
        if(!comments.containsKey(id)){
            return 404;
        }
        comments.remove(id);
        return 204;
    }

    public static int update(Long id, Comment comment) {
        if (!comments.containsKey(id)) {
            return 404;
        }
        CommentTable commentTable = CommentConverter.convertFromDtoToEntity(comment);
        commentTable.setCardId(id);
        comments.replace(id, commentTable);
        return 200;
    }
}
