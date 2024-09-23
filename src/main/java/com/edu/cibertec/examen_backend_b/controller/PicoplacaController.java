package com.edu.cibertec.examen_backend_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.cibertec.examen_backend_b.dto.BuscarRequestDTO;
import com.edu.cibertec.examen_backend_b.dto.BuscarResponseDTO;
import com.edu.cibertec.examen_backend_b.service.BuscarService;

@RestController
@RequestMapping("/picoplaca")
public class PicoplacaController {

    @Autowired
    BuscarService buscarService;
    @PostMapping("/buscar")
    public BuscarResponseDTO buscar( @RequestBody BuscarRequestDTO placaRequestDTO) {
        try {
            String[] datosPlaca = buscarService.validarPlaca(placaRequestDTO);
            if (datosPlaca == null) {
                return new BuscarResponseDTO("Placa no encontrada", null, null, 0, 0, null);
            }
            return new BuscarResponseDTO(datosPlaca[0], datosPlaca[1], datosPlaca[2], Integer.parseInt(datosPlaca[3]), Double.parseDouble(datosPlaca[4]), datosPlaca[5]);	
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BuscarResponseDTO("Ocurrio un problema", null, null, 0, 0, null);
        } 
        
        
    }
}
