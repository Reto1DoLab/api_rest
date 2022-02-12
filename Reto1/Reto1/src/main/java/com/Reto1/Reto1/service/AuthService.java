package com.Reto1.Reto1.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.Reto1.Reto1.dto.AuthenticationResponse;
import com.Reto1.Reto1.dto.LoginRequest;
import com.Reto1.Reto1.dto.RegisterCinemaRequest;
import com.Reto1.Reto1.dto.RegisterRequest;
import com.Reto1.Reto1.exception.CinemasDoLabException;
import com.Reto1.Reto1.model.Cinema;
import com.Reto1.Reto1.model.NotificationEmail;
import com.Reto1.Reto1.model.Subscriber;
import com.Reto1.Reto1.model.VerificationToken;
import com.Reto1.Reto1.repository.AdminRepository;
import com.Reto1.Reto1.repository.CinemaRepository;
import com.Reto1.Reto1.repository.SubscriberRepository;
import com.Reto1.Reto1.repository.UserRepository;
import com.Reto1.Reto1.repository.VerificationTokenRepository;
import com.Reto1.Reto1.security.JwtProvider;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final SubscriberRepository subscriberRepository;
    private final CinemaRepository cinemaRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    
    @Transactional
    public void signUp(RegisterRequest registerRequest) {
        Subscriber subscriber = new Subscriber();
        subscriber.setUsername(registerRequest.getUsername());
        subscriber.setName(registerRequest.getName());
        subscriber.setSurname(registerRequest.getSurname());
        subscriber.setEmail(registerRequest.getEmail());
        subscriber.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        subscriber.setPoints(0);
        subscriber.setEnabled(false);
        subscriber.setCreated(Instant.now());

        subscriberRepository.save(subscriber);

        String token = generateVerificationToken(subscriber);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                subscriber.getEmail(), "\nThank you for signing up to Cinemas DoLab, " +
                "please click on the below url to activate your account :\n" +
                "http://localhost:8090/api/auth/accountVerification/" + token));
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();
    }

    public void signUpCinema(RegisterCinemaRequest registerCinemaRequest) {
        Cinema cinema = new Cinema();
        cinema.setUsername(registerCinemaRequest.getUsername());
        cinema.setEmail(registerCinemaRequest.getEmail());
        cinema.setPassword(registerCinemaRequest.getPassword());
        cinema.setWeb(registerCinemaRequest.getWeb());
        cinema.setAddress(registerCinemaRequest.getAddress());
        cinema.setCreated(Instant.now());
        cinema.setEnabled(true);

        cinemaRepository.save(cinema);
        
    }

    private String generateVerificationToken(Subscriber subscriber) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setSubscriber(subscriber);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token){
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(()-> new CinemasDoLabException("Invalid token"));
        fetchUserAndEnable(verificationToken.get());
    }


    public void fetchUserAndEnable(VerificationToken verificationToken){
        String username = verificationToken.getSubscriber().getUsername();
        Subscriber subscriber = subscriberRepository.findByUsername(username).orElseThrow(() -> new CinemasDoLabException("User not found with name - " + username));
        subscriber.setEnabled(true);
        subscriberRepository.save(subscriber);
    }
    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
