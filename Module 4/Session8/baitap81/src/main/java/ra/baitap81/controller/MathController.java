package ra.baitap81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap81.service.MathService;

@RestController
@RequestMapping("/api/math")
public class MathController {
    @Autowired
    private MathService mathService;

    @GetMapping("divide")
    public ResponseEntity<?> divideTwoNumbers(
            @RequestParam("a") double a,
            @RequestParam("b") double b
    ) {
        return new ResponseEntity<>(mathService.divide(a,b), HttpStatus.OK);
    }
}
