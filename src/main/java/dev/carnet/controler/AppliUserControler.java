package dev.carnet.controler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carnet.dto.CreerUserDto;
import dev.carnet.entity.AppliUser;
import dev.carnet.entity.Role;
import dev.carnet.exception.CodeErreur;
import dev.carnet.exception.MessageDto;
import dev.carnet.exception.UserException;
import dev.carnet.service.AppliUserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class AppliUserControler {
	
	private AppliUserService userService;
	
	
	public AppliUserControler(AppliUserService userService) {
		this.userService = userService;
	}
	
	//get user connecté
	@GetMapping("me")
	@Secured(value = "ROLE_UTILISATEUR, ROLE_ADMINISTRATEUR")
	private AppliUser getUserConnecte() {
		String pseudo = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findByPseudo(pseudo).get();
	}

	// Get getUserByUuid()
	/**
	@GetMapping("{uuid}")
	@Secured(value = "ROLE_UTILISATEUR, ROLE_ADMINISTRATEUR")
	public AppliUser getUserByUuid(@PathVariable UUID uuid) {
		return userService.findByUuid(uuid).get();
	}*/
	
	// Post newUser()
	@PostMapping
	public ResponseEntity<?> postNewUser(@RequestBody @Valid CreerUserDto userDto, BindingResult result){
		try {
			Optional<AppliUser> userOpt = userService.findByPseudo(userDto.getPseudo());
			Optional<AppliUser> userOpt2 = userService.findByEmail(userDto.getEmail());
			
			if(userOpt.isPresent()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ce pseudo est déjà utilisé !");
			}
			else if(userOpt2.isPresent()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cet email est déjà utilisé !");
			}
			else {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			    String password = userDto.getPassword();
			    String encodedPassword = passwordEncoder.encode(password);
				
				AppliUser newUser = userService.creer(userDto.getPseudo(), encodedPassword, userDto.getEmail(),
						Role.valueOf(userDto.getRole()));
				return ResponseEntity.ok(newUser);
			}
			
		}
		catch (RuntimeException e) {
			UserException erreur = new UserException(new MessageDto(CodeErreur.VALIDATION, "Erreur de requete, arguments insufisants !"));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erreur.getMessageErreur());
		}
	}

}
