
package datosestudiantes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class datosestudiantes {

private static String llave;
private static Scanner inputLlave;

    //MENU PRINCIPAL
    public static void main(String[] args) throws IOException {
         Scanner op = new Scanner(System.in);
        int opc, resp, respu;  
        do{
         System.out.println("Análisis de Datos de Estudiantes");
         System.out.println("");
         System.out.println("1. Ingreso de Datos");
         System.out.println("2. Análisis de Datos");
         System.out.println("3. Salir");
         System.out.println("Seleccione una opcion :");
         opc = op.nextInt();
         
         
         switch (opc){
             case 1 : 
                 System.out.println("");
                 System.out.println("__________________________________________");
                 System.out.println("Análisis de Datos de Estudiantes");
                 MenuProductos();
                 
                 break;
             case 2 :
                 System.out.println("");
                 System.out.println("__________________________________________");  
                 System.out.println("Análisis de Datos de Estudiantes");
                 MenuInformacion();
                 break;
             case 3 :
                 System.out.println("----------El programa se cerro----------");
                 System.exit(0);
        }
                    System.out.println("------------------------------------------");
                    System.out.println("Deseas regresar al Menú principal          ");
                    System.out.println("    1)SI                    2)NO         ");
                    System.out.println("------------------------------------------");
                    resp=op.nextInt();
        }
    while(resp==1);
    }
   //------------------------------------------------------------------------------------------------
   // -------------------------------------------------------------------------------------------------
    //MENU Datos de Estudiantes
    public static void MenuProductos() throws IOException  { //MENU PRODUCTOS
           Scanner op = new Scanner(System.in);
           int opc = 0;
           int respuesta = 0;
           do{     
         System.out.println("        Ingreso de Datos        ");
         System.out.println("__________________________________________");         
         System.out.println("1) Datos Personales del Estudiante:");
         System.out.println("2) Regresa menu principal");
         System.out.println("Seleccione una opcion :");
         opc = op.nextInt();
         
        switch (opc){
             case 1 : 
                 System.out.println("*** Ingresar Datos ****");
                 IngresoDatos();
                 break;

             case 2:
                 
                 break;
        }
                    System.out.println("------------------------------------------");
                    System.out.println("Deseas regresar al Menú Principal         ");
                    System.out.println("    1)SI                    2)NO         ");
                    opc=op.nextInt(); 
           } while(respuesta==1);        
        }

    //-------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------
    //MENU Informacion
    public static void MenuInformacion() throws IOException  { 
           Scanner op = new Scanner(System.in);
           int opc ;
           int respuesta;
           do{
         System.out.println("       Análisis de Datos");
         System.out.println("__________________________________________");  
         System.out.println("1) Datos Personales del Estudiante");
         System.out.println("2) Cantidad de Estudiantes M y F");
         System.out.println("3) Mejor promedio de Cada Carrera");
         System.out.println("4) Datos académicos de estudiantes");
         System.out.println("5) Constancia de Cursos Aprobados");
         System.out.println("6) Salir");
         System.out.println("Seleccione una opcion :");
         opc = op.nextInt();
         
         switch (opc){
             case 1 : 
                 System.out.println("__________________________________________");  
                 System.out.println("Análisis de Datos de Estudiantes");
                 ListaRegistros();

                 break;
             case 2 :

                 System.out.println("__________________________________________");  
                 System.out.println("Análisis de Datos de Estudiantes");

                      
                   //AQUI SE VALIDA LA LISTA DE DATOS PARA MOSTRA POR m Y f
                 //BuscaRegistroBodega();
                            System.out.println("Ingrese la opcion que desea realizar");
                            System.out.println("   Cantidad de Estudiantes M y F");
                            System.out.println("__________________________________________");
                            ListaRegistros2();
                            System.out.println("1) Volver");
                     opc = op.nextInt();
                     switch(opc){
                         case 1:
                             //ModificarBodega();
                             break;
                         case 2 :
                             //EliminarBodega();
                             break;
                         case 3 : 
                             break;
                             
                     }
                 break;
             case 3 :
                 System.out.println("Mejor promedio por carrera");
                 
                 break;  
             case 4:
                 System.out.println("Datos Academicos de Estudiantes");

                 break;
             case 5:
                 System.out.println("__________________________________________");  
                 System.out.println("Análisis de Datos de Estudiantes");
                 BuscaRegistro();
                 
                 break;
             case 6:
                 System.out.println("----------El programa se cerro----------");
                 System.exit(0);     
         
         
         }
                    System.out.println("------------------------------------------");
                    System.out.println("Deseas regresar al Menú Bodega           ");
                    System.out.println("    1)SI                    2)NO         ");
                    System.out.println("------------------------------------------");
                    respuesta=op.nextInt(); 
           } while(respuesta==1);        
        }
    
    
    
   //--------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------
    //PRODUCTOS CRUD 
    private static void Modificar() throws IOException { //MODIFICAR 
       String ruta= "productos.txt"; //Abrir archivo txt
       CRUD crud= new CRUD(); // crea un nuevo crud para modificar 
       String codigo;
       String Nombre;
       String Apellido;
       String Carne;
       String Edad;
       String Sexo;

       //Ingreso de Datos
              Scanner tecladomod = new Scanner(System.in);
               System.out.println("Introduzca nombre ");
               Nombre = tecladomod.nextLine();
               System.out.println("Introduzca Descricion");
               Apellido=tecladomod.nextLine();
               System.out.println("Ingrese precio compra");
               Carne=tecladomod.nextLine();
               System.out.println("Ingrese precio venta");
               Edad=tecladomod.nextLine();
               System.out.println("Ingrese fecha ingreso");
               Sexo=tecladomod.nextLine();
               
       //INGRESO DATOS  MODIFICADOS
       Producto cu= new Producto();
       cu.setId(llave);
       cu.setNombre(Nombre);
       cu.setApellido(Apellido);
       cu.setCarne(Carne);
       cu.setEdad(Edad);
       cu.setSexo(Sexo);
       cu.setEstado("a");
       List <Producto> ProductoUpdate=crud.update(ruta, cu);
       System.out.println("El producto ha sido modificado con exito");
    }

    private static void IngresoDatos() throws IOException {
        String ruta= "productos.txt";
       CRUD crud= new CRUD();
       //LEER DATOS
       List <Producto> ProductoRead = crud.read(ruta);
       //Declaracion de variables
       String codigo;
       String nombre;
       String apellido;
       String carne;
       String edad;
       String sexo;
       
       Scanner teclado = new Scanner(System.in);
               System.out.println("Introduzca Id");
               codigo = teclado.nextLine(); 
               System.out.println("Introduzca Nombre");
               nombre = teclado.nextLine();
               System.out.println("Introduzca Apellido");
               apellido=teclado.nextLine();
               System.out.println("Ingrese Carne");
               carne=teclado.nextLine();
               System.out.println("Ingrese Edad");
               edad=teclado.nextLine();
               System.out.println("Ingrese Sexo");
              sexo=teclado.nextLine();
               
       //AGREGAR PRODUCTO
       Producto c= new Producto();
       //c.setId(codigo);
       c.setNombre(nombre);
       c.setApellido(apellido);
       c.setCarne(carne);
       c.setEdad(edad);
       c.setSexo(sexo);
       c.setEstado("a");
       List <Producto> ProductoWrite=crud.write(ruta, c);
       System.out.println("**********PRODUCTO AGREGADO**********");   
       

    }

    private static void ListaRegistros() throws IOException {
       String ruta= "productos.txt";
       CRUD crud= new CRUD();
       List <Producto> productolist = crud.list(ruta);
       System.out.println("      Análisis de Datos");
              System.out.println("Datos Personales del Estudiante");
       System.out.println("__________________________________________");  
       System.out.println(" "+ productolist);
    }
 
    
      private static void ListaRegistros2() throws IOException {
       String ruta= "productos.txt";
       CRUD crud= new CRUD();
       List <Producto> productolist = crud.list(ruta);
       System.out.println(" "+ productolist);
    }  
    
    
    private static void BuscaRegistro() throws IOException {
       String ruta= "productos.txt";
       CRUD crud= new CRUD();
       inputLlave = new Scanner(System.in);
       System.out.println("Ingrese Carne de Estudiante");
       llave = inputLlave.next();
       List <Producto> ProductoSearch = crud.search(ruta, llave);
       System.out.println("**********PRODUCTOS**************");
        System.out.println("Los productos encontrados son:" +'\n'+ProductoSearch);
     
    }
    
    private static void Eliminar() throws IOException { 
       String ruta= "productos.txt"; //Abrir archivo txt
       CRUD crud= new CRUD(); // crea un nuevo crud para modificar 
       //CAMBIAR ESTADO A INACTIVO
       Producto c2= new Producto();
       c2.setEstado("i");
       String llave1 = llave;
       
       List <Producto> Productodelete=crud.delete(ruta, llave1);
       System.out.println("**********PRODUCTO ELIMINADO EXITOSAMENTE**********");
     
    }      
}
