// package com.gruntech.project_management.controllers;

// import com.gruntech.project_management.security.User;
// import com.gruntech.project_management.security.UserRepository;

// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/users")
// @RequiredArgsConstructor
// public class uc {

//     private final UserRepository userRepository;

//     @GetMapping
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     @PostMapping
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User savedUser = userRepository.save(user);
//         return ResponseEntity.ok(savedUser);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         Optional<User> user = userRepository.findById(id);
//         return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//         return userRepository.findById(id).map(user -> {
//             user.setEmail(updatedUser.getEmail());
//             user.setPassword(updatedUser.getPassword());
//             user.setRole(updatedUser.getRole());
//             return ResponseEntity.ok(userRepository.save(user));
//         }).orElse(ResponseEntity.notFound().build());
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//         if (userRepository.existsById(id)) {
//             userRepository.deleteById(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
