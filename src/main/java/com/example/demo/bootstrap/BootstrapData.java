package com.example.demo.bootstrap;

import com.example.demo.model.Permissions;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Component
public class BootstrapData implements CommandLineRunner {


    private final UserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapData(UserRepo userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");



        User user1 = new User();
        user1.setLastName("Atlic");
        user1.setFirstName("Igor");
        user1.setEmail("igor@gmail.com");
        user1.setPassword(this.passwordEncoder.encode("12341234"));
        HashSet<Permissions> tem = new HashSet<>();
        tem.add(Permissions.can_create_users);
        tem.add(Permissions.can_read_users);
        tem.add(Permissions.can_delete_users);
        tem.add(Permissions.can_update_users);
        user1.setPermissions(tem);
        this.userRepository.save(user1);

        User user2 = new User();
        user2.setLastName("User2");
        user2.setFirstName("User2 F");
        user2.setEmail("igor@gmail1.com");
        user2.setPassword(this.passwordEncoder.encode("12341234"));
        HashSet<Permissions> tem1 = new HashSet<>();
        tem1.add(Permissions.can_read_users);
        user2.setPermissions(tem1);
        this.userRepository.save(user2);

        User user3 = new User();
        user3.setLastName("Atlic");
        user3.setFirstName("Igor");
        user3.setEmail("igor@gmail2.com");
        user3.setPassword(this.passwordEncoder.encode("12341234"));
        HashSet<Permissions> tem3 = new HashSet<>();
        user3.setPermissions(tem3);
        this.userRepository.save(user3);


        System.out.println("Data loaded!");
    }
}
