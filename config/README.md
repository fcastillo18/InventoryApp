
0- Arreglar campos de montos para que almacenen valores de 1,000  ---DONE
1. Debo poder eliminar lo que pongo mal. O sea, grabo un pordcuto y si me equivoque no puedo borrarlo ya.
  La creacuion de un producto implica tambien una entrada al inventario y una transaccion de compra. El borrar un producto, 
    implicaria borrarlo de esos tres lugares y si por 'error' borras el producto que no es no habra manera de recuperarlo.
    
    A ver, entiendo que si quieres eliminar un producto solo sera posible cuando este no tenga registros de venta. De modo que no afecte consultas futuras

2. Cuando reimprimo una factura, hay un item que borrre por la base de datos que no me sale. 
 No deberias, repito.. NO DEBES tocar ningun registro a traves de la base de datos.
    Esto compromete la integridad de la data y no aseguro nada bueno de manipular esto sin saber.

3. Debopoder borrar todo, menos facturas
    Borrar todo, significa dejar facturas anteriores a estos borrados con problemas, 
digase... querras reimprimir una factura con el nombre de un producto que ya no existe o cliente que tampoco existe...etc

Trabajare para que puedas 'eliminar' solo aquellos registros que no tienen facturas de venta relacionadas

4. No me permite que el stock sea cero, o sea, si tengo 2 suape no puedo venderlos los dos. --DONE
    El stock debe permitirme que lo venda todo y me quede sin nada. Lo logico es que me tire un aviso pero no que no me permita vernderlo.

5. Debo poder modificar las cosas, o sea, el porducto no puedo modificar mas que el nombre, el precio y demas no puedo hacerlo. 
    No porque sea otro prodcutos, sino porque ponga el ptrecio mal o el producto el suplidor lo haya subido de precio

Creo haberte explicado como se manejaria esto, a ver... El costo de las entradas se manejera de manera ponderada:
https://pyme.lavoztx.com/cmo-realizar-un-promedio-ponderado-en-un-inventario-7877.html


6-Tambien debo eliminar una venta. Acabo de tirar uno pero me equivoque en el nombre del cliente, esa debo hacerla de nuevo pero saldra en el reporte de ganancias sin serlo
En este punto lo que he pensado es lo siguiente: Opcion Cancelar Factura, esta hara una entrada a inventario con los elementos de la factura cancelada, 
pero dejara registros en la factura y ganancias en 0 (para temas de control).


Average COST
------------------------------------------------------------------------------------
Pending:

InvTransList habilitar al change de 'compra/venta' para mostrar en table

-Filtros de busqueda en InvTransList
-Inv inicial - Final


-SupplierNewform, tiene le metodo para validar los textfield y marcarlos en caso de ser requeridos
//        for (Object comp : jPanel1.getComponents()) {
//            if (comp instanceof JTextField) {
//                boolean result = new MainAppController().verify((JComponent) comp);
//                if (result == false) {
//                    valid = false;
//                }
//            }
//        }


-Validar que los codigos sean unicos al registrar en cualquier modulo
