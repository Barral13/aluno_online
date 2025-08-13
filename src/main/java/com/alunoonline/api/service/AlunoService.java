package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void atualizarAluno(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno alunoExistente = alunoOptional.get();

            if (alunoAtualizado.getNome() != null) {
                alunoExistente.setNome(alunoAtualizado.getNome());
            }

            if (alunoAtualizado.getEmail() != null) {
                alunoExistente.setEmail(alunoAtualizado.getEmail());
            }

            alunoRepository.save(alunoExistente);
        }
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
