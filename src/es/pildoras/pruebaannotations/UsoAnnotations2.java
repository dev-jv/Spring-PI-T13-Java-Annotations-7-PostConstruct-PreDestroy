package es.pildoras.pruebaannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Empleados Reese = contexto.getBean("comercialExp", Empleados.class);
		Empleados Jack = contexto.getBean("comercialExp", Empleados.class);
		
		if(Reese == Jack) { // Evaluamos
			System.out.println("Apuntan al mismo lugar en memoria"); 
			System.out.println(Reese + "\n" + Jack);
		} else {
			System.out.println("No apuntan al mismo lugar en memoria");
			System.out.println(Reese + "\n" + Jack);
		}
		
		contexto.close();
		
	}
}


/*

> Por defecto

Apuntan al mismo lugar en memoria
es.pildoras.pruebaannotations.ComercialExp@55040f2f
es.pildoras.pruebaannotations.ComercialExp@55040f2f

> @Scope("singleton")

Apuntan al mismo lugar en memoria
es.pildoras.pruebaannotations.ComercialExp@534df152
es.pildoras.pruebaannotations.ComercialExp@534df152

> @Scope("prototype")

No apuntan al mismo lugar en memoria
es.pildoras.pruebaannotations.ComercialExp@534df152
es.pildoras.pruebaannotations.ComercialExp@52e677af

*/





