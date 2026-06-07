package com.example.projetoUsuario.repository;

import com.example.projetoUsuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para a Entity Usuario
 *
 * Métodos disponíveis:
 * - findByUsername: Buscar por username
 * - findByEmail: Buscar por email
 * - findByEmailOrUsername: Buscar por email OU username
 * - findByAtivoTrue: Listar usuários ativos
 * - findByVerificadoTrue: Listar usuários verificados
 * - findByTipoUsuarioAtivo: Buscar por tipo e ativo
 * - existsByUsername: Verificar se username existe
 * - existsByEmail: Verificar se email existe
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Buscar usuário por username
     *
     * @param username o username
     * @return Optional com o usuário se encontrado
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Buscar usuário por email
     *
     * @param email o email
     * @return Optional com o usuário se encontrado
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Buscar usuário por email OU username
     *
     * @param email o email
     * @param username o username
     * @return Optional com o usuário se encontrado
     */
    Optional<Usuario> findByEmailOrUsername(String email, String username);

    /**
     * Listar todos os usuários ativos
     *
     * @return Lista de usuários ativos
     */
    List<Usuario> findByAtivoTrue();

    /**
     * Listar todos os usuários verificados
     *
     * @return Lista de usuários verificados
     */
    List<Usuario> findByVerificadoTrue();

    /**
     * Buscar usuários por tipo e que estejam ativos
     * Query customizada com JPQL
     *
     * @param tipo o tipo de usuário
     * @return Lista de usuários do tipo especificado e ativos
     */
    @Query("SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipo AND u.ativo = true")
    List<Usuario> findByTipoUsuarioAtivo(@Param("tipo") String tipo);

    /**
     * Verificar se username já existe
     *
     * @param username o username
     * @return true se existe, false caso contrário
     */
    boolean existsByUsername(String username);

    /**
     * Verificar se email já existe
     *
     * @param email o email
     * @return true se existe, false caso contrário
     */
    boolean existsByEmail(String email);

    /**
     * Contar usuários ativos
     *
     * @return número de usuários ativos
     */
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.ativo = true")
    long countByAtivoTrue();

    /**
     * Buscar usuários por tipo
     *
     * @param tipo o tipo de usuário
     * @return Lista de usuários do tipo especificado
     */
    @Query("SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipo")
    List<Usuario> findByTipoUsuario(@Param("tipo") String tipo);

    /**
     * Buscar usuários inativos
     *
     * @return Lista de usuários inativos
     */
    List<Usuario> findByAtivoFalse();
}