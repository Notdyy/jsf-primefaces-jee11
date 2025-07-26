package my.example.jakarta.model;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

@Data
public class HelloModel implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String message;

}
