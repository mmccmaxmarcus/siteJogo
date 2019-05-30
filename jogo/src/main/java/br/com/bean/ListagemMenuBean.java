package br.com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Genero;
import entities.Plataforma;

@SessionScoped
@ManagedBean(name="listagemMenuBean")
public class ListagemMenuBean {
   List<Genero> generos;
   Genero genero;
   List<Plataforma> plataformas;
   
   
}
