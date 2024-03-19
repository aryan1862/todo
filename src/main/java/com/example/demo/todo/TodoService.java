package com.example.demo.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    static {
        todos.add( new Todo(1,"Aryan", "Learn Spring", LocalDate.now().plusYears(1),false));
        todos.add( new Todo(1,"Kumar", "Learn SpringBoot", LocalDate.now().plusYears(1),false));
        todos.add( new Todo(1,"Singh", "Learn JS", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }
}
