package jp.co.fnj.storage.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * サンプルcontroller
 *
 */
@RestController
@RequestMapping(value = "/")
public class SampleController {

	@GetMapping(value = "hello")
	public ResponseEntity<String> get() {

		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}