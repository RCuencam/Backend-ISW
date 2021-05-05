package com.example.jobagapi.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Employeer extends User{

        @Id
        public long id;
        @NotNull
        public String posicion;


        @Override
        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getPosicion() {
                return posicion;
        }

        public void setPosicion(String posicion) {
                this.posicion = posicion;
        }
}
