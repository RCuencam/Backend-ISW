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



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="professional_profile_id",referencedColumnName = "id")
    private ProfessionalProfile professionalProfile;


        @NotNull
        private String document;
        @NotNull
        private Date birthday;
        @NotNull
        private String civil_status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }



        public String getDocument() {
            return document;
        }

        public Postulant setDocument(String document) {
            this.document = document;
            return this;
        }

        public Date getBirthday() {
            return birthday;
        }

        public Postulant setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public String getCivil_status() {
            return civil_status;
        }

        public Postulant setCivil_status(String civil_status) {
            this.civil_status = civil_status;
            return this;
        }
}

