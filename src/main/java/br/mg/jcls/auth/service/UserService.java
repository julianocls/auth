package br.mg.jcls.auth.service;

import br.mg.jcls.auth.entity.User;
import br.mg.jcls.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = repository.findByUserName(username);
        if(!userOptional.isPresent()) {
            throw new UsernameNotFoundException("Username " + username + " no found!");
        }
        return userOptional.get();
    }
}
