package cosasMalas;

public class Cosas {

    public Integer getIdProveedor(Presupuesto p){
        Integer idProveedor = null;
        if (p != null){
            if ((p.getSolucitud().getInversionMerken() != null) && p.getSolucitud().getInversionMerken().getProveedor() != null && p.getSolucitud().getInversionMerken().getProveedor().getIdProvedor() != null){
                idProveedor = p.getSolucitud().getInversionMerken().getProveedor().getIdProvedor();
            }else if( p.getSolucitud().getInversionLocal() != null && p.getSolucitud().getInversionLocal().getProveedor() != null && p.getSolucitud().getInversionLocal().getProveedor().getIdProvedor() != null){
                idProveedor = p.getSolucitud().getInversionLocal().getProveedor().getIdProvedor();
            }
        }
        return idProveedor;
    }

    public Integer getIdProveedorV2(Presupuesto p){
        if (p == null) return null;

        Inversion solicitud = p.getSolucitud();
        if (solicitud == null) return null;

        InversionLocal local = solicitud.getInversionLocal();
        InversionMerk merken = solicitud.getInversionMerken();

        if (merken == null && local == null) return null;

        Proveedor pro = null;
        if (local != null) pro = local.getProveedor();
        if (merken != null) pro = merken.getProveedor();

        if (pro == null) return null;

        return pro.getIdProvedor();
    }
    
    public static void main(String[] args) {
        
    }
}
