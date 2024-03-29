package com.example.demo.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static int todosCount = 0;
    private static List<Todo> todos=new ArrayList<>();
    static {
        todos.add( new Todo(++todosCount,"Aryan", "Learn Spring", LocalDate.now().plusYears(1),false));
        todos.add( new Todo(++todosCount,"Kumar", "Learn SpringBoot", LocalDate.now().plusYears(1),false));
        todos.add( new Todo(++todosCount,"Singh", "Learn JS", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }
    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
