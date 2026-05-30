package util;

public class ValidateUtil {
	// Validar ID de Proveedor (Solo números enteros positivos)
    public static final String ID_PROVEEDOR = "^[1-9]\\d*$";

    // Validar Razón Social (Letras, números, espacios, tildes, ñ, y caracteres de empresas como S.A., S.A.C., E.I.R.L.)
    public static final String RAZON_SOCIAL = "^[A-Za-z0-9 áéíóúÁÉÍÓÚñÑüÜ.,&-]{1,100}$";

    // Validar RUC (Exactamente 11 dígitos numéricos, común en Perú)
    public static final String RUC = "^\\d{11}$";

    // Validar Dirección (Letras, números, tildes, caracteres comunes como #, ., -, ,)
    public static final String DIRECCION = "^[A-Za-z0-9 áéíóúÁÉÍÓÚñÑüÜ.,#\\-\\/]{5,150}$";

    // Validar Fecha de Creación (Formato YYYY-MM-DD estándar)
    public static final String FECHA_CREACION = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

    // Validar Email (Estructura estándar de correo electrónico)
    public static final String EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    // Validar Rubro (Texto similar a TEXTO_30 o TEXTO_40 de tu ejemplo)
    public static final String RUBRO = "^[A-Za-z áéíóúÁÉÍÓÚñÑüÜ]{3,50}$";

    // Validar Estado (Por ejemplo, si solo permites valores fijos como 'Activo' o 'Inactivo')
    public static final String ESTADO = "^(?i)(Activo|Inactivo|Suspendido)$";

}
