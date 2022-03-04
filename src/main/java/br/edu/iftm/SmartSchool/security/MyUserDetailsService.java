package br.edu.iftm.SmartSchool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.iftm.SmartSchool.model.Usuario;
import br.edu.iftm.SmartSchool.repository.UsuarioRepository;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.buscaPorLogin(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        System.out.println("++++++++++++++++++++++++++" + usuario.getLogin());
        System.out.println("++++++++++++++++++++++++++" + usuario.getPapel());
        System.out.println("++++++++++++++++++++++++++" + usuario.getClass());
        return new MyUserDetails(usuario);
    }
}
