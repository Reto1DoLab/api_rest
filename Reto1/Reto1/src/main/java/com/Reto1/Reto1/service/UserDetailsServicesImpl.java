package com.Reto1.Reto1.service;

import static java.util.Collections.singletonList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Reto1.Reto1.dto.RegisterRequest;
import com.Reto1.Reto1.model.Subscriber;
import com.Reto1.Reto1.model.User;
import com.Reto1.Reto1.repository.AdminRepository;
import com.Reto1.Reto1.repository.CinemaRepository;
import com.Reto1.Reto1.repository.SubscriberRepository;
import com.Reto1.Reto1.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService{
    
    private final UserRepository userRepository;
    private final CinemaRepository cinemaRepository;
    private final AdminRepository adminRepository;
    private final SubscriberRepository subscriberRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)  {
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
                        "Found with username : " + username)); 
                return new org.springframework.security
                .core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true,
                true, getAuthorities(user.getDecriminatorValue()));
        
        
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }

    public List<RegisterRequest> getAll() {
        return null;
    }
    
}
