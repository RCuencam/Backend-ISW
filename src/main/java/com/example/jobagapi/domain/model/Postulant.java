package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "postulants")
public class Postulant extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @NotNull
        private String firstname;

        @NotNull
        private String lastname;

        @Column(unique = true)
        @NotNull
        private String email;

        @NotNull
        private Long number;

        @NotNull
        private String password;

        @NotNull
        public String document;

        @NotNull
        public Date birthday;
        @NotNull
        public String civil_status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getCivil_status() {
            return civil_status;
        }

        public void setCivil_status(String civil_status) {
            this.civil_status = civil_status;
        }
}

