
package datosestudiantes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    //LECTURA DEL ARCHIVO
    public List<Producto> read(String ruta) throws FileNotFoundException, IOException {
        List<Producto> productos = new ArrayList(); // manipulara la matriz de los datos 
        File archivo = new File(ruta); // nos servira para manipular nuestro archivo
        FileReader fr = new FileReader(archivo);//nos leera nuestro archivo
        BufferedReader br = new BufferedReader(fr);// leera nuestro archivo
        
        // Lectura del fichero
        String linea;
        while ((linea = br.readLine()) != null) {// este while nos evalua si la linea no es nula entonces que la lea 
            String[] result = linea.split(" "); // recorre  cada linea 
             //split () divide una cadena dada alrededor de coincidencias de la expresión regular dada.
            Producto c = new Producto();  
            c.setId(result[0]); // devolvemos el valor 
            c.setNombre(result[1]);
            c.setApellido(result[2]);      
            c.setCarne(result[3]);
            c.setEdad(result[4]);
            c.setSexo(result[5]);
            c.setEstado(result[6]);
            productos.add(c); 
        }
        return productos; // retorna un valor 
    }

    //INGRESO DE DATOS AL ARCHIVO
    public List<Producto> write(String ruta, Producto c) throws IOException {
        List<Producto> productos = null; //crea una lista 
        productos = this.read(ruta);// lee el archivo 
        productos.add(c);//agrega el valor a la array list 
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta)); // para insetar datos en la ruta en este caso nuestro archivo
        try {
            for (int i = 0; i < productos.size(); i++) {       // recorre y obtiene el numero de elementos de la lista
                bw.write(productos.get(i).save() + "\n");  //guarda el valor que se obtuvo en el main 
            }
            bw.close(); // cierra para guardar
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return productos;
    }
    
        //MODIFICACION DE DATOS AL ARCHIVO
    public List<Producto> update(String ruta, Producto c) throws IOException {
        
        List<Producto> productos = null;
        productos = this.read(ruta);       // lee el archivo 
        for (int j = 0; j < productos.size(); j++) {// recorre y obtiene el numero de elementos de la lista
            if (productos.get(j).getId().equals(c.getId()))
           {
              
                productos.get(j).setNombre(c.getNombre()); // toma el valor y lo remplaza por el que se ingresa en el main
                productos.get(j).setApellido(c.getApellido());
                productos.get(j).setCarne(c.getCarne());
                productos.get(j).setEdad(c.getEdad());
                productos.get(j).setSexo(c.getSexo());
                productos.get(j).setEstado(c.getEstado());
          }
        }
        // guardar las modificaciones 
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        
        try {
            for (int i = 0; i < productos.size(); i++) {
                bw.write(productos.get(i).save() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return productos;   
    }
        

//LISTAR TODOS LOS PRODUCTOS INGRESADOS
    public List<Producto> list(String ruta) throws IOException {
         List<Producto> productos = new ArrayList();
        File archivo = new File(ruta);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] result = linea.split(" ");
            Producto c = new Producto();
            if(result[6].equals("a")){//equals se utiliza para comparar strings y filtra unicamente los activo 
            c.setId(result[0]);//muestra los resultados del codigo 
            c.setNombre(result[1]);
            c.setApellido(result[2]);      
            c.setCarne(result[3]);
            c.setEdad(result[4]);
            c.setSexo(result[5]);
            c.setEstado(result[6]);
            productos.add(c);
            }          
        }

        return productos;
    }
        //BUSCAR DATOS EN EL ARCHIVO
    public List<Producto> search(String ruta, String id) throws FileNotFoundException, IOException {
        List<Producto> productos = new ArrayList();
        File archivo = new File(ruta);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] result = linea.split(" ");
            Producto c = new Producto();
            if(result[0].equals(id)){//equals se utiliza para comparar strings // compara si existe el id que se ingreso en el main 
            c.setId(result[0]);
            c.setNombre(result[1]);
            c.setApellido(result[2]);      
            c.setCarne(result[3]);
            c.setEdad(result[4]);
            c.setSexo(result[5]);
            c.setEstado(result[6]);
            productos.add(c);
            }          
        }

        return productos;
    }
    
            //ELIMINAR DE DATOS AL ARCHIVO
    public List<Producto> delete(String ruta, String id) throws IOException {
        
        List<Producto> productos = null;
        productos = this.read(ruta);       
        for (int j = 0; j < productos.size(); j++) {
            
            if (productos.get(j).getId().equals(id)) // evalua si existe el id en el archivo y de ser asi
           {
                productos.get(j).setEstado("I");//sustituye el estado por Inactivco 
          }
        }
        //guardar cambios
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        try {
            for (int i = 0; i < productos.size(); i++) {
                bw.write(productos.get(i).save() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return productos;   
    }
}
