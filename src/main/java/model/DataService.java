package model;

import java.util.List;
import java.util.Optional;

public interface DataService {
    public List<Usuario> obtenerUsuarios();
    Optional<Usuario> guardar(Usuario usuario);
}
