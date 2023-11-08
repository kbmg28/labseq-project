package br.com.kbmg.wslabseq.controller;

import br.com.kbmg.wslabseq.model.LabSeqResponse;
import br.com.kbmg.wslabseq.service.LabSeqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labseq")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class LabSeqController {

    private final LabSeqService labSeqService;

    @GetMapping("/{n}")
    public ResponseEntity<LabSeqResponse> getLabSeqResult(@PathVariable("n") Integer valueToCalculate) {
        if (valueToCalculate < 0) {
            return new ResponseEntity<>(new LabSeqResponse("Param must be greater than or equal to zero"),
                    HttpStatus.BAD_REQUEST);
        }

        String result = labSeqService.getResultValue(valueToCalculate).toString();

        return new ResponseEntity<>(new LabSeqResponse(result), HttpStatus.OK);
    }

}
