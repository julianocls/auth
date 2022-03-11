package br.mg.jcls.auth;

import br.mg.jcls.auth.entity.Permission;
import br.mg.jcls.auth.entity.User;
import br.mg.jcls.auth.repository.PermissionRepository;
import br.mg.jcls.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PermissionRepository permissionRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(userRepository, permissionRepository, passwordEncoder);
        };

    }

    private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository,
                           BCryptPasswordEncoder passwordEncoder) {

        Permission permission = null;
        Permission findPermission = permissionRepository.findByDescription("Admin");
        if (findPermission == null) {
            permission = new Permission();
            permission.setDescription("Admin");
            permission = permissionRepository.save(permission);
        } else {
            permission = findPermission;
        }

        User admin = new User();
        admin.setUserName("juliano");
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setCredentialsNonExpired(true);
        admin.setEnabled(true);
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setPermissions(Arrays.asList(permission));

        User find = userRepository.findByUserName("juliano");
        if (find == null) {
            userRepository.save(admin);
        }
    }

}