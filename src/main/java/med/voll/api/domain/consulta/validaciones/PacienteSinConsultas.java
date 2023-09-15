package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;


public class PacienteSinConsultas {

    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos){

        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);

        var pacienteConConsulta = repository.existByPacienteIdAndDataBetween(datos.idPaciente(),primerHorario,ultimoHorario);

        if(pacienteConConsulta){
            throw new ValidationException("El paciente ya tiene una consulta para ese dia");
        }

    }

}
