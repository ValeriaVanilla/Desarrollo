package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-25T15:01:30")
@StaticMetamodel(UnidadAprendizaje.class)
public class UnidadAprendizaje_ { 

    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horaC;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horaT;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horaL;
    public static volatile SingularAttribute<UnidadAprendizaje, String> nombreUnidad;
    public static volatile ListAttribute<UnidadAprendizaje, Profesor> profesorList;

}