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


    public void joinprocess(JoinDTO dto){
        String id = dto.getId();
        String password = dto.getPassword();

        Boolean isExist = userRepository.existsById(id);

        if(isExist){
            return;
        }

        User data = new User();

        data.setId(id);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}