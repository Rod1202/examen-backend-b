package com.edu.cibertec.examen_backend_b.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;
import com.edu.cibertec.examen_backend_b.dto.BuscarRequestDTO;
import com.edu.cibertec.examen_backend_b.service.BuscarService;

@Service
public class BuscarServiceImpl implements BuscarService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(BuscarRequestDTO buscarRequestDTO) throws IOException {
       String[] datoPlaca = null;
       Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
       try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if(buscarRequestDTO.placa().equals(datos[1])){
                datoPlaca = new String[6];
                datoPlaca[0] = datos[1];
                datoPlaca[1] = datos[2];
                datoPlaca[2] = datos[3];
                datoPlaca[3] = datos[4];
                datoPlaca[4] = datos[5];
                datoPlaca[5] = datos[6];
                break;
            }
        }
       }catch (IOException e) {
        datoPlaca = null;
        throw new IOException(e);
       }

       return datoPlaca;
    }

}
