
package datosestudiantes;

public class Producto {
    private String Id;
    private String codigo;
    private String Nombre;
    private String Apellido;
    private String Carne;
    private String Edad;
    private String Sexo;
    private String Estado;

     public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCarne() {
        return Carne;
    }

    public void setCarne(String Carne) {
        this.Carne = Carne;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

   
    @Override
    public String toString() {
        return +'\n'+  "Id= "+ codigo +", Carne es : " + Carne+ ",  Nombre es: " + Nombre + ", Apellido es: " + Apellido + ", Edad es: " + Edad + ", Sexo es: " + Sexo +'\n';
    
    }

   public String save(){
       return codigo +" "+ 
               Nombre+" "
               +Apellido+" "
               +Carne+" "
               +Edad+" "
               +Sexo+" "
               +Estado;
   }

}
