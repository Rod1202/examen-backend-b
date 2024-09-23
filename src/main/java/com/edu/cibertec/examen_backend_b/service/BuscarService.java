package com.edu.cibertec.examen_backend_b.service;

import com.edu.cibertec.examen_backend_b.dto.BuscarRequestDTO;
import java.io.IOException;

public interface BuscarService {
    String[] validarPlaca(BuscarRequestDTO buscarRequestDTO) throws IOException;
    default void imprimirPlacaId(){
        System.out.println("Placa: ");
    }
}
