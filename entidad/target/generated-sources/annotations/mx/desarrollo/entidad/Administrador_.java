package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-24T22:40:34")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> apP;
    public static volatile SingularAttribute<Administrador, Integer> idAdmin;
    public static volatile ListAttribute<Administrador, Usuario> usuarioList;
    public static volatile SingularAttribute<Administrador, Integer> noempleado;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, String> apM;

}