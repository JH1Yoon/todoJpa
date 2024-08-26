package com.sparta.todo.controller;

import com.sparta.todo.dto.UserRequestDto;
import com.sparta.todo.dto.UserResponseDto;
import com.sparta.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 생성
    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequestDto));
    }


    // 특정 id에 해당하는 유저 조회
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    // 모든 유저 조회
    @GetMapping("/user")
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    // 특정 id에 해당하는 유저 수정
    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userRequestDto));
    }

    // 특정 id에 해당하는 유저 삭제
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
