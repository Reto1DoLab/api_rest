package com.Reto1.Reto1.service;

import java.util.Collection;
import java.util.Optional;

import com.Reto1.Reto1.model.Subscriber;
import com.Reto1.Reto1.repository.AdminRepository;
import com.Reto1.Reto1.repository.CinemaRepository;
import com.Reto1.Reto1.repository.SubscriberRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Collections.singletonList;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService{
    
    private final CinemaRepository cinemaRepository;
    private final AdminRepository adminRepository;
    private final SubscriberRepository subscriberRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)  {
        Optional<Subscriber> userOptional = subscriberRepository.findByUsername(username);
        Subscriber subscriber = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
                        "Found with username : " + username));

        return new org.springframework.security
                .core.userdetails.User(subscriber.getUsername(), subscriber.getPassword(),
                subscriber.isEnabled(), true, true,
                true, getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }
    
}
