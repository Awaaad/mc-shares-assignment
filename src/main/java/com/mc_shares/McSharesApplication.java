package com.mc_shares;

import com.mc_shares.entity.Role;
import com.mc_shares.entity.UserProfile;
import com.mc_shares.repository.UserRepository;
import com.mc_shares.service.RoleService;
import com.mc_shares.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class McSharesApplication extends SpringBootServletInitializer {

	private final RoleService roleService;
	private final UserService userService;

	public McSharesApplication(RoleService roleService, UserService userService) {
		this.roleService = roleService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(McSharesApplication.class, args);
	}

	@PostConstruct
	public void initPost() {
		List<Role> roles = Stream.of(
				new Role(1L, "ADMIN")
		).collect(Collectors.toList());
		roleService.saveRoles(roles);

		Set<Role> roleForAdmin = Stream.of(
				new Role(1L, "ADMIN")
		).collect(Collectors.toSet());

		List<UserProfile> userProfiles = Stream.of(
				new UserProfile(1L, "mcShares", "mcShares", "Awad", "Luckhoo", 24, "test@test.com", 9999999, roleForAdmin)
		).collect(Collectors.toList());
		userService.saveUsers(userProfiles);
	}
}
