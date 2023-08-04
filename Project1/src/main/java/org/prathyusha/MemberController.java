package org.prathyusha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        // Validate member information (you can add validation logic here)
        // For example, check if the required fields are provided.

        // Save the member to the database
        Member savedMember = memberRepository.save(member);

        // Return the saved member in the response body
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }
}
