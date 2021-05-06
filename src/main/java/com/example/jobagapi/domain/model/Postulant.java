package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "postulant")
public class Postulant extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;
        @OneToOne(mappedBy = "postulant")
        private User user;


        @NotNull
        public String document;
        @NotNull
        public String password;
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

