package com.alunoonline.api.service;

import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void criarProfessor(Professor professor){
        professorRepository.save(professor);
    }

    public List<Professor> listarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Optional<Professor> listarProfessorPorId(Long id){
        return professorRepository.findById(id);
    }

    public void atualiarProfessor(Long id, Professor professorAtualizado){
        Optional<Professor> professorOptional = professorRepository.findById(id);

        if (professorOptional.isPresent()){
            Professor professorExistente = professorOptional.get();

            if (professorAtualizado.getNome() != null){
                professorExistente.setNome(professorAtualizado.getNome());
            }

            if (professorAtualizado.getEmail() != null){
                professorExistente.setEmail(professorAtualizado.getEmail());
            }

            professorRepository.save(professorExistente);
        }
    }

    public void deletarProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
