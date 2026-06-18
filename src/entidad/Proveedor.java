package entidad;

public class Proveedor {

    private int idProveedor;
    private String razonSocial;
    private String ruc;
    private String direccion;
    private String fechaCreacion;
    private String email;
    private String rubro;
    private String estado;

    // ── Getters ──────────────────────────────
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEmail() {
        return email;
    }

    public String getRubro() {
        return rubro;
    }

    public String getEstado() {
        return estado;
    }

    // ── Setters ──────────────────────────────
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}