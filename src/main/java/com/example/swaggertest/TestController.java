package com.example.swaggertest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Operation(summary = "get mapping method")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "found the book",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)
    })
    @GetMapping("/test")
    public ResponseEntity<String> getMethod(@RequestParam(name = "userId")String userId){
        return ResponseEntity.ok(userId);
    }
    @PutMapping("/putMethod")
    public ResponseEntity<String> putMethod(@RequestParam(name = "userId")String userId){
        return ResponseEntity.ok(userId);
    }
    @PostMapping("/postMapping")
    public ResponseEntity<String> postMethod(@RequestBody String userId){
        return ResponseEntity.ok(userId);
    }
    @DeleteMapping("/delete-mapping")
    public ResponseEntity<String> deleteMethod(@RequestParam(name = "userId")String userId){
        return ResponseEntity.ok(userId);
    }
}
