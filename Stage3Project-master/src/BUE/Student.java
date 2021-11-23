package BUE;

import javafx.beans.property.SimpleStringProperty;

import java.awt.*;

    public class Student {
        private SimpleStringProperty StudentName, Notes, Status;

        public Student(String StudentName, String Notes, String Status){
            this.StudentName = new SimpleStringProperty(StudentName);
            this.Notes = new SimpleStringProperty(Notes);
            this.Status = new SimpleStringProperty(Status);
        }

        public String getStudentName() {
            return StudentName.get();
        }

        public SimpleStringProperty studentNameProperty() {
            return StudentName;
        }

        public void setStudentName(String studentName) {
            this.StudentName.set(studentName);
        }

        public String getNotes() {
            return Notes.get();
        }

        public SimpleStringProperty notesProperty() {
            return Notes;
        }

        public void setNotes(String notes) {
            this.Notes.set(notes);
        }

        public String getStatus() { return Status.get(); }

        public SimpleStringProperty statusProperty() { return Status; }

        public void setStatus(String status) { this.Status.set(status); }
    }

