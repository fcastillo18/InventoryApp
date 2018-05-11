
Pending:

InvTransList habilitar al change de 'compra/venta' para mostrar en table



ProductNew: 
-Limpiar campos
-Habilitar Find proveedor

-Filtros de busqueda en InvTransList
-Reporte de ganancias
-Inv inicial - Final

-Cuando se agrega un producto en la ventana de Sales, psi es eliminado esa 
cantidad deberia ser restaurada en la lista que muestra la cantidad disponible

-El numero de factura actualmente toma el size de invtrans,
cambiar para tomar el ultimo numero de factura +1

-Solo una ventana abierta por click

-SupplierNewform, tiene le metodo para validar los textfield y marcarlos en caso de ser requeridos
//        for (Object comp : jPanel1.getComponents()) {
//            if (comp instanceof JTextField) {
//                boolean result = new MainAppController().verify((JComponent) comp);
//                if (result == false) {
//                    valid = false;
//                }
//            }
//        }

-EL numero de factura generado en Sales deber ser filtrando las 'ventas' ya que como esta 
contemplara un compra en algun momento y la compra tienen 000000

-El find product en Sales, al agregar item a la lista se resta la cantidad disp, 
pero el dialog lee directamente de la base de datos y muestra las mismas cantidades.

-Validar que los codigos sean unicos al registrar en cualquier modulo

-REPORTE DE GANANCIAS
-OPCION DE REIMPRIMIR DOCUMENTO(FACTURA) INDICADO