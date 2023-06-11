package com.example.myapplicationrestaurant.models;

public class Platos {
    public int id;

    public String nombre;

    public String fecha_pedido;

    public Double total;

    public String foto;

    public String tipo;

    public String img;

    public Platos(int id, String nombre, String fecha_pedido, Double total, String foto, String tipo, String img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
        this.foto = foto;
        this.tipo = tipo;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Platos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    @Override
    public String toString() {
        return "Platos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha_pedido='" + fecha_pedido + '\'' +
                ", total=" + total +
                ", foto='" + foto + '\'' +
                '}';
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
