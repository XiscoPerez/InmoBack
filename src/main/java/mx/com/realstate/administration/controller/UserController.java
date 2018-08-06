package mx.com.realstate.administration.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import mx.com.realstate.administration.dto.UserDto;
import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.User;
import mx.com.realstate.administration.service.UserService;
import mx.com.realstate.administration.utils.RealStateUtils;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "createUser", tags = { "User" })
    @PostMapping(path = "/realstate/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@Valid @RequestBody final UserDto userDto, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(RealStateUtils.getMessages(bindingResult.getFieldErrors()), HttpStatus.BAD_REQUEST, userDto.toString());
        }
        if (userService.exist(userDto.getUsername())) {
            throw new BusinessException("Username exist", HttpStatus.BAD_REQUEST, userDto.toString());
        }
        return convertToDto(userService.save(convertToEntity(userDto)));
    }

    @ApiOperation(value = "findByUsername", tags = { "User" })
    @GetMapping(path = "/realstate/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findByUsername(@PathVariable final String username) throws BusinessException {
        Optional<User> user = userService.findById(username);
        if (!user.isPresent()) {
            throw new BusinessException("Username exist", HttpStatus.BAD_REQUEST, username);
        }
        return convertToDto(user.get());
    }

    private User convertToEntity(final UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertToDto(final User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
