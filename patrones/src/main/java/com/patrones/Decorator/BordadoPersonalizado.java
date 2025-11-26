/**
 * Decorador BordadoPersonalizado: añade bordado personalizado al producto.
 * Incrementa el precio en 15.00 y añade descripción.
 */
public class BordadoPersonalizado extends DecoradorProductoBase {
    private static final double COSTO_ADICIONAL = 15.00;
    private static final String DESCRIPCION_ADICIONAL = ", con Bordado Personalizado";
    
    /**
     * Constructor que especifica el producto a decorar con bordado.
     * @param productoDecorado el producto que recibirá el bordado
     */
    public BordadoPersonalizado(IProducto productoDecorado) {
        super(productoDecorado);
    }
    
    @Override
    public double obtenerPrecio() {
        return productoDecorado.obtenerPrecio() + COSTO_ADICIONAL;
    }
    
    @Override
    public String obtenerDescripcion() {
        return productoDecorado.obtenerDescripcion() + DESCRIPCION_ADICIONAL;
    }
}
