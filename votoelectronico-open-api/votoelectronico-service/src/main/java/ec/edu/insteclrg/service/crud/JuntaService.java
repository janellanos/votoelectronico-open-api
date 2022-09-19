package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Junta;
import ec.edu.insteclrg.dto.JuntaDTO;
import ec.edu.insteclrg.persistence.JuntaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class JuntaService extends GenericCrudServiceImpl<Junta, JuntaDTO> {

	@Autowired
	private JuntaRepository repository;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public Optional<Junta> find(JuntaDTO dto) {		
		return repository.findById(dto.getId());
	}

	@Override
	public JuntaDTO mapToDto(Junta domain) {
		JuntaDTO dto=modelMapper.map(domain, JuntaDTO.class);
		return dto;
	}

	@Override
	public Junta mapToDomain(JuntaDTO dto) {
		Junta domain=modelMapper.map(dto, Junta.class);
		return domain;
	}
	
	public void delete(JuntaDTO dto) {
		Optional<Junta> optionalJunta = repository.findById(dto.getId());
		if (!optionalJunta.isPresent()) {
			throw new ResourceNotFoundException(String.format("La junta %s no existe"));
		}	
		Junta junta=optionalJunta.get();
		repository.delete(junta);
	}
}
