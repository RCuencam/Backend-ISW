package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employeers")
public class Employeer extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @OneToOne(mappedBy = "employeer")
        private User user;

        @NotNull
        @Column(unique = true)
        private String posicion;


        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name ="company_profile_id",referencedColumnName = "id")
        private CompanyProfile companyProfile;

        public Employeer(){}

        public Employeer(@NotNull Long id, @NotNull User user,@NotNull String posicion) {
                this.id = id;
                this.user = user;
                this.posicion = posicion;
        }


        public Long getId() {
                return id;
        }



        public String getPosicion() {
                return posicion;
        }

        public Employeer setPosicion(String posicion) {
                this.posicion = posicion;
                return this;
        }


        public Employeer setId(Long id) {
                this.id = id;
                return this;
        }


        public CompanyProfile getCompanyProfile() {
                return companyProfile;
        }

        public void setCompanyProfile(CompanyProfile companyProfile) {
                this.companyProfile = companyProfile;
        }
}
