package kick.kickdeal_back.service;

import kick.kickdeal_back.dto.JoinDTO;
import kick.kickdeal_back.entity.User;
import kick.kickdeal_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public String joinprocess(JoinDTO dto) {
        if (userRepository.existsById(dto.getId())) {
            return "fail";
        }

        User user = new User();
        user.setId(dto.getId());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
        return "ok";
    }
}