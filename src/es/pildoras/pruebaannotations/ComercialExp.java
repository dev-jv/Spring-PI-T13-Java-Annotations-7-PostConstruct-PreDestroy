package es.pildoras.pruebaannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // Toma el nombre de la clase comercialExp

public class ComercialExp implements Empleados {
	@PostConstruct
	public void ejecutaDespuesCreacion() { // Como el método init
		System.out.println("Ejecutado tras la creacion del bean");
	}
	
	@PreDestroy
	public void ejecutaAntesDestruccion() { // Como el método destroy
		System.out.println("Ejecutado antes de la destruccion");
	}
		
//	@Autowired // Aplicado a un método cualquiers
//	public void nombreIndiferente(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
		
//	@Autowired // Aplicado a un método Setter
//	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
	
/*	@Autowired // Busca una clase que implemente CreacionInformeFinanciero y devuelve algo, algo que luego será inyectado en nuevoInforme
	public ComercialExp(CreacionInformeFinanciero nuevoInforme) { 
		this.nuevoInforme = nuevoInforme; // this.nuevoInforme toma lo devuelto al final
	}*/

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender y vender más!!";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
//		return "Informe generado por el comercial";
		return nuevoInforme.getInformeFinanciero(); // Referenciando al actualizado nuevoInforme, llama al método getInformeFinanciero
	}
	
//	private CreacionInformeFinanciero nuevoInforme; // Recibe toda la info. Aquí almacemos la inyección

	@Autowired // Aplicado a un campo de clase
	@Qualifier("informeFinancieroTrim4") // con el Id del bean que debe utilizar
	private CreacionInformeFinanciero nuevoInforme;
}





/*
	@PostConstruct
	public void ejecutaDespuesCreacion() { // Como el método init
		System.out.println("Ejecutado tras la creacion del bean");
	}
	
	@PreDestroy
	public void ejecutaAntesDestruccion() { // Como el método destroy
		System.out.println("Ejecutado antes de la destruccion");
	}


> Para estos métodos no se puede aplicar a @Scope("prototype"), es necesario utilizar el scope por defecto
  Spring no administra el ciclo de vida de un bean prototype.
  Los métodos propios pueden tener como modificadores de acceso private, protected, etc
  Los métodos devuelven cualquier tipo pero por lo general deberían ser void
  Los métodos no reciben ningún parámetro
    
  Requiere desgargarse el paquete Javax.annotation de ser necesario
  
*/