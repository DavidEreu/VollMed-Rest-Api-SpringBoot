package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

public class MedicoConConsulta {

    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos){

        if(datos.idMedico() == null){
            return;
        }

        var medicoConConsulta = repository.existByMedicoIdAndData(datos.idMedico(),datos.fecha());

        if (medicoConConsulta){
            throw new ValidationException("Este medico ya tiene una consulta en ese horario");
        }

    }

}
