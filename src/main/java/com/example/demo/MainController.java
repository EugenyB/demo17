package com.example.demo;

import com.example.demo.data.Student;
import com.example.demo.repo.StudentRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

import java.util.List;

public class MainController {
    @Getter
    private static StudentRepository studentRepository;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;

    public static void setRepo(StudentRepository repository) {
        studentRepository = repository;
    }

    public void initialize() {
         idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
         ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

         fillTable();
    }

    private void fillTable() {
        List<Student> students = studentRepository.findAll();
        studentTable.setItems(FXCollections.observableList(students));
    }

}
