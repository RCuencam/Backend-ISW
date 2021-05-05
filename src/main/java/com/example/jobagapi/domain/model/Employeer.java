package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

        public Employeer(){}
        public Employeer(@NotNull String posicion, @NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull Long number, @NotNull String password) {
                this.posicion = posicion;
                this.firstname = firstname;
                this.lastname = lastname;
                this.email = email;
                this.number = number;
                this.password = password;
        }

        public Long getId() {
                return id;
        }

        public Employeer setId(Long id) {
                this.id = id;
                return this;
        }

        public String getPosicion() {
                return posicion;
        }

        public Employeer setPosicion(String posicion) {
                this.posicion = posicion;
                return this;
        }

        public String getFirstname() {
                return firstname;
        }

        public Employeer setFirstname(String firstname) {
                this.firstname = firstname;
                return this;
        }

        public String getLastname() {
                return lastname;
        }

        public Employeer setLastname(String lastname) {
                this.lastname = lastname;
                return this;
        }

        public String getEmail() {
                return email;
        }

        public Employeer setEmail(String email) {
                this.email = email;
                return this;
        }

        public Long getNumber() {
                return number;
        }

        public Employeer setNumber(Long number) {
                this.number = number;
                return this;
        }

        public String getPassword() {
                return password;
        }

        public Employeer setPassword(String password) {
                this.password = password;
                return this;
        }
}
