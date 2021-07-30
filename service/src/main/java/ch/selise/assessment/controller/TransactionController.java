package ch.selise.assessment.controller;

import ch.selise.assessment.exception.BadRequestException;
import ch.selise.assessment.model.request.TransactionRequest;
import ch.selise.assessment.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TransactionController extends BaseController {

    private final TransactionService service;

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Application is running");
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> transaction(@Validated @RequestBody TransactionRequest request,
                                              BindingResult result){

        if(result.hasErrors())
            throw new BadRequestException(
                    super.getJoinedErrorMessage(result)
            );

        return ResponseEntity.ok(
                service.transaction(request));
    }
}
