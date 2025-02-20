package kick.kickdeal_back.controller;

import kick.kickdeal_back.dto.JoinDTO;
import kick.kickdeal_back.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(@RequestBody JoinDTO joinDTO) {
        return joinService.joinprocess(joinDTO);
    }

}
