package com.example.pathvarialbesplit.controller;

import com.example.pathvarialbesplit.domain.Symbol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SymbolController {

    @GetMapping(value="/symbols/{symbol:.+}")
    public ResponseEntity<Symbol> symbol(@PathVariable String symbol) {
        String[] symbols = symbol.split(",");
        if (symbols.length == 1) {
            Symbol s = new Symbol.SymbolBuild().symbolId(1)
                                        .name("Symbol1")
                                        .excode("TSX")
                                        .build();

            return new ResponseEntity<>(s, HttpStatus.OK);
        } else {
            Symbol s = new Symbol.SymbolBuild().symbolId(2)
                    .name("Symbol2")
                    .excode("TSX")
                    .build();

            return new ResponseEntity<>(s, HttpStatus.OK);
        }
    }
}
