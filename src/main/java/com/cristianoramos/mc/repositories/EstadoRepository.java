package com.cristianoramos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristianoramos.mc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{//um objeto desse tipo, será capaz de realizar operações de acesso a dados, busca, deletar, alterar e salvar.

	
}
