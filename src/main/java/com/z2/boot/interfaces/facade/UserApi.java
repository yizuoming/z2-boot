package com.z2.boot.interfaces.facade;

import com.z2.boot.application.UserService;
import com.z2.boot.infrastructure.web.Response;
import com.z2.boot.interfaces.assembler.UserAssembler;
import com.z2.boot.interfaces.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yzm on 2019.
 */
@RestController
@RequestMapping("/auth")
@Slf4j
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response create(UserDTO userDTO) {
        try {
            userService.create(UserAssembler.toBo(userDTO));
            return Response.ok();
        } catch (Exception e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
    }

}
