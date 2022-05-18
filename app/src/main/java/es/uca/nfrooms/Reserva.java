package es.uca.nfrooms;

public class Reserva {

    private String Id;
    private String Telefono;
    private String TipoSala;
    private String Nombre;
    private String DNI;
    private String Email;
    private String Fecha;
    private String HoraIni;
    private String HoraFin;
    private String nPersonas;
    private String Comentario;


    public Reserva(String Id, String Telefono, String TipoSala, String Nombre, String DNI, String Email,
                    String Fecha, String HoraIni, String HoraFin, String nPersonas, String Comentario){
        this.Id = Id;
        this.Telefono = Telefono;
        this.TipoSala = TipoSala;
        this.Nombre = Nombre;
        this.DNI = DNI;
        this.Email = Email;
        this.Fecha = Fecha;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.nPersonas = nPersonas;
        this.Comentario = Comentario;
    }

    public String getId() {
        return Id;
    }
    public String getTelefono() {
        return Telefono;
    }
    public String getTipoSala() {
        return TipoSala;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getDNI() { return DNI; }
    public String getEmail() {
        return Email;
    }
    public String getFecha() {
        return Fecha;
    }
    public String getHoraIni() {
        return HoraIni;
    }
    public String getHoraFin() {
        return HoraFin;
    }
    public String getnPersonas() {
        return nPersonas;
    }
    public String getComentario() {
        return Comentario;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    public void setTipoSala(String TipoSala) {
        this.TipoSala = TipoSala;
    }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    public void setDNI(String DNI) { this.DNI = DNI; }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    public void setHoraIni(String HoraIni) {
        this.HoraIni = HoraIni;
    }
    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }
    public void setnPersonas(String nPersonas) {
        this.nPersonas = nPersonas;
    }
    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

}