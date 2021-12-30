package com.example.recipe731.board;

import java.util.List;

public interface TodoService {

    List<Todo> listTodos();
    void save(Todo todo);
    void complete(long id);
    void remove(long id);
    Todo findById(long id);
}
