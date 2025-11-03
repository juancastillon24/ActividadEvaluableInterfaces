package model;

import java.util.List;
import java.util.Optional;

public class DataServiceClass implements DataService {
    @Override
    public List<Usuario> obtenerUsuarios() {
        return List.of();
    }

    @Override
    public Optional<Usuario> guardar(Usuario usuario) {
        return Optional.of(usuario);
    }
}
