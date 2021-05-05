package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employeers")
public class Employeer extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @NotNull
        public String posicion;

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

        @OneToOne(mappedBy = "employeer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private CompanyProfile company_profile;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getPosicion() {
                return posicion;
        }

        public void setPosicion(String posicion) {
                this.posicion = posicion;
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
}
